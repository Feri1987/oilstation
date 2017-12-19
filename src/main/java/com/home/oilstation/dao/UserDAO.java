/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.dao;

import com.home.oilstation.entity.User;

/**
 *
 * @author Denis
 */

public interface UserDAO {
    
    void createUser(User user);
    void setUserRole(User user, int id);
    void deleteUser(int id);
    void updateUser(User user);
    
}
