/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vip.zjko.dao;
import java.util.List;
import vip.zjko.model.Major;
/**
 * 专业数据访问接口
 * @author qixin
 */
public interface IMajorDao {    
    public List<Major> getAll();    
}
