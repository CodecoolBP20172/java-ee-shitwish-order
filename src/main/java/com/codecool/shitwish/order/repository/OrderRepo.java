package com.codecool.shitwish.order.repository;

import com.codecool.shitwish.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    Order findOrderByUserIdAndStatus(Long userId, String status);
}
