/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.service;

import com.home.oilstation.entity.Order;
import com.home.oilstation.entity.User;
import java.util.List;

/**
 *
 * @author Denis
 */
public interface OrdertService {
    
    void createOrder (Order order);
    void updateOrder (Order order);
    void registration (User user);
    void deleteOrder(int id);
    Order getOrderInfo(int id);
    List<Order> getHistoryOrders();
    
}
