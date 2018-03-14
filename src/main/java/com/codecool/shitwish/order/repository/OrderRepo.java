package com.codecool.shitwish.order.repository;

import com.codecool.shitwish.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findOrdersByUserIdAndStatus(@Param("userId") Long userId, @Param("status") String status);
    //List<Order> findOrdersByUserId(@Param("userId") Long userId);


}
