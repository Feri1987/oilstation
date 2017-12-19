/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.dao;

import com.home.oilstation.entity.OilMaker;
import java.util.List;

/**
 *
 * @author Denis
 */
public interface OilMakerDAO {
    
    List<OilMaker> getAllOilMakers();
    OilMaker getOilMakersById(int id);
    
}
