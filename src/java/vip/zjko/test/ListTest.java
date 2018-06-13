/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vip.zjko.test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ListTest {
    
    
    public static void main(String []args){
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        
        for(Integer o:list){
            System.out.println(o);
        }
        
    }
    
}
