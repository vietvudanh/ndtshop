/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.dao;

import fu.project.NDTShop.model.Orders;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucci
 */
public class OrdersDAO {
    private Connection conn = null;
     public void open(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn = DriverManager.getConnection("jdbc:sqlserver://Lucci-PC:1433;databaseName=NDT_Shop", "sa", "1234567");
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void addOrders(Orders o) {
		open();
		String sql = "insert into Orders value(?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, o.getOrderid());
			ps.setString(2, o.getCustomerid());
			ps.setString(3, o.getStaffid());
                        ps.setDate(4, o.getOrderdate());
			ps.setDate(5, o.getSaledate());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
            }
	}
        
        public List<Orders> getList() {
		open();
		String sql = "select * from Orders";
		List<Orders> list = new ArrayList<Orders>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                                Orders orders = new Orders();
                                orders.setOrderid(rs.getString("OrderID"));
				orders.setCustomerid(rs.getString("CustomerID"));
                                orders.setStaffid(rs.getString("StaffID"));
                                orders.setOrderdate(rs.getDate("OrderDate"));
                                orders.setSaledate(rs.getDate("SaleDate"));
				list.add(orders);
			}
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return list;
	}
        
        public void delOrders(String ordersid) {
                open();
		try {
                    PreparedStatement pstmt = conn.prepareStatement(""+ "DELETE FROM Orders WHERE OrderID =?");
                        pstmt.setString(1, ordersid);
                        pstmt.executeUpdate();
                } catch (SQLException ex) {
                        Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    close();
                }

	}
        
        public Orders getOrders(String custId) {
                open();
		String sql = "select * from Orders where OrderID=?";
		Orders c = new Orders();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                        ps.setString(1, custId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String ordersId = rs.getString("OrderID");
				String cusId = rs.getString("CustomerID");
				String staffId = rs.getString("StaffID");
                                Date order = rs.getDate("OrderDate");
                                Date sale = rs.getDate("SaleDate");
				c = new Orders(ordersId, cusId, staffId, order, sale);
			}
			
		} catch (SQLException ex) {
                        Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return c;
	}
  
        public void updateOrders(Orders o) {
		open();
		String sql = "update Orders set CustomerID=?, StaffID=?,OrderDate=?,SaleDate=? where OrderID=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, o.getCustomerid());
			ps.setString(2, o.getStaffid());
                        ps.setDate(3, o.getOrderdate());
                        ps.setDate(4, o.getSaledate());
			ps.setString(5, o.getOrderid());
			ps.executeUpdate();
		} catch (SQLException ex) {
                        Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
	}
     
     public void close(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
