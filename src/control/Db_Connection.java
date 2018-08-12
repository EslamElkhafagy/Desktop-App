/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Db_Connection {

    static Connection con;
    static PreparedStatement pre;

    public Db_Connection() {

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
//            JOptionPane.showMessageDialog(null, "connection Enstablished");
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
    }

    public static Connection getconnction() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
          //  JOptionPane.showMessageDialog(null, "connection Enstablished");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return con;
    }

//   public void insert(String name,String code,String depar,String date,int amount,float sell_price,float buy_price,int limit){
//       
//       
//       try {
//           pre=con.prepareStatement("insert into items (name,code,amount,sell_price,buy_price,limit,date) values (?,?,?,?,?,?,?)");
//           pre.setString(1,name);
//           pre.setString(2, code);
//           pre.setInt(3, amount);
//           pre.setFloat(4, sell_price);
//           pre.setFloat(5, buy_price);
//           pre.setInt(6, limit);
//           pre.setString(7,date);
//           
//           pre.execute();
//       } catch (SQLException ex) {
//                       JOptionPane.showMessageDialog(null, ex); 
//    }
//   } 
//    
}
