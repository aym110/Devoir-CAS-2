package ma.store.orderservice.controller;

import ma.store.orderservice.dto.OrderDTO;
import ma.store.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping("/")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO){
        return new ResponseEntity<>(orderService.createOrder(orderDTO), HttpStatus.CREATED);
    }
}
