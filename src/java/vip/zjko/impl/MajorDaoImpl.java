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
import vip.zjko.dao.IMajorDao;
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
 * 专业数据访问接口实现类
 * @author qixin
 */
public class MajorDaoImpl implements IMajorDao{
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    
    @Override
    public List<Major> getAll() {
        List<Major> majors = new ArrayList<Major>();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select * from major order by mid asc");
            rs = psmt.executeQuery();
            while (rs.next()) {
                Major major = new Major();
                major.setMid(rs.getInt("mid"));
                major.setMname(rs.getString("mname"));
                major.setDirector(rs.getString("director"));
                major.setCount(rs.getInt("gradecount"));
                majors.add(major);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MajorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return majors;
    }    
}

