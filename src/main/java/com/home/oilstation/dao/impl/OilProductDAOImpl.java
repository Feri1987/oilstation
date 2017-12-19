/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.dao.impl;

import com.home.oilstation.dao.OilMakerDAO;
import com.home.oilstation.dao.OilProductDAO;
import com.home.oilstation.dao.OilTypeDAO;
import com.home.oilstation.entity.Oil;
import com.home.oilstation.entity.OilProduct;
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
public class OilProductDAOImpl implements OilProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OilMakerDAO oilMakerDAO;

    @Autowired
    private OilTypeDAO oilTypeDAO;

    private static final String CREATE_PRICELIST = "INSERT INTO oil_current_pricelist \n"
            + "(oil_makers_id, oil_types_id, PRICE) \n"
            + "VALUES ((SELECT ID FROM oil_makers WHERE oil_maker = ?),\n"
            + "(SELECT ID FROM oil_types WHERE oil_type = ?), ?)";
    private static final String CREATE_CATALOG = "INSERT INTO oil_catalog \n"
            + "(oil_makers_id, oil_types_id, oil_price) \n"
            + "VALUES ((SELECT ID FROM oil_makers WHERE oil_maker = ?),\n"
            + "(SELECT ID FROM oil_types WHERE oil_type = ?), ?)";
    private static final String DELETE = "DELETE FROM oil_current_pricelist WHERE ID = ?";
    private static final String UPDATE = "UPDATE oil_current_pricelist \n"
            + "set oil_makers_id = (SELECT ID FROM oil_makers WHERE oil_maker = ?), \n"
            + "oil_types_id = (SELECT ID FROM oil_types WHERE oil_type = ?), \n"
            + "PRICE = ? \n"
            + "WHERE ID = ?";
    private static final String GETALL = "SELECT ocp.id, om.oil_maker, ot.oil_type, ocp.price \n"
            + "FROM oilproducts.oil_makers AS om\n"
            + "INNER JOIN oilproducts.oil_current_pricelist AS ocp\n"
            + "ON om.id = ocp.oil_types_id\n"
            + "INNER JOIN oilproducts.oil_types AS ot\n"
            + "ON ot.id = ocp.oil_makers_id";
    private static final String GETONE = "SELECT ocp.id, om.oil_maker, ot.oil_type, ocp.price \n"
            + "FROM oilproducts.oil_makers AS om\n"
            + "INNER JOIN oilproducts.oil_current_pricelist AS ocp\n"
            + "ON om.id = ocp.oil_types_id\n"
            + "INNER JOIN oilproducts.oil_types AS ot\n"
            + "ON ot.id = ocp.oil_makers_id\n"
            + "WHERE ocp.id = ?";
    private static final String CLEAR_CURRENT_PRICELIST = "DELETE FROM oil_current_pricelist";

    @Override
    public void create(OilProduct oilProduct) {
        jdbcTemplate.update(CREATE_CATALOG, oilProduct.getOilMaker().getName(), oilProduct.getOilType().getName(), oilProduct.getPrice());
        jdbcTemplate.update(CREATE_PRICELIST, oilProduct.getOilMaker().getName(), oilProduct.getOilType().getName(), oilProduct.getPrice());

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<OilProduct> getListOil() {
        List<OilProduct> listOilProducts = jdbcTemplate.query(GETALL, new BeanPropertyRowMapper(OilProduct.class));

        return listOilProducts;
    }

    @Override
    public void update(OilProduct oilProduct) {
        jdbcTemplate.update(UPDATE, oilProduct.getOilMaker().getName(), oilProduct.getOilType().getName(), oilProduct.getPrice());
    }

    @Override
    public OilProduct getById(int id) {
        OilProduct oilProduct = (OilProduct) jdbcTemplate.queryForObject(GETONE, new Object[]{id}, new OilProductRowMapper());

        return oilProduct;
    }

    @Override
    public void createCatalog(Oil oil) {
        jdbcTemplate.execute(CLEAR_CURRENT_PRICELIST);
        
        for (OilProduct oilProduct : oil.getOilProducts()) {
            for(int i = 1; i <= oilTypeDAO.getAllOilTypes().size(); i++){
                if (oilProduct.getOilType().getName().equals(oilTypeDAO.getOilTypeById(i).getName())) {
                    for (int j = 1; j <= oilMakerDAO.getAllOilMakers().size(); j++) {
                        if (oilProduct.getOilMaker().getName().equals(oilMakerDAO.getOilMakersById(j).getName())) {
                            create(oilProduct);
                        }
                    }
                }
            }
        }
    }

}
