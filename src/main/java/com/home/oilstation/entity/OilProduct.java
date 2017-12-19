/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.entity;

import java.math.BigDecimal;

/**
 *
 * @author Denis
 */
public class OilProduct {

    private int id;
    private OilMaker oilMaker;
    private OilType oilType;
    private BigDecimal price;

    public OilProduct() {
    }

    public OilProduct(int id, OilMaker oilMaker, OilType oilType, BigDecimal price) {
        this.id = id;
        this.oilMaker = oilMaker;
        this.oilType = oilType;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OilMaker getOilMaker() {
        return oilMaker;
    }

    public void setOilMaker(OilMaker oilMaker) {
        this.oilMaker = oilMaker;
    }

    public OilType getOilType() {
        return oilType;
    }

    public void setOilType(OilType oilType) {
        this.oilType = oilType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OilProduct{" + "id=" + id + ", oilMaker=" + oilMaker + ", oilType=" + oilType + ", price=" + price + '}';
    }
    
    
}
