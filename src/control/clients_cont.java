/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static control.workers_cont.ob;
import java.util.Vector;
import model.clients_caps;
import model.clients_model;

/**
 *
 * @author Enjoy
 */
public class clients_cont {
    static clients_model ob=new clients_model();
    
    public static void insert(clients_caps obj){
        
        ob.insert(obj);
        
    }
    
    public static void show_data(){
        
        ob.show_data();
    }
    
    public static void delete(clients_caps obj){
        
        ob.delete(obj);
    }
    
    public static void update(clients_caps obj){
        ob.update(obj);
    }
    
    public static void search(clients_caps obj){
        ob.search(obj);
        
    }
    
    public static void search_code(clients_caps obj){
        
        ob.search_code(obj);
    }
    
    public static Vector add_validation(){
        
        return ob.add_validation();
    }
    
}
