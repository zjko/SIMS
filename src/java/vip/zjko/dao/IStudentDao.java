/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vip.zjko.dao;

import java.util.List;
import vip.zjko.model.Student;
import vip.zjko.util.Pagination;

/**
 *
 * @author Administrator
 */
public interface IStudentDao {    
    public List<Student> getAll(Pagination pagination);
    public List<Student> getSomeByMid(int mid, Pagination pagination);
    public List<Student> getSomeByGid(int gid);    
    public List<Student> getSomeBySno(String sno, Pagination pagination);
    public Student getOneBySno(String sno);
    public void insertStudent(Student stu);
    public void deleteStudent(String sno);
    public void updateStudent(Student stu);
}
