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
import vip.zjko.dao.IGradeDao;
import vip.zjko.model.Grade;
import vip.zjko.model.Major;
import vip.zjko.util.DatabaseBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 班级数据访问接口实现类
 * @author qixin
 */
public class GradeDaoImpl implements IGradeDao{
    
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    public List<Grade> getAll() {
        List<Grade> grades = new ArrayList<Grade>();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select * from grade join major on grade.mid = major.mid order by gid asc");
            rs = psmt.executeQuery();
            while (rs.next()) {
                Grade grade = new Grade();
                grade.setGid(rs.getInt("gid"));
                grade.setGname(rs.getString("gname"));
                grade.setYear(rs.getString("year"));
                grade.setCount(rs.getInt("stucount"));
                Major major = new Major();
                major.setMid(rs.getInt("mid"));
                major.setMname(rs.getString("mname"));
                major.setDirector(rs.getString("director"));
                grade.setMajor(major);
                grades.add(grade);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return grades;
    }

    @Override
    public List<Grade> getSomeByMid(int mid) {
        List<Grade> grades = new ArrayList<Grade>();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select * from grade join major on grade.mid = major.mid where major.mid = ? order by gid asc");
            psmt.setInt(1, mid);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Grade grade = new Grade();
                grade.setGid(rs.getInt("gid"));
                grade.setGname(rs.getString("gname"));
                grade.setYear(rs.getString("year"));
                grade.setCount(rs.getInt("stucount"));
                Major major = new Major();
                major.setMid(rs.getInt("mid"));
                major.setMname(rs.getString("mname"));
                major.setDirector(rs.getString("director"));
                grade.setMajor(major);
                grades.add(grade);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return grades;
    }    
}
