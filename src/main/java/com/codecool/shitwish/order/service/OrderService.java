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

        List<Order> orderList = orderRepo.findOrdersByUserIdAndStatus(userId, "OPEN");
        Order currentOrder;
        if(orderList.isEmpty()){
            currentOrder = new Order(userId);
        } else {
            currentOrder = orderList.get(0);
        }
        currentOrder.addProductId(productId);
        orderRepo.save(currentOrder);
        return currentOrder;
    }

    public Order deleteProductFromOrder(Long productId,Long userId){

        List<Order> orderList = orderRepo.findOrdersByUserIdAndStatus(userId, "OPEN");
        Order currentOrder;
        if(orderList.isEmpty()){
            throw new RuntimeException();
        } else {
            currentOrder = orderList.get(0);
        }
        currentOrder.removeProductId(productId);
        orderRepo.save(currentOrder);
        return currentOrder;
    }

    public Order closeOrder(Long userId){
        List<Order> orderList = orderRepo.findOrdersByUserIdAndStatus(userId, "OPEN");
        Order currentOrder;
        if(orderList.isEmpty()){
            throw new RuntimeException();
        } else {
            currentOrder = orderList.get(0);
        }
        currentOrder.setStatus("CLOSED");
        orderRepo.save(currentOrder);
        return currentOrder;
    }

}