
package model;

import control.Db_Connection;
import control.clients_cont;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static model.workers_model.con;
import static model.workers_model.id;
import static model.workers_model.pre;
import static model.workers_model.res;

public class clients_model {
    clients_caps obj=new clients_caps();
       
     public static Connection con;
    
     public static PreparedStatement pre;
    public static ResultSet res;
    /*....................................................................*/
    
    
    public static void insert(clients_caps obj){
        
         con = new Db_Connection().getconnction();
         
        try {
            pre=con.prepareStatement("insert into clients(name,address,code,start_date,phone,phone2,notes) values (?,?,?,?,?,?,?);");
            pre.setString(1, obj.getName());
            pre.setString(2, obj.getAddress());
            pre.setString(3,obj.getCode());
            pre.setString(4,obj.getStart_date());
            pre.setString(5,obj.getPhone());
            pre.setString(6,obj.getPhone2());
            pre.setString(7,obj.getNotes());
             JOptionPane.showMessageDialog(null, "تم الاضافة ");
            pre.executeUpdate();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
    }
    
    public static void show_data(){
         con = new Db_Connection().getconnction();
         Vector v1= new Vector();
          Vector v3= new Vector();
            v1.addElement("الاسـم");
          v1.addElement("العنوان");
          v1.addElement("رقم التليفون");
           v1.addElement("كود");
           v1.addElement("تاريخ البدء");
           v1.addElement("رقم التليفون البديل");
             v1.addElement("ملاحظات");
         try {
  pre = con.prepareStatement("select name,address,phone,code,start_date,phone2,notes from clients ;");
   res = pre.executeQuery();
       while (res.next()) {
                Vector v2= new Vector();
                 
                 v2.addElement(res.getString(1));
                 v2.addElement(res.getString(2));
                 v2.addElement(res.getString(3));
                 v2.addElement(res.getString(4));
                 v2.addElement(res.getString(5));
                 v2.addElement(res.getString(6));
                 v2.addElement(res.getString(7));
                 v3.addElement(v2);
             }
             
   view.panal.clients.table.setModel(new DefaultTableModel(v3, v1));
             
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
         }
           
         
         
    }

    public static void delete(clients_caps obj){
        
          con = new Db_Connection().getconnction();
         
        try {
            pre = con.prepareStatement("delete from clients where code=?");
            pre.setString(1,obj.getCode());
            pre.execute();
            JOptionPane.showMessageDialog(null, "deleted ");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    public static int id(clients_caps obj){
        
         con = new Db_Connection().getconnction();
     
     
         try {
             pre=con.prepareStatement("select id from clients where code=?");
             pre.setString(1,obj.getCode());
             
             res=pre.executeQuery();
             while (res.next()) {                 
                 
                 return res.getInt("id");
             }
            
         } catch (Exception ex) {

         JOptionPane.showMessageDialog(null, ex);
         }
         return 0;
       
        
    }
    
    public static void update(clients_caps obj){

    int a=id(obj);
     con = new Db_Connection().getconnction();

        try {

           pre = con.prepareStatement("update clients set name=?,address=?,phone=?,code=?,start_date=?,phone2=?,notes=? where id=? ");
           pre.setString(1,obj.getName());
           pre.setString(2, obj.getAddress());
           pre.setString(3, obj.getPhone());
           pre.setString(4, obj.getCode());
           pre.setString(5, obj.getStart_date());
           pre.setString(6, obj.getPhone2());
           pre.setString(7, obj.getNotes());   
           pre.setInt(8,a);
       
            JOptionPane.showMessageDialog(null, "تم التعديل ");
            pre.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
        
    }
    
    public static Vector add_validation(){
    con = new Db_Connection().getconnction();
    
         try {
             pre = con.prepareStatement("select  name,phone,code from clients ");
             res=pre.executeQuery();
             Vector v=new Vector();
             
             while(res.next()){
                 v.addElement(res.getString(1));
                 v.addElement(res.getString(2));
                 v.addElement(res.getString(3));
                 
             }
            return v;
             
         } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
         }
    return null;
}
    
    public static void search(clients_caps obj){
     con = new Db_Connection().getconnction();
    
     Vector v1= new Vector();
          Vector v3= new Vector();
             
               
         v1.addElement("الاسـم");
          v1.addElement("العنوان");
          v1.addElement("رقم التليفون");
           v1.addElement("كود");
           v1.addElement("تاريخ البدء");
           v1.addElement("رقم التليفون البديل");
             v1.addElement("ملاحظات");
         
        
         try {
  pre = con.prepareStatement("select name,address,phone,code,start_date,phone2,notes from clients where name like '"+obj.getSearch()+"%'");
 
   res = pre.executeQuery();
   
             while (res.next()) {
                Vector v2= new Vector();
                 
                  v2.addElement(res.getString(1));
                 v2.addElement(res.getString(2));
                 v2.addElement(res.getString(3));
                 v2.addElement(res.getString(4));
                 v2.addElement(res.getString(5));
                 v2.addElement(res.getString(6));
                 v2.addElement(res.getString(7));
                 v3.addElement(v2);
             }
             
  view.panal.clients.table.setModel(new DefaultTableModel(v3, v1));
             
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
         }
           
    
    
    
}
    
    
    public static void search_code(clients_caps obj){
     con = new Db_Connection().getconnction();
    
     Vector v1= new Vector();
          Vector v3= new Vector();
             
               
         v1.addElement("الاسـم");
          v1.addElement("العنوان");
          v1.addElement("رقم التليفون");
           v1.addElement("كود");
           v1.addElement("تاريخ البدء");
           v1.addElement("رقم التليفون البديل");
             v1.addElement("ملاحظات");
         
        
         try {
  pre = con.prepareStatement("select name,address,phone,code,start_date,phone2,notes from clients where code like '"+obj.getSearch()+"%'");
 
   res = pre.executeQuery();
   
             while (res.next()) {
                Vector v2= new Vector();
                 
                  v2.addElement(res.getString(1));
                 v2.addElement(res.getString(2));
                 v2.addElement(res.getString(3));
                 v2.addElement(res.getString(4));
                 v2.addElement(res.getString(5));
                 v2.addElement(res.getString(6));
                 v2.addElement(res.getString(7));
                 v3.addElement(v2);
             }
             
  view.panal.clients.table.setModel(new DefaultTableModel(v3, v1));
             
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
         }
           
    
    
    
}
    
    public static void main(String[] args) {
        clients_caps obj=new clients_caps();
        obj.setName("Eslam");
        obj.setAddress("Egypt");
        obj.setCode("55555");
        obj.setPhone("010");
        obj.setPhone2("011");
        obj.setNotes("Enjoy");
       // obj.setStart_date("10-12-1995");
        clients_cont ob=new clients_cont();
        ob.insert(obj);
        
    }
    
    
}
