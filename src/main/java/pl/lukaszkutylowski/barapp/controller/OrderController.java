package pl.lukaszkutylowski.barapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszkutylowski.barapp.model.Order;
import pl.lukaszkutylowski.barapp.payload.PayloadOrder;
import pl.lukaszkutylowski.barapp.service.OrderService;

@RestController
public class OrderController {

    private OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody PayloadOrder payloadOrder) {
        Order savedOrder = service.createOrder(payloadOrder);
        return ResponseEntity.ok().body(savedOrder);
    }
}
