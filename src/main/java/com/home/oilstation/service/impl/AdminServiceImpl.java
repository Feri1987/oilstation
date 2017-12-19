/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.service.impl;

import com.home.oilstation.dao.OrderDAO;
import com.home.oilstation.entity.Oil;
import com.home.oilstation.entity.Order;
import com.home.oilstation.service.AdminService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denis
 */
@Service
public class AdminServiceImpl implements AdminService{
    
    private OrderDAO orderDAO;

    public Order getOrderById(int orderId) {
        return orderDAO.getOrderById(orderId);
    }

    public void updateOrderByOrderId(int orderId, Order order) {
        orderDAO.updateOrder(order);
    }

    public void changeOrderStatusById(int orderId) {
        orderDAO.updateOrderStatus(orderId);
    }

    public void createCatalogs(Oil oil) {
        orderDAO.createCatalogs(oil);
    }
    
}
