/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.dao;

import fu.project.NDTShop.config.DB;
import fu.project.NDTShop.model.Customer;
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
public class CustomerDAO {
    private Connection conn = null;
    public void open(){
        try {
            Class.forName(DB.DRIVER);

            conn = DriverManager.getConnection("jdbc:sqlserver://Lucci-PC:1433;databaseName=NDT_Shop", "sa", "1234567");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addCustomer(Customer c) {
		open();
		String sql = "insert into Customer value(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, c.getCustomerid());
			ps.setString(2, c.getCustomername());
			ps.setDate(3, c.getCustomerdob());
                        ps.setString(4, c.getCustomertel());
			ps.setString(5, c.getCustomeremail());
			ps.setString(6, c.getCustomeraddress());
                        ps.setString(7, c.getCustomercity());
			ps.setString(8, c.getCustomercountry());
			ps.setDate(9, c.getCustomerlastestlogin());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
            }
	}
        
        public List<Customer> getList() {
		open();
		String sql = "select * from Customer";
		List<Customer> list = new ArrayList<Customer>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                                Customer customer = new Customer();
                                customer.setCustomerid(rs.getString("CustomerID"));
				customer.setCustomername(rs.getString("CustomerName"));
                                customer.setCustomerdob(rs.getDate("CustomerDOB"));
                                customer.setCustomertel(rs.getString("CustomerTel"));
				customer.setCustomeremail(rs.getString("CustomerEmail"));
                                customer.setCustomeraddress(rs.getString("CustomerAddress"));
                                customer.setCustomercity(rs.getString("CustomerCity"));
				customer.setCustomercountry(rs.getString("CustomerCountry"));
                                customer.setCustomerlastestlogin(rs.getDate("CustomerLastestLogin"));
				list.add(customer);
			}
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return list;
	}
        
        public void delCustomer(String customerId) {
                open();
		try {
                    PreparedStatement pstmt = conn.prepareStatement(""+ "DELETE FROM Customer WHERE CustomerID =?");
                        pstmt.setString(1, customerId);
                        pstmt.executeUpdate();
                } catch (SQLException ex) {
                        Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    close();
                }

	}
        
        public Customer getCustomer(String custId) {
                open();
		String sql = "select * from Customer where CustomerID=?";
		Customer c = new Customer();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                        ps.setString(1, custId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String customerId = rs.getString("CustomerID");
				String customerName = rs.getString("CustomerName");
				Date customerDOB = rs.getDate("CustomerDOB");
                                String customerTel = rs.getString("CustomerTel");
				String customerEmail = rs.getString("CustomerEmail");
				String CustomerAdd = rs.getString("CustomerAddress");
                                String customerCity = rs.getString("CustomerCity");
				String customerCountry = rs.getString("CustomerCountry");
				Date CustomerLastestLogin = rs.getDate("CustomerLastestLogin");
				c = new Customer(customerId, customerName, customerDOB, customerTel, customerEmail, CustomerAdd, customerCity, customerCountry, CustomerLastestLogin);
			}
			
		} catch (SQLException ex) {
                        Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return c;
	}
  
        public void updateCustomer(Customer c) {
		open();
		String sql = "update Customer set CustomerName=?, CustomerDOB=?,CustomerTel=?, CustomerEmail=?,CustomerAddress=?, CustomerCity=?,CustomerCountry=?,CustomerLastestLogin where CustomerID=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, c.getCustomername());
			ps.setDate(2, c.getCustomerdob());
			ps.setString(3, c.getCustomertel());
                        ps.setString(4, c.getCustomeremail());
			ps.setString(5, c.getCustomeraddress());
			ps.setString(6, c.getCustomercity());
                        ps.setString(7, c.getCustomercountry());
			ps.setDate(8, c.getCustomerlastestlogin());
			ps.executeUpdate();
		} catch (SQLException ex) {
                        Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
	}
    
    public void close(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
