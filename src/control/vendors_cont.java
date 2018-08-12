
package control;

import static control.clients_cont.ob;
import java.util.Vector;
import model.clients_caps;
import model.clients_model;
import model.vendors_caps;
import model.vendors_model;


public class vendors_cont {
     static vendors_model ob=new vendors_model();
     
    public static void insert(vendors_caps obj){
        
        ob.insert(obj);
        
    }
    public  static void show_data(){
        ob.show_data();
        
    }
    
public  static void delete(vendors_caps obj){
    
    ob.delete(obj);
    
}

 
    
    public static void update(vendors_caps obj){
        ob.update(obj);
    }
    
    public static void search(vendors_caps obj){
        ob.search(obj);
        
    }
    
    public static void search_code(vendors_caps obj){
        
        ob.search_code(obj);
    }
    
    public static Vector add_validation(){
        
        return ob.add_validation();
    }


}

