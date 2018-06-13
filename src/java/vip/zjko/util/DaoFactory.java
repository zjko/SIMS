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

import vip.zjko.dao.IGradeDao;
import vip.zjko.dao.IMajorDao;
import vip.zjko.dao.IStudentDao;
import vip.zjko.dao.IUserDao;
import vip.zjko.impl.GradeDaoImpl;
import vip.zjko.impl.MajorDaoImpl;
import vip.zjko.impl.StudentDaoImpl;
import vip.zjko.impl.UserDaoImpl;
/**
 * 数据访问工厂类
 * @author qixin
 */
public class DaoFactory {    
    public static IStudentDao getStudentDao() {
        return new StudentDaoImpl();
    }    
    public static IMajorDao getMajorDao() {
        return new MajorDaoImpl();
    }    
    public static IGradeDao getGradeDao() {
        return new GradeDaoImpl();
    }    
    public static IUserDao getUserDao() {
        return new UserDaoImpl();
    }

}
