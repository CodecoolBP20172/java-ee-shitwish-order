package com.codecool.shitwish.order.api;

import com.codecool.shitwish.order.model.Order;
import com.codecool.shitwish.order.repository.OrderRepo;
import com.codecool.shitwish.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class OrderControllerREST {

    @Autowired
    OrderService orderService;

    @PutMapping(value = "/add-product-to-order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addProductToOrder(@RequestBody OrderRequest request){
        Order order = orderService.addProductToOrder(request.getProductId(), request.getUserId());
        return ResponseEntity.ok(order);
    }

    @DeleteMapping(value = "/delete-product-from-order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity deleteProductFromOrder(@RequestBody OrderRequest request){
        Order order = orderService.deleteProductFromOrder(request.getProductId(), request.getUserId());
        return ResponseEntity.ok(order);
    }

    @PutMapping(value = "/close-order/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity closeOrder(@PathVariable Long userId){
        Order order = orderService.closeOrder(userId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/get-active-order/{userId}")
    public ResponseEntity getActiveOrder(@PathVariable Long userId) {
        Order order = orderService.getActiveOrder(userId);
        return ResponseEntity.ok(order);
    }
}
