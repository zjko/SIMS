/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vip.zjko.dao;

/**
 *
 * @author Administrator
 */
import vip.zjko.model.User;
public interface IUserDao {
    public User selectUser(String username, String password);    
}

