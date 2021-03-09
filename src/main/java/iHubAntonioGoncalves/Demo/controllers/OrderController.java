package iHubAntonioGoncalves.Demo.controllers;

import iHubAntonioGoncalves.Demo.modelsDto.OrderModelDto;
import iHubAntonioGoncalves.Demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping()
    private List<OrderModelDto> getAllOrders(){
        return orderService.getAllOrders();
    }
}
