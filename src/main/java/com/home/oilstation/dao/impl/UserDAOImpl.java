/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.dao.impl;

import com.home.oilstation.dao.UserDAO;
import com.home.oilstation.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Denis
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private DataSource dataSource;
    
    private final String CREATEUSER = "INSERT INTO USER (NAME, PASSWORD) VALUES (?, ?)";
    private final String SETUSERROLE = "INSERT INTO USERS_ROLES (USER_ID, ROLE_ID) "
            + "VALUES ((SELECT u.id FROM oilproducts.user AS U \n"
            + "INNER JOIN oilproducts.users_roles AS UR\n"
            + "ON U.ID = UR.USER_ID\n"
            + "INNER JOIN oilproducts.role AS R\n"
            + "ON R.ID = UR.ROLE_ID\n"
            + "WHERE U.ID = ?), (SELECT R.ID FROM oilproducts.user AS U \n"
            + "INNER JOIN oilproducts.users_roles AS UR\n"
            + "ON U.ID = UR.USER_ID\n"
            + "INNER JOIN oilproducts.role AS R\n"
            + "ON R.ID = UR.ROLE_ID\n"
            + "WHERE R.ID = ?))";
    private final String DELETEUSER = "DELETE FROM USER WHERE ID = ?";
    private final String UPDATEUSER = "UPDATE USER SET USERNAME = ?, PASSWORD = ? WHERE ID = ?";
   
    public void createUser(User user) {
        Connection con = null;

        try {
            con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(CREATEUSER);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
    }
    
    public void setUserRole(User user, int id) {
        Connection con = null;

        try {
            con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(SETUSERROLE);
            ps = con.prepareStatement(SETUSERROLE);
            ps.setInt(1, user.getId());
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    public void deleteUser(int id) {
        Connection con = null;

        try {
            con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(DELETEUSER);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    public void updateUser(User user) {
        Connection con = null;

        try {
            con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATEUSER);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
    }
}
