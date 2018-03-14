///*
//package com.codecool.shitwish.order.model;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//import javax.persistence.*;
//
//@Entity
//public class LineItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    private Order order;
//
//    @Column(name = "product_id")
//    private Long productId;
//
//    private int quantity;
//
//    public LineItem(Order order, Long productId, int quantity) {
//        this.order = order;
//        this.productId = productId;
//        this.quantity = quantity;
//    }
//
//    public LineItem() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public Long getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Long productId) {
//        this.productId = productId;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//}
//*/
