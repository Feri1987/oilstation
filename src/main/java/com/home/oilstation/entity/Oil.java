/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.entity;

import java.util.List;

/**
 *
 * @author Denis
 */
public class Oil {
    
    private List<OilType> oilTypes;
    private List<OilMaker> oilMaker;
    private List<OilProduct> oilProducts;

    public Oil() {
    }

    public Oil(List<OilType> oilTypes, List<OilMaker> oilMaker, List<OilProduct> oilProducts) {
        this.oilTypes = oilTypes;
        this.oilMaker = oilMaker;
        this.oilProducts = oilProducts;
    }

    public List<OilType> getOilTypes() {
        return oilTypes;
    }

    public void setOilTypes(List<OilType> oilTypes) {
        this.oilTypes = oilTypes;
    }

    public List<OilMaker> getOilMaker() {
        return oilMaker;
    }

    public void setOilMaker(List<OilMaker> oilMaker) {
        this.oilMaker = oilMaker;
    }

    public List<OilProduct> getOilProducts() {
        return oilProducts;
    }

    public void setOilProducts(List<OilProduct> oilProducts) {
        this.oilProducts = oilProducts;
    }
    
    
    
}
