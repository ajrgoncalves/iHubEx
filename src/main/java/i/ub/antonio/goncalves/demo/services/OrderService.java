package i.ub.antonio.goncalves.demo.services;

import i.ub.antonio.goncalves.demo.mappers.OrderMapper;
import i.ub.antonio.goncalves.demo.models.OrderModel;
import i.ub.antonio.goncalves.demo.modelsDto.CreateOrderModelDto;
import i.ub.antonio.goncalves.demo.modelsDto.OrderModelDto;
import i.ub.antonio.goncalves.demo.repositories.OrderRepository;
import i.ub.antonio.goncalves.demo.repositories.ProductRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ProductRepository productRepository;

    public List<OrderModelDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> orderMapper.mapperToDto(order)).collect(Collectors.toList());
    }

    public List<OrderModelDto> getAllOrdersDeleted() {
        return orderRepository.findByActive(false).stream()
                .map(order -> orderMapper.mapperToDto(order)).collect(Collectors.toList());
    }

    public List<OrderModelDto> getAllOrdersActive() {
        return orderRepository.findByActive(true).stream()
                .map(order -> orderMapper.mapperToDto(order)).collect(Collectors.toList());
    }

    public OrderModel getOrderModelById(Long id) throws NotFoundException {
        return orderRepository.findById(id)
                .orElseThrow(() -> new org.webjars.NotFoundException("Order not found for id: %d" + id));
    }


    public CreateOrderModelDto save(CreateOrderModelDto createOrderModelDto) {

        OrderModel orderModel = orderMapper.mapperFromDtoCreate(createOrderModelDto);

        createOrderModelDto.getProductIds().forEach(productId ->orderModel.getProducts()
                .add(productRepository.findById(productId)
                        .orElseThrow(() -> new org.webjars.NotFoundException("An error occurred when adding product to order")
        )));

        orderRepository.save(orderModel);

        return orderMapper.mapperToDtoCreate(orderModel);
    }

    public void delete(Long id) throws NotFoundException {
        OrderModel orderModel = orderRepository.findById(id)
                .orElseThrow(() -> new org.webjars.NotFoundException("Order not found for id: %d" + id));
        orderModel.setActive(true);
        orderRepository.save(orderModel);
//        orderRepository.deleteById(id);
    }

    public void recover(Long id) throws NotFoundException {
        OrderModel orderModel = orderRepository.findById(id)
                .orElseThrow(() -> new org.webjars.NotFoundException("Order not found for id: %d" + id));
        orderModel.setActive(false);
        orderRepository.save(orderModel);
    }
}
