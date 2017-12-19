/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.service.impl;

import com.home.oilstation.dao.OrderDAO;
import com.home.oilstation.dao.UserDAO;
import com.home.oilstation.entity.Order;
import com.home.oilstation.entity.User;
import com.home.oilstation.service.OrdertService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Denis
 */
//@Component
public class OrdertServiceImpl implements OrdertService{
    
    @Autowired
    private OrderDAO orderDAO;
    
    @Autowired
    private UserDAO userDAO ;

    public void createOrder(Order order) {
        orderDAO.createOrder(order);
    }

    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    public void deleteOrder(int id) {
        orderDAO.deleteOrder(id);
    }

    public Order getOrderInfo(int id) {
        return orderDAO.getOrderById(id);
    }

    public List<Order> getHistoryOrders() {
        return orderDAO.getAllOrders();
    }

    public void registration(User user) {
        userDAO.createUser(user);
        
    }
    
}
