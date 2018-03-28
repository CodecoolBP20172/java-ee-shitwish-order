package com.codecool.shitwish.order.service;

import com.codecool.shitwish.order.model.Order;
import com.codecool.shitwish.order.repository.OrderRepo;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class OrderService {

    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order addProductToOrder(Long productId,Long userId){

        Order order = orderRepo.findOrderByUserIdAndStatus(userId, "OPEN");
        if(order == null){
            order = new Order(userId);
        }
        order.addProductId(productId);
        orderRepo.save(order);
        return order;
    }


    public Order deleteProductFromOrder(Long productId,Long userId){

        Order order = orderRepo.findOrderByUserIdAndStatus(userId, "OPEN");
        Order currentOrder;
        if(order == null){
            throw new RuntimeException();
        }
        order.removeProductId(productId);
        orderRepo.save(order);
        return order;
    }

    public Order closeOrder(Long userId){
        Order order = orderRepo.findOrderByUserIdAndStatus(userId, "OPEN");
        if(order == null){
            throw new RuntimeException();
        }
        order.setStatus("CLOSED");
        orderRepo.save(order);
        return order;
    }

    public Order getActiveOrder(Long userId) {
        return orderRepo.findOrderByUserIdAndStatus(userId, "OPEN");
    }
}

