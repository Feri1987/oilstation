/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.entity;

/**
 *
 * @author Denis
 */
public class OrderItem {
    
    private int id;
    private OilProduct oilProduct;
    private int count;

    public OrderItem() {
    }

    public OrderItem(int id, OilProduct oilProduct, int count) {
        this.id = id;
        this.oilProduct = oilProduct;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OilProduct getOilProduct() {
        return oilProduct;
    }

    public void setOilProduct(OilProduct oilProduct) {
        this.oilProduct = oilProduct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "id=" + id + ", oilProduct=" + oilProduct + ", count=" + count + '}';
    }
    
    
}
