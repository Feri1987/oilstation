/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.service;

import com.home.oilstation.entity.Oil;
import com.home.oilstation.entity.Order;

/**
 *
 * @author Denis
 */
public interface AdminService {
    
    Order getOrderById(int id);
    void updateOrderByOrderId(int id, Order order);
    void changeOrderStatusById(int id);
    void createCatalogs(Oil oil);
    
}
