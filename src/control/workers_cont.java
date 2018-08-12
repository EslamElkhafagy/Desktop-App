/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Vector;
import model.workers_caps;
import model.workers_model;

/**
 *
 * @author Enjoy
 */
public class workers_cont {
    static workers_model ob=new workers_model();
    
    public static void insert(workers_caps obj){
        
        ob.insert(obj);
        
    }
    
    public static void dalete(workers_caps obj){
        
        ob.delete(obj);
    }
    
    public static void showdata(){
        
        ob.show_data();
    }
    
    public static void update(workers_caps obj){
        
        ob.update(obj);
    }
    
    public static void search(workers_caps obj){
        ob.search(obj);
        
        
    }
    
    public static void search_code(workers_caps obj){
        
        ob.search_code(obj);
    }
    
    public static Vector add_validation(){
        
        return ob.add_validation();
    }
}
