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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vip.zjko.model.Student;
import vip.zjko.util.DaoFactory;
import vip.zjko.util.DatabaseBean;
import vip.zjko.util.Pagination;

/**
 *
 * @author Administrator
 */
public class StudentTest {
    
    public static void main(String[] args){
       Pagination pagination = new Pagination();
       pagination.setPageNo(1);
       List<Student> studentList = DaoFactory.getStudentDao().getAll(pagination);
       
       for(Student student: studentList){
           System.out.println(student.getSno()+student.getSname()+student.getSsex());
       }
        
    }
            
}
