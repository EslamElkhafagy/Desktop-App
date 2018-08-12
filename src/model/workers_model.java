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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static model.items_model.con;
import static model.items_model.pre;
import static model.items_model.res;
import static view.panal.items.txt_name;


public class workers_model {
     workers_caps obj=new workers_caps();
     
    public static Connection con;
    
     public static PreparedStatement pre;
    public static ResultSet res;
    //**********************************************************************************//
//    con = new Db_Connection().getconnction();
  // String name=obj.getName();
   
   
   //String name,String phone,String start_date,String address,double salary,String time,String code,String notes,String image 
    public static void insert( workers_caps obj ){
          con = new Db_Connection().getconnction();
        try {
 pre=con.prepareStatement("insert into project.workers (name,phone,start_date,address,salary,time,code,notes) values (?,?,?,?,?,?,?,?);");
 pre.setString(1, obj.getName());
 pre.setString(2, obj.getPhone());
 pre.setString(3, obj.getStart_date());
 pre.setString(4,obj.getAddress());
 pre.setDouble(5, obj.getSalary());
 pre.setString(6,obj.getTime());
 pre.setString(7,obj.getCode());
 pre.setString(8,obj.getNote());
 //pre.setString(9,obj.getImage());
 
  JOptionPane.showMessageDialog(null, "تم الاضافة ");
            pre.executeUpdate();
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public static void delete(workers_caps obj){
        
         con = new Db_Connection().getconnction();
         
        try {
            pre = con.prepareStatement("delete from workers where code=?");
            pre.setString(1,obj.getCode());
            pre.execute();
            JOptionPane.showMessageDialog(null, "deleted ");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }
    
    public static void show_data(){
         con = new Db_Connection().getconnction();
         Vector v1= new Vector();
          Vector v3= new Vector();
               
              
               
         v1.addElement("الاسـم");
          v1.addElement("رقم التليفون");
           v1.addElement("المرتب");
         v1.addElement("وقت العمل");
         v1.addElement("تاريخ البدء");
         v1.addElement("العنوان");
         v1.addElement("كود");
         v1.addElement("ملاحظات");
         
        
         try {
  pre = con.prepareStatement("select name,phone,address,salary,time,start_date,code,notes from workers ;");
   res = pre.executeQuery();
   
             while (res.next()) {
                Vector v2= new Vector();
                 
                 v2.addElement(res.getString(1));
                 v2.addElement(res.getString(2));
                 v2.addElement(res.getDouble(4));
                 v2.addElement(res.getString(5));
                 v2.addElement(res.getString(6));
                 v2.addElement(res.getString(3));
                 v2.addElement(res.getString(7));
                 v2.addElement(res.getString(8));
                 v3.addElement(v2);
             }
             
   view.panal.workers.table.setModel(new DefaultTableModel(v3, v1));
             
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
         }
           
         
         
    }

public static void update(workers_caps obj){
    
//    String s=id(obj);
//    System.out.println("s =   "+s);
    int a=id(obj);
//    System.out.println("a =   "+a);
     con = new Db_Connection().getconnction();

        try {

           pre = con.prepareStatement("update workers set name=?,phone=?,salary=?,time=?,start_date=?,address=?,code=?,notes=? where id=? ");
           pre.setString(1,obj.getName());
           pre.setString(2, obj.getPhone());
           pre.setDouble(3,obj.getSalary());
           pre.setString(4,obj.getTime());
           pre.setString(5,obj.getStart_date());
           pre.setString(6,obj.getAddress());
           pre.setString(7, obj.getCode());
           pre.setString(8,obj.getNote());
           pre.setInt(9,a);
       
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
             pre = con.prepareStatement("select  name,phone,code from workers ");
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

public static void search(workers_caps obj){
     con = new Db_Connection().getconnction();
    
     Vector v1= new Vector();
          Vector v3= new Vector();
             
         v1.addElement("الاسـم");
          v1.addElement("رقم التليفون");
           v1.addElement("المرتب");
         v1.addElement("وقت العمل");
         v1.addElement("تاريخ البدء");
         v1.addElement("العنوان");
         v1.addElement("كود");
         v1.addElement("ملاحظات");
         
        
         try {
  pre = con.prepareStatement("select  name,phone,address,salary,time,start_date,code,notes from workers where name like '"+obj.getSearch()+"%'");
  // pre.setString(1,obj.getSearch());
   res = pre.executeQuery();
   
             while (res.next()) {
                Vector v2= new Vector();
                 
                 v2.addElement(res.getString(1));
                 v2.addElement(res.getString(2));
                 v2.addElement(res.getDouble(4));
                 v2.addElement(res.getString(5));
                 v2.addElement(res.getString(6));
                 v2.addElement(res.getString(3));
                 v2.addElement(res.getString(7));
                 v2.addElement(res.getString(8));
                 v3.addElement(v2);
             }
             
   view.panal.workers.table.setModel(new DefaultTableModel(v3, v1));
             
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
         }
           
    
    
    
}

public static void search_code(workers_caps obj){
    
     con = new Db_Connection().getconnction();
    
     Vector v1= new Vector();
          Vector v3= new Vector();
             
         v1.addElement("الاسـم");
          v1.addElement("رقم التليفون");
           v1.addElement("المرتب");
         v1.addElement("وقت العمل");
         v1.addElement("تاريخ البدء");
         v1.addElement("العنوان");
         v1.addElement("كود");
         v1.addElement("ملاحظات");
         
        
         try {
  pre = con.prepareStatement("select  name,phone,address,salary,time,start_date,code,notes from workers where code like '"+obj.getSearch()+"%'");
  // pre.setString(1,obj.getSearch());
   res = pre.executeQuery();
   
             while (res.next()) {
                Vector v2= new Vector();
                 
                 v2.addElement(res.getString(1));
                 v2.addElement(res.getString(2));
                 v2.addElement(res.getDouble(4));
                 v2.addElement(res.getString(5));
                 v2.addElement(res.getString(6));
                 v2.addElement(res.getString(3));
                 v2.addElement(res.getString(7));
                 v2.addElement(res.getString(8));
                 v3.addElement(v2);
             }
             
   view.panal.workers.table.setModel(new DefaultTableModel(v3, v1));
             
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
         }
           
    
    
    
    
}


public static int id(workers_caps obj){
    //workers_caps obj
   
     con = new Db_Connection().getconnction();
     
     
         try {
             pre=con.prepareStatement("select id from workers where code=?");
             pre.setString(1,obj.getCode());
             
             res=pre.executeQuery();
             while (res.next()) {                 
                 
                 return res.getInt("id");
             }
             //String s=res.toString();
          //   v.addElement(res);
           //  System.out.println("v    =  "+v);
            // return v;
         } catch (Exception ex) {

         JOptionPane.showMessageDialog(null, ex);
         }
         return 0;
       
    
}
    public static void main(String[] args) {
       
    }
}
