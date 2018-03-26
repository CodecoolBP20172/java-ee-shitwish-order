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

    @PostMapping(value = "/add-product-to-order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addProductToOrder(@RequestBody OrderRequest request){
        System.out.println(request.getProductId());
        Order order = orderService.addProductToOrder(request.getProductId(), request.getUserId());
        return ResponseEntity.ok(order);
    }

}
