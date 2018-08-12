/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.Db_Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static view.panal.items.txt_name;

public class items_model {

    public static Connection con;
    public static PreparedStatement pre;
    public static ResultSet res;

    public void insert(String name, String code, int amount, double sell_price, double buy_price, int limit, String date) {
        try {
            con = new Db_Connection().getconnction();
            //id, name, code, amount, sell_price, buy_price, vender_id, limit, limit_statue, date, num_tape, department_id
            pre = con.prepareStatement("insert into project.items (name,code,amount,sell_price,buy_price,limits,dates) values (?,?,?,?,?,?,?);");
            pre.setString(1, name);
            pre.setString(2, code);
            pre.setInt(3, amount);
            pre.setDouble(4, sell_price);
            pre.setDouble(5, buy_price);
            pre.setInt(6, limit);
            pre.setString(7, date);
            JOptionPane.showMessageDialog(null, "تم الاضافة ");
            pre.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void delete() {
        con = new Db_Connection().getconnction();
        try {
            pre = con.prepareStatement("delete from items where code=?");
            pre.setString(1, view.panal.items.txt_code.getText());
            pre.execute();
            JOptionPane.showMessageDialog(null, "deleted ");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void show_data() {
        con = new Db_Connection().getconnction();
        //String arr[][] = null;
        String name, code, date;
        int amount, limits;
        double sell_price, buy_price;
        boolean limit_statue;
        try {
            Vector v1 = new Vector();
            v1.addElement("الاسم");
            v1.addElement("الكود");
            v1.addElement("الكمية");
            v1.addElement("سعر البيع");
            v1.addElement("سعر الشراء");
            v1.addElement("الكمية");
            v1.addElement("الجالة");
            v1.addElement("التاريخ");
            pre = con.prepareStatement("select name,code,amount,sell_price,buy_price,limits,limit_statue,dates from items ;");
            res = pre.executeQuery();
            Vector v3 = new Vector();
            while (res.next()) {
                Vector v2 = new Vector();
                name = res.getString(1);
                code = res.getString(2);
                amount = res.getInt(3);
                sell_price = res.getDouble(4);
                buy_price = res.getDouble(5);
                limits = res.getInt(6);
                limit_statue = res.getBoolean(7);
                date = res.getString(8);
                v2.addElement(name);
                v2.addElement(code);
                v2.addElement(amount);
                v2.addElement(sell_price);
                v2.addElement(buy_price);
                v2.addElement(limits);
                v2.addElement(limit_statue);
                v2.addElement(date);
                v3.addElement(v2);
            }
            view.panal.items.table.setModel(new DefaultTableModel(v3, v1));
            //System.out.println(v3);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void update() {

        con = new Db_Connection().getconnction();
        String name =txt_name.getText();
        String code = view.panal.items.txt_code.getText();
//int depar=Integer.parseInt()
        String date = "fsfds";
        int amount = Integer.parseInt(view.panal.items.txt_amount.getText());
        double sell_price = Double.parseDouble(view.panal.items.txt_sellprice.getText());
        double buy_price = Double.parseDouble(view.panal.items.txt_buyprice.getText());
        int limit = Integer.parseInt(view.panal.items.txt_limit.getText());

        try {
            pre = con.prepareStatement("update items set name=?,code=?,dates=?,amount=?,sell_price=?,buy_price=?,limits=?");
            pre.setString(1, name);
            pre.setString(2, code);
            pre.setString(3, date);
            pre.setInt(4, amount);
            pre.setDouble(5, sell_price);
            pre.setDouble(6, buy_price);
            pre.setInt(7, limit);
            JOptionPane.showMessageDialog(null, "تم التعديل ");
            pre.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    public static Vector combo_vendor(){
        Vector v = new Vector();
        try {
            pre=con.prepareStatement("select distinct name from items");
            res=pre.executeQuery();
            while (res.next()) {
                
                v.addElement(res.getString(1));
            }
            
            return v;
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
       
    }

}
   