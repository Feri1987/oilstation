/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.dao.impl;

import com.home.oilstation.entity.OilMaker;
import com.home.oilstation.entity.OilProduct;
import com.home.oilstation.entity.OilType;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Denis
 */
public class OilProductRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        
        OilProduct oilProduct = new OilProduct();
        OilMaker oilMaker = new OilMaker();
        OilType oilType = new OilType();
        
        oilProduct.setId(rs.getInt("id"));
        
        oilMaker.setName(rs.getString("om.oil_maker"));
        oilType.setName(rs.getString("ot.oil_type"));
        oilProduct.setOilType(oilType);
        oilProduct.setOilMaker(oilMaker);
        
        oilProduct.setPrice(rs.getBigDecimal("price"));
        return oilProduct;

    }

}
