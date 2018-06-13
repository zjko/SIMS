/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vip.zjko.util;

/**
 *
 * @author Administrator
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import vip.zjko.config.DB;

public class DatabaseBean {
    
    public static Connection getConnection() {
        Connection conn = null;
   
        
        try {
            Class.forName(DB.DRVIER);
            conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
    
    public static void close(ResultSet rs, Statement st, Connection conn) {
        try {
            if(rs!=null) {
                rs.close();
            }
            if(st != null) {
                st.close();
            }
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
