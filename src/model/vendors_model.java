/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.Db_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static model.clients_model.con;
import static model.clients_model.id;
import static model.clients_model.pre;
import static model.clients_model.res;

/**
 *
 * @author Enjoy
 */
public class vendors_model {
    
     vendors_caps obj=new vendors_caps();
       
     public static Connection con;
    
     public static PreparedStatement pre;
    public static ResultSet res;
    
    /*...........................................................*/
    
      public static void insert(vendors_caps obj){
        
         con = new Db_Connection().getconnction();
         
        try {
            pre=con.prepareStatement("insert into venders(name,address,code,start_date,phone,phone_com,notes,name_com,email_com,notes_com) values (?,?,?,?,?,?,?,?,?,?);");
            pre.setString(1, obj.getName());
            pre.setString(2, obj.getAddress());
            pre.setString(3,obj.getCode());
            pre.setString(4,obj.getStart_date_com());
            pre.setString(5,obj.getPhone());
            pre.setString(6,obj.getPhone_com());
            pre.setString(7,obj.getNotes());
            pre.setString(8,obj.getName_com());
            pre.setString(9,obj.getEmail_com());
            pre.setString(10,obj.getNotes_com());
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
          v1.addElement("كود");
          v1.addElement("تاريخ البدء");
           v1.addElement("رقم التليفون");
          v1.addElement("رقم تليفون الشركة ");
             v1.addElement("ملاحظات عن المورد");
        v1.addElement("اسـم الشركة");
                     v1.addElement("ايميل الشركة ");
             v1.addElement("ملاحظات عن الشركة");
         
         try {
  pre = con.prepareStatement("select name,address,code,start_date,phone,phone_com,notes,name_com,email_com,notes_com from venders ;");
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
                 v2.addElement(res.getString(8));
                 v2.addElement(res.getString(9));
                 v2.addElement(res.getString(10));
                 v3.addElement(v2);
             }
             
   view.panal.vendors.table.setModel(new DefaultTableModel(v3, v1));
             
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
         }
    }
    
     public static void delete(vendors_caps obj){
        
          con = new Db_Connection().getconnction();
         
        try {
            pre = con.prepareStatement("delete from venders where code=?");
            pre.setString(1,obj.getCode());
            pre.execute();
            JOptionPane.showMessageDialog(null, "deleted ");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
     public static int id(vendors_caps obj){
        
         con = new Db_Connection().getconnction();
     
         try {
             pre=con.prepareStatement("select id from venders where code=?");
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
     
      public static void update(vendors_caps obj){

    int a=id(obj);
     con = new Db_Connection().getconnction();

        try {

           pre = con.prepareStatement("update venders set name=?,address=?,code=?,start_date=?,phone=?,phone_com=?,notes=?,name_com=?,email_com=?,notes_com=? where id=? ");
            pre.setString(1, obj.getName());
            pre.setString(2, obj.getAddress());
            pre.setString(3,obj.getCode());
            pre.setString(4,obj.getStart_date_com());
            pre.setString(5,obj.getPhone());
            pre.setString(6,obj.getPhone_com());
            pre.setString(7,obj.getNotes());
            pre.setString(8,obj.getName_com());
            pre.setString(9,obj.getEmail_com());
            pre.setString(10,obj.getNotes_com()); 
           pre.setInt(11,a);
       
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
             pre = con.prepareStatement("select  name,phone,code from venders ");
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
     
   public static void search(vendors_caps obj){
         con = new Db_Connection().getconnction();
         Vector v1= new Vector();
          Vector v3= new Vector();               
         v1.addElement("الاسـم");
          v1.addElement("العنوان");
          v1.addElement("كود");
          v1.addElement("تاريخ البدء");
           v1.addElement("رقم التليفون");
          v1.addElement("رقم تليفون الشركة ");
             v1.addElement("ملاحظات عن المورد");
        v1.addElement("اسـم الشركة");
                     v1.addElement("ايميل الشركة ");
             v1.addElement("ملاحظات عن الشركة");
         
         try {
  pre = con.prepareStatement("select name,address,code,start_date,phone,phone_com,notes,name_com,email_com,notes_com from venders where name like '"+obj.getSearch()+"%'");
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
                 v2.addElement(res.getString(8));
                 v2.addElement(res.getString(9));
                 v2.addElement(res.getString(10));
                 v3.addElement(v2);
             }
             
   view.panal.vendors.table.setModel(new DefaultTableModel(v3, v1));
             
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
         }
    }  
   
   public static void search_code(vendors_caps obj){
         con = new Db_Connection().getconnction();
         Vector v1= new Vector();
          Vector v3= new Vector();               
        v1.addElement("الاسـم");
          v1.addElement("العنوان");
          v1.addElement("كود");
          v1.addElement("تاريخ البدء");
           v1.addElement("رقم التليفون");
          v1.addElement("رقم تليفون الشركة ");
             v1.addElement("ملاحظات عن المورد");
        v1.addElement("اسـم الشركة");
                     v1.addElement("ايميل الشركة ");
             v1.addElement("ملاحظات عن الشركة");
         
         try {
  pre = con.prepareStatement("select name,address,code,start_date,phone,phone_com,notes,name_com,email_com,notes_com from venders where code like '"+obj.getSearch()+"%'");
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
                 v2.addElement(res.getString(8));
                 v2.addElement(res.getString(9));
                 v2.addElement(res.getString(10));
                 v3.addElement(v2);
             }
             
   view.panal.vendors.table.setModel(new DefaultTableModel(v3, v1));
             
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
         }
    }  
   
     
}
