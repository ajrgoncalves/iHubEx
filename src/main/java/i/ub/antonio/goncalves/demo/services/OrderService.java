package i.ub.antonio.goncalves.demo.services;

import i.ub.antonio.goncalves.demo.mappers.OrderMapper;
import i.ub.antonio.goncalves.demo.mappers.ProductMapper;
import i.ub.antonio.goncalves.demo.models.Product;
import i.ub.antonio.goncalves.demo.modelsDto.ProductDto;
import i.ub.antonio.goncalves.demo.repositories.OrderRepository;
import i.ub.antonio.goncalves.demo.models.OrderModel;
import i.ub.antonio.goncalves.demo.modelsDto.OrderModelDto;
import i.ub.antonio.goncalves.demo.repositories.ProductRepository;
import javassist.NotFoundException;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductService productService;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductRepository productRepository;

    public List<OrderModelDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> orderMapper.mapperToDto(order)).collect(Collectors.toList());
    }

    public List<OrderModelDto> getAllOrdersDeleted() {
        return orderRepository.findByDeleted(true).stream()
                .map(order -> orderMapper.mapperToDto(order)).collect(Collectors.toList());
    }

    public List<OrderModelDto> getAllOrdersActive() {
        return orderRepository.findByDeleted(false).stream()
                .map(order -> orderMapper.mapperToDto(order)).collect(Collectors.toList());
    }

    public OrderModel getOrderModelById(Long id) throws NotFoundException {
        return orderRepository.findById(id)
                .orElseThrow(() -> new org.webjars.NotFoundException("Order not found for id: %d" + id));
    }


    public OrderModelDto save(OrderModelDto orderModelDto) {
        //Need to map orderModel, save, and then convert back to a Dto

        OrderModel orderModel = orderMapper.mapperFromDto(orderModelDto);

        orderModelDto.getProductIds().forEach(productId ->orderModel.getProducts().add(productRepository.findById(productId).orElseThrow(
                () -> new org.webjars.NotFoundException("An error occured when adding product to order")
        )));

        orderRepository.save(orderModel);

        return orderMapper.mapperToDto(orderModel);
    }

    public void delete(Long id) throws NotFoundException {
        OrderModel orderModel = orderRepository.findById(id).get();
        orderModel.setDeleted(true);
        orderRepository.save(orderModel);
//        orderRepository.deleteById(id);
    }

    public void recover(Long id) throws NotFoundException {
        OrderModel orderModel = orderRepository.findById(id).get();
        orderModel.setDeleted(false);
        orderRepository.save(orderModel);
    }
}
