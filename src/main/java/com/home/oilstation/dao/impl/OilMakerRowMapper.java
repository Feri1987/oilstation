/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.dao.impl;

import com.home.oilstation.entity.OilMaker;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Denis
 */
public class OilMakerRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        
        OilMaker oilMaker = new OilMaker();
        
        oilMaker.setId(rs.getInt("id"));
        oilMaker.setName(rs.getString("oil_maker"));
        return oilMaker;

    }
}
