/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
        
        
public class ConnectSQL {
    
    public static List<Shoes> getShoesData(){
        List<Shoes> shoesList = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoemanagement", "root", "");
            
            
            String sql = "select * from shoes";
            stat = conn.createStatement();
            
            ResultSet resultSet = stat.executeQuery(sql);
            
            while(resultSet.next()){
                Shoes std = new Shoes(resultSet.getInt("shoesid"),
                                      resultSet.getInt("quantity"),
                                      resultSet.getString("brand"),
                                      resultSet.getString("nameofshoes"),
                                      resultSet.getDouble("size"),
                                      resultSet.getDouble("price"),
                                      resultSet.getDouble("total"));
                shoesList.add(std);
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
        
        return shoesList;    
    }
    
    public static void addShoesData(Shoes std) {
        Connection conn = null;
        PreparedStatement stat = null;
        
        try {
            //connect to db
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoemanagement", "root", "");
            
            //query to input information to db management
            String sql = "insert into shoes(shoesid, brand, nameofshoes, size, quantity, price, total) values(?, ?, ?, ?, ?, ?, ?)";
            stat = conn.prepareCall(sql);
            
            //value
            stat.setInt(1, std.getShoesid());
            stat.setString(2, std.getBrand());
            stat.setString(3, std.getNameofshoes());
            stat.setDouble(4, std.getSize());
            stat.setInt(5, std.getQuantity());
            stat.setDouble(6, std.getPrice());
            stat.setDouble(7, std.getTotal());
            
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
    
//    public static void updateShoesData(Shoes std) {
//        Connection conn = null;
//        PreparedStatement stat = null;
//        
//        try {
//            //connect to db
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoemanagement", "root", "");
//            
//            //query to input information to db management
//            String sql = "update shoes set brand=?, nameofshoes=?, size=?, quantity=?, price=?, total=? where nameofshoes = ?";
//            stat = conn.prepareCall(sql);
//            
//            //value
//            
//            stat.setString(1, std.getBrand());
//            stat.setString(2, std.getNameofshoes());
//            stat.setDouble(3, std.getSize());
//            stat.setInt(4, std.getQuantity());
//            stat.setDouble(5, std.getPrice());
//            stat.setDouble(6, std.getTotal());
//            
//            stat.execute();
//            }
//        catch (SQLException ex) {
//            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if(stat != null){
//                try {
//                    stat.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//    }
    
    public static void deleteShoes(int shoesid) {
        Connection conn = null;
        PreparedStatement stat = null;
        try {
            //connect to db
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoemanagement", "root", "");
            //query to input information to db management
            String sql = "delete from shoes where shoesid = ?";
            stat = conn.prepareCall(sql);
            
            stat.setInt(1, shoesid);
            
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
    
    public static List<Shoes> searchByName(String nameofshoes) {
        List<Shoes> shoesList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stat = null;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoemanagement", "root", "");
            
            String sql = "select * from shoes where nameofshoes like ?";
            stat = conn.prepareCall(sql);
            stat.setString(1, "%"+nameofshoes+"%");
            
            ResultSet resultSet = stat.executeQuery();
            
            while(resultSet.next()){
                Shoes std = new Shoes(resultSet.getInt("shoesid"),
                                      resultSet.getInt("quantity"),
                                      resultSet.getString("brand"),
                                      resultSet.getString("nameofshoes"),
                                      resultSet.getDouble("size"),
                                      resultSet.getDouble("price"),
                                      resultSet.getDouble("total"));
                shoesList.add(std);
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
        
        return shoesList;    
    }
}
