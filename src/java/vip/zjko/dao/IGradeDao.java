/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vip.zjko.dao;

/**
 *
 * @author Administrator
 */
import java.util.List;
import vip.zjko.model.Grade;
/**
 * 班级数据访问接口
 * @author qixin
 */
public interface IGradeDao {    
    public List<Grade> getAll();
    public List<Grade> getSomeByMid(int mid);    
}

