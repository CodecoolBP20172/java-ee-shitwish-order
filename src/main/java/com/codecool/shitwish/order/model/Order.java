package com.codecool.shitwish.order.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String status;

    @ElementCollection
    private Set<Long> productIds;

    public Set<Long> getProductIds() {
        return productIds;
    }

    public void addProductId(Long productId){
        this.productIds.add(productId);
    }

    public void removeProductId(Long productId){
        this.productIds.remove(productId);
    }

    public void setProductIds(Set<Long> productIds) {
        this.productIds = productIds;
    }

    public Order() {
        this.productIds = new LinkedHashSet<>();
        this.status = "OPEN";
        this.date = new Date();
    }

    public Order(Long userId) {
        this();
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
