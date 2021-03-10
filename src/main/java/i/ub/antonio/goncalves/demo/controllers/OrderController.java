package i.ub.antonio.goncalves.demo.controllers;

import i.ub.antonio.goncalves.demo.modelsDto.OrderModelDto;
import i.ub.antonio.goncalves.demo.services.OrderService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/deleted")
    private List<OrderModelDto> getAllOrdersDeleted(){
        return orderService.getAllOrdersDeleted();
    }

    @GetMapping(path = "/active")
    private List<OrderModelDto> getAllOrdersActive(){
        return orderService.getAllOrdersActive();
    }

    @PostMapping()
    private OrderModelDto addOrder(@RequestBody OrderModelDto orderModelDto){
        return orderService.save(orderModelDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) throws NotFoundException {
        orderService.delete(id);
    }

    @PostMapping("/recover/{id}")
    public void recover(@PathVariable Long id) throws NotFoundException {
        orderService.recover(id);
    }

    //TODO: Retrieving all orders within a given time period
}
