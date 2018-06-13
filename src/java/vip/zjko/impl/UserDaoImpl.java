/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vip.zjko.impl;

/**
 *
 * @author Administrator
 */
import vip.zjko.dao.IUserDao;
import vip.zjko.model.User;
import vip.zjko.util.DatabaseBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoImpl implements IUserDao{
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
        public User selectUser(String username, String password) {
        User user = null;

        try {
            conn = DatabaseBean.getConnection();
            String sql = "select * from users where username=? and password=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, username);
            psmt.setString(2, password);
            rs = psmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return user;
    }    
}

