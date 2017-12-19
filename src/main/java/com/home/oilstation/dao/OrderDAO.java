/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.dao;

import com.home.oilstation.entity.Oil;
import com.home.oilstation.entity.Order;
import java.util.List;

/**
 *
 * @author Denis
 */


public interface OrderDAO {

    public void createOrder(Order order);

    public void updateOrder(Order order);

    public void deleteOrder(int id);

    public Order getOrderById(int id);

    public List<Order> getAllOrders();

    public void updateOrderStatus(int orderId);

    public void createCatalogs(Oil oil);


    
}
