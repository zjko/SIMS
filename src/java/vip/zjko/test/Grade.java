/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vip.zjko.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vip.zjko.util.DatabaseBean;

/**
 *
 * @author Administrator
 */
public class Grade {
    
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select * from grade");
            rs = psmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("gid") + " " + rs.getString("gname"));
            }
        } catch (SQLException ex) {

            Logger.getLogger(StudentTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);

        }

    }
}
