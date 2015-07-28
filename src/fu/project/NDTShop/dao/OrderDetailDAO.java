/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.dao;

import fu.project.NDTShop.model.OrderDetail;
import java.sql.Connection;
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
public class OrderDetailDAO {
    private Connection conn = null;
     public void open(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn = DriverManager.getConnection("jdbc:sqlserver://Lucci-PC:1433;databaseName=NDT_Shop", "sa", "1234567");
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void addOrderDetail(OrderDetail o) {
		open();
		String sql = "insert into OrderDetail value(?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, o.getOrderdetailid());
			ps.setFloat(2, o.getProductexportprice());
			ps.setString(3, o.getOrderid());
                        ps.setInt(4, o.getProductsalequantity());
                        ps.setFloat(5, o.getDiscount());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
            }
	}
        
        public List<OrderDetail> getList() {
		open();
		String sql = "select * from OrderDetail";
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                                OrderDetail orderDetail = new OrderDetail();
                                orderDetail.setOrderdetailid(rs.getString("OrderDetailID"));
				orderDetail.setProductexportprice(rs.getFloat("ProductExportPrice"));
                                orderDetail.setOrderid(rs.getString("OrderID"));
                                orderDetail.setProductsalequantity(rs.getInt("ProductSaleQuantity"));
                                orderDetail.setDiscount(rs.getFloat("Discount"));
				list.add(orderDetail);
			}
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return list;
	}
        
        public void delOrderDetail(String orderDetailid) {
                open();
		try {
                    PreparedStatement pstmt = conn.prepareStatement(""+ "DELETE FROM OrderDetail WHERE OrderDetailID =?");
                        pstmt.setString(1, orderDetailid);
                        pstmt.executeUpdate();
                } catch (SQLException ex) {
                        Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    close();
                }

	}
        
        public OrderDetail getOrderDetail(String cateid) {
                open();
		String sql = "select * from OrderDetail where OrderDetailID=?";
		OrderDetail c = new OrderDetail();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                        ps.setString(1, cateid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String orderDetailid = rs.getString("OrderDetailID");
				Float productEx = rs.getFloat("ProductExportPrice");
				String orderId = rs.getString("OrderID");
                                int quantity = rs.getInt("ProductSaleQuantity");
                                Float discount = rs.getFloat("Discount");
				c = new OrderDetail(orderDetailid, productEx, orderId, quantity, discount);
			}
			
		} catch (SQLException ex) {
                        Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return c;
	}
  
        public void updateOrderDetail(OrderDetail o) {
		open();
		String sql = "update OrderDetail set ProductExportPrice=?, OrderID=?,ProductSaleQuantity=?,Discount=? where OrderDetailID=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setFloat(1, o.getProductexportprice());
			ps.setString(2, o.getOrderid());
			ps.setInt(3, o.getProductsalequantity());
                        ps.setFloat(4, o.getDiscount());
                        ps.setString(5, o.getOrderdetailid());
			ps.executeUpdate();
		} catch (SQLException ex) {
                        Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
	}
     
     public void close(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
