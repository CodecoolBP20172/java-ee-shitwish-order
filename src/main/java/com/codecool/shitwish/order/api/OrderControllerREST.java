package com.codecool.shitwish.order.api;

import com.codecool.shitwish.order.model.Order;
import com.codecool.shitwish.order.repository.OrderRepo;
import com.codecool.shitwish.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class OrderControllerREST {

    @Autowired
    OrderService orderService;

    @PutMapping(value = "/add-product-to-order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addProductToOrder(@RequestAttribute("productId") Long productId, @RequestAttribute("userId") Long userId ){
        Order order = orderService.addProductToOrder(productId, userId);
        return ResponseEntity.ok(order);
    }

}
