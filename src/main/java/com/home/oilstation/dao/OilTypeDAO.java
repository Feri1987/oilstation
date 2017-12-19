/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.dao;

import com.home.oilstation.entity.OilType;
import java.util.List;

/**
 *
 * @author Denis
 */
public interface OilTypeDAO {
    
    List<OilType> getAllOilTypes();
    OilType getOilTypeById(int id);
    
}
