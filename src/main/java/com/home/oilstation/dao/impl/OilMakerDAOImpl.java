/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.dao.impl;

import com.home.oilstation.dao.OilMakerDAO;
import com.home.oilstation.entity.OilMaker;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Denis
 */
@Repository
public class OilMakerDAOImpl implements OilMakerDAO{
    
    @Autowired
    private  JdbcTemplate jdbcTemplate;
    
    private static final String GET_BY_ID = "SELECT id, oil_maker FROM oil_makers WHERE id = ?";
    private static final String GETALLMAKERS = "SELECT id, oil_maker FROM oil_makers";


    public List<OilMaker> getAllOilMakers() {
        List<OilMaker> oilMakers = jdbcTemplate.query(GETALLMAKERS, new BeanPropertyRowMapper(OilMaker.class));

        return oilMakers;
    }

    public OilMaker getOilMakersById(int id) {
        OilMaker oilMaker = (OilMaker) jdbcTemplate.queryForObject(GET_BY_ID, new Object[]{id}, new OilMakerRowMapper());

        return oilMaker;
        
    }

}
