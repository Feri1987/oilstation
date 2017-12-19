/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.dao.impl;

import com.home.oilstation.dao.OrderItemDAO;
import com.home.oilstation.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Denis
 */
@Repository
public class OrderItemDAOImpl implements OrderItemDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String CREATE_ORDER_ITEM = "INSERT INTO oilproducts.order_item \n"
            + "(oil_current_pricelist_id, count)\n"
            + "VALUES ((select ocp.id from oil_current_pricelist as ocp\n"
            + "INNER JOIN oilproducts.oil_makers AS om\n"
            + "ON om.id = ocp.oil_makers_id\n"
            + "INNER JOIN oilproducts.oil_types AS ot\n"
            + "ON ot.ID = ocp.oil_types_id\n"
            + "where om.oil_maker = ? and ot.oil_type = ?), ?);";
    private static final String DELETE = "DELETE FROM oilproducts.order_item WHERE ID = ?";;

    public void create(OrderItem orderItem) {
        jdbcTemplate.update(CREATE_ORDER_ITEM, orderItem.getOilProduct().getOilMaker().getName(),
                orderItem.getOilProduct().getOilType().getName(), orderItem.getCount());
    }

    public void delete(int id) {
        jdbcTemplate.update(DELETE, id);
    }

}
