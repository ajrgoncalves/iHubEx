package i.ub.antonio.goncalves.demo.services;

import i.ub.antonio.goncalves.demo.mappers.OrderMapper;
import i.ub.antonio.goncalves.demo.repositories.OrderRepository;
import i.ub.antonio.goncalves.demo.models.OrderModel;
import i.ub.antonio.goncalves.demo.modelsDto.OrderModelDto;
import javassist.NotFoundException;
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
    OrderMapper orderMapper;

    public List<OrderModelDto> getAllOrders(){
        return orderRepository.findAll().stream()
                .map(order -> orderMapper.mapperToDto(order) ).collect(Collectors.toList());
    }

    public List<OrderModelDto> getAllOrdersDeleted(){
        return orderRepository.findByDeleted(true).stream()
                .map(order -> orderMapper.mapperToDto(order) ).collect(Collectors.toList());
    }

    public List<OrderModelDto> getAllOrdersActive(){
        return orderRepository.findByDeleted(false).stream()
                .map(order -> orderMapper.mapperToDto(order) ).collect(Collectors.toList());
    }


    public OrderModelDto save(OrderModelDto orderModelDto){
        //Need to map orderModel, save, and then convert back to a Dto
        OrderModel orderModel = orderMapper.mapperFromDto(orderModelDto);

        orderRepository.save(orderModel);

        return orderMapper.mapperToDto(orderModel);
    }

    public void delete(Long id) throws NotFoundException {
        //TODO: Need to implement the Change of status for the associated Product
        OrderModel orderModel = orderRepository.findById(id).get();
        orderModel.setDeleted(true);
        orderRepository.save(orderModel);
//        orderRepository.deleteById(id);
    }
}
