/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.dao.impl;

import com.home.oilstation.dao.OilTypeDAO;
import com.home.oilstation.entity.OilType;
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
public class OilTypeDAOImpl implements OilTypeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final String GET_BY_ID = "SELECT id, oil_type FROM oil_types WHERE id = ?";
    private static final String GETALLTYPES = "SELECT id, oil_type FROM oil_types";


    public List<OilType> getAllOilTypes() {
        List<OilType> oilTypes = jdbcTemplate.query(GETALLTYPES, new BeanPropertyRowMapper(OilType.class));

        return oilTypes;
    }

    public OilType getOilTypeById(int id) {
        OilType oilType = (OilType) jdbcTemplate.queryForObject(GET_BY_ID, new Object[]{id}, new OilTypeRowMapper());

        return oilType;
    }

}
