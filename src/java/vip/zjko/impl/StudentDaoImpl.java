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

import vip.zjko.dao.IStudentDao;
import vip.zjko.model.Grade;
import vip.zjko.model.Major;
import vip.zjko.model.Student;
import vip.zjko.util.DatabaseBean;
import vip.zjko.util.Pagination;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 学生数据访问接口实现类
 * @author qixin
 */
public class StudentDaoImpl implements IStudentDao {

    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    public List<Student> getAll(Pagination pagination) {
        List<Student> students = new ArrayList<Student>();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select count(*) as counts from student");
            rs = psmt.executeQuery();
            rs.next();
            //求总记录数
            pagination.setCountSize(rs.getInt("counts"));
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
            psmt = conn.prepareStatement("select * from (select rownum no,a.* from "
                    + "(select sno,sname,ssex,sage,student.gid,gname,year,major.mid,mname,director "
                    + "from student join grade on student.gid = grade.gid "
                    + "join major on grade.mid = major.mid order by sno asc) a "
                    + "where rownum<=?) where no>=?");
            psmt.setInt(1, end);
            psmt.setInt(2, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                Grade grade = new Grade();
                Major major = new Major();

                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));

                grade.setGid(rs.getInt("gid"));
                grade.setGname(rs.getString("gname"));
                grade.setYear(rs.getString("year"));

                major.setMid(rs.getInt("mid"));
                major.setMname(rs.getString("mname"));
                major.setDirector(rs.getString("director"));

                grade.setMajor(major);
                stu.setGrade(grade);
                students.add(stu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return students;
    }

    @Override
    public List<Student> getSomeByMid(int mid, Pagination pagination) {
        List<Student> students = new ArrayList<Student>();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select count(*) as counts from student join grade on student.gid = grade.gid join major on grade.mid = major.mid where major.mid = ?");
            psmt.setInt(1, mid);
            rs = psmt.executeQuery();
            rs.next();
            //求总记录数
            pagination.setCountSize(rs.getInt("counts"));
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
            psmt = conn.prepareStatement("select * from (select rownum no,a.* from "
                    + "(select sno,sname,ssex,sage,student.gid,gname,year,major.mid,mname,director "
                    + "from student join grade on student.gid = grade.gid "
                    + "join major on grade.mid = major.mid where major.mid = ? order by sno asc) a "
                    + "where rownum<=?) where no>=?");
            psmt.setInt(1, mid);
            psmt.setInt(2, end);
            psmt.setInt(3, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                Grade grade = new Grade();
                Major major = new Major();

                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));

                grade.setGid(rs.getInt("gid"));
                grade.setGname(rs.getString("gname"));
                grade.setYear(rs.getString("year"));

                major.setMid(rs.getInt("mid"));
                major.setMname(rs.getString("mname"));
                major.setDirector(rs.getString("director"));

                grade.setMajor(major);
                stu.setGrade(grade);
                students.add(stu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return students;
    }

    @Override
    public List<Student> getSomeByGid(int gid) {
        List<Student> students = new ArrayList<Student>();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select * from student join grade on student.gid = grade.gid join major on grade.mid = major.mid where student.gid=?");
            psmt.setInt(1, gid);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                Grade grade = new Grade();
                Major major = new Major();

                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));

                grade.setGid(rs.getInt("gid"));
                grade.setGname(rs.getString("gname"));
                grade.setYear(rs.getString("year"));

                major.setMid(rs.getInt("mid"));
                major.setMname(rs.getString("mname"));
                major.setDirector(rs.getString("director"));

                grade.setMajor(major);
                stu.setGrade(grade);
                students.add(stu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return students;
    }

    @Override
    public List<Student> getSomeBySno(String sno, Pagination pagination) {
        List<Student> students = new ArrayList<Student>();

        try {
            //统计总记录数
            conn = DatabaseBean.getConnection();
            String sql = "select count(*) as counts from student where sno like ?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, "%" + sno + "%");
            rs = psmt.executeQuery();
            rs.next();
            pagination.setCountSize(rs.getInt("counts"));
            //求指定显示的记录数
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;
            int perPage = pagination.getPageSize();
            int end = pagination.getPageNo() * perPage;
            sql = "select * from (select rownum no,a.* from "
                    + "(select sno,sname,ssex,sage,student.gid,gname,year,major.mid,mname,director "
                    + "from student join grade on student.gid = grade.gid "
                    + "join major on grade.mid = major.mid where sno like ? order by sno asc) a "
                    + "where rownum<=?) where no>=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, "%" + sno + "%");
            psmt.setInt(2, end);
            psmt.setInt(3, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                Grade grade = new Grade();
                Major major = new Major();

                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));

                grade.setGid(rs.getInt("gid"));
                grade.setGname(rs.getString("gname"));
                grade.setYear(rs.getString("year"));

                major.setMid(rs.getInt("mid"));
                major.setMname(rs.getString("mname"));
                major.setDirector(rs.getString("director"));

                grade.setMajor(major);
                stu.setGrade(grade);
                students.add(stu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return students;
    }

    @Override
    public Student getOneBySno(String sno) {
        Student stu = null;
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select * from student join grade on student.gid = grade.gid join major on grade.mid = major.mid where sno = ?");
            psmt.setString(1, sno);
            rs = psmt.executeQuery();
            if (rs.next()) {
                stu = new Student();
                Grade grade = new Grade();
                Major major = new Major();

                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));

                grade.setGid(rs.getInt("gid"));
                grade.setGname(rs.getString("gname"));
                grade.setYear(rs.getString("year"));

                major.setMid(rs.getInt("mid"));
                major.setMname(rs.getString("mname"));
                major.setDirector(rs.getString("director"));

                grade.setMajor(major);
                stu.setGrade(grade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return stu;
    }

    @Override
    public void insertStudent(Student stu) {
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("insert into student values(?,?,?,?,?)");
            psmt.setString(1, stu.getSno());
            psmt.setString(2, stu.getSname());
            psmt.setString(3, stu.getSsex());
            psmt.setInt(4, stu.getSage());
            psmt.setInt(5, stu.getGrade().getGid());
            psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
    }

    @Override
    public void deleteStudent(String sno) {
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("delete from student where sno=?");
            psmt.setString(1, sno);
            psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
    }

    @Override
    public void updateStudent(Student stu) {
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("update student set sname=?,ssex=?,sage=?,gid=? where sno=? ");
            psmt.setString(1, stu.getSname());
            psmt.setString(2, stu.getSsex());
            psmt.setInt(3, stu.getSage());
            psmt.setInt(4, stu.getGrade().getGid());
            psmt.setString(5, stu.getSno());
            psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
    }
}

