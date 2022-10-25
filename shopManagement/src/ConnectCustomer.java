/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class ConnectCustomer {
    public static List<Customer> getCustomerData(){
        List<Customer> cusList = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoemanagement", "root", "");
            
            
            String sql = "select * from customer";
            stat = conn.createStatement();
            
            ResultSet resultSet = stat.executeQuery(sql);
            
            while(resultSet.next()){
                Customer std = new Customer(resultSet.getInt("id"),
                                        resultSet.getString("name"),
                                        resultSet.getString("address"),
                                        resultSet.getInt("phonenumber"),
                                        resultSet.getInt("shoesid"));
                cusList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cusList;
    }
    
    public static void addCustomer(Customer std) {
        Connection conn = null;
        PreparedStatement stat = null;
        
        try {
            //connect to db
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoemanagement", "root", "");
            
            //query to input information to db management
            String sql = "insert into customer(name, address, phonenumber, shoesid) values(?, ?, ?, ?)";
            stat = conn.prepareCall(sql);
            
            //value
            
            stat.setString(1, std.getName());
            stat.setString(2, std.getAddress());
            stat.setInt(3, std.getPhonenumber());
            stat.setInt(4, std.getShoesid());
            
            stat.execute();
            }
        catch (SQLException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void deleteCustomer(int id) {
        Connection conn = null;
        PreparedStatement stat = null;
        
        try {
            //connect to db
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoemanagement", "root", "");
            
            //query to input information to db management
            String sql = "delete from customer where id = ?";
            stat = conn.prepareCall(sql);
            
            stat.setInt(1, id);
            
            stat.execute();
            }
        catch (SQLException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<Customer> searchByCusName(String name) {
        List<Customer> cusList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stat = null;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoemanagement", "root", "");
            
            String sql = "select * from customer where name like ?";
            stat = conn.prepareCall(sql);
            stat.setString(1, "%"+name+"%");
            
            ResultSet resultSet = stat.executeQuery();
            
            while(resultSet.next()){
                Customer std = new Customer(resultSet.getInt("id"),
                                      resultSet.getString("name"),
                                      resultSet.getString("address"),
                                      resultSet.getInt("phonenumber"),
                                      resultSet.getInt("shoesid"));
                cusList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return cusList;    
    }
}
