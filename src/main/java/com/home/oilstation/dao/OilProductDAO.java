/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.dao;

import com.home.oilstation.entity.Oil;
import com.home.oilstation.entity.OilProduct;
import java.util.List;

/**
 *
 * @author Denis
 */
public interface OilProductDAO {

    void create(OilProduct oil);

    void delete(int id);

    void update(OilProduct oil);

    List<OilProduct> getListOil();

    OilProduct getById(int id);

    void createCatalog(Oil oil);

}
