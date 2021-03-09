package iHubAntonioGoncalves.Demo.services;

import iHubAntonioGoncalves.Demo.mappers.OrderMapper;
import iHubAntonioGoncalves.Demo.modelsDto.OrderModelDto;
import iHubAntonioGoncalves.Demo.repositories.OrderRepository;
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

    public List<OrderModelDto> getAllOrders(){
        return orderRepository.findAll().stream()
                .map(order -> orderMapper.mapperToDto(order) ).collect(Collectors.toList());
    }
}
