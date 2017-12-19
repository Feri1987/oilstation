/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Denis
 */
public class Order {
    
    private int orderId;
    private List<OrderItem> orderItem;
    private BigDecimal totalPrice;
    private User user;

    public Order() {
    }

    public Order(int orderId, List<OrderItem> orderItem, BigDecimal totalPrice, User user) {
        this.orderId = orderId;
        this.orderItem = orderItem;
        this.totalPrice = totalPrice;
        this.user = user;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", orderItem=" + orderItem + ", totalPrice=" + totalPrice + ", user=" + user + '}';
    }

    
    
}
