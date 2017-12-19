/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.dao.impl;

import com.home.oilstation.entity.OilType;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Denis
 */
public class OilTypeRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        
        OilType oilType = new OilType();
        
        oilType.setId(rs.getInt("id"));
        oilType.setName(rs.getString("oil_type"));
        return oilType;

    }
}
