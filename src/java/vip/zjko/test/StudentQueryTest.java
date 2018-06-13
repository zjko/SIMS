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
public class StudentQueryTest {
     public static void main(String[] args){
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement(
                    "select sno,sname,ssex,sage,year,mname,director \n" +
                    "from student join grade on student.gid = grade.gid inner join major on grade.mid = major.mid \n" +
                    "where major.mname = ? order by sno asc");
            psmt.setString(1,"计算机科学与技术");
            rs = psmt.executeQuery();
            while(rs.next()){
                System.out.println( 
                        rs.getString("sno")+"\t"+
                        rs.getString("sname")+"\t"+
                        rs.getString("ssex")+"\t"+
                        rs.getInt("sage")+"\t"+
                        rs.getString("year")+"\t"+
                        rs.getString("mname")+"\t"+
                        rs.getString("director")
                                
                                
                
                );
            }       
        } catch (SQLException ex) {
            
            Logger.getLogger(StudentTest.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            DatabaseBean.close(rs, psmt, conn);
            
        }
        
        
    }
}
