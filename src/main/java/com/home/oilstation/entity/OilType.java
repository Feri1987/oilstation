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
public class OilType {
    
    private int id;
    private String name;

    public OilType() {
    }

    public OilType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OilType{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
