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

	public void open() {
		try {
			Class.forName(DB.DRIVER);

			conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// this function is so wrong... damn it.
	public void addCustomer(Customer c) {
		open();
		String sql = "insert into Customer value(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(c.getCustomerid()) );
			ps.setString(2, c.getCustomerusername());
			ps.setString(3, c.getCustomerpassword());
			ps.setString(4, c.getCustomername());
			ps.setDate(5, c.getCustomerdob());
			ps.setString(6, c.getCustomertel());
			ps.setString(7, c.getCustomeremail());
			ps.setString(8, c.getCustomeraddress());
			ps.setString(9, c.getCustomercity());
			ps.setString(10, c.getCustomercountry());
			ps.setDate(11, c.getCustomerlastestlogin());
			System.out.println(ps.toString());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			close();
		}
	}
	
	// this function is so wrong... damn it.
	public boolean addCustomerRegister(Customer c) {
		open();
		String sql = "insert into Customer(CustomerUsername, CustomerPassword, CustomerName, CustomerEmail) value(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, c.getCustomerusername());
			ps.setString(2, c.getCustomerpassword());
			ps.setString(3, c.getCustomername());
			ps.setString(4, c.getCustomeremail());
			System.out.println(ps.toString());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			close();	
		}
		return true;
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
				customer.setCustomerusername(rs.getString("CustomerUsername"));
				customer.setCustomerpassword(rs.getString("CustomerPassword"));
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
		} finally {
			close();
		}
		return list;
	}

	public void delCustomer(String customerId) {
		open();
		try {
			PreparedStatement pstmt = conn.prepareStatement("" + "DELETE FROM Customer WHERE CustomerID =?");
			pstmt.setString(1, customerId);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			close();
		}

	}

	public Customer getCustomerByUsername(String customerUsername){
		open();
		String sql = "select * from Customer where CustomerUsername=?";
		Customer c = new Customer();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, customerUsername);
			ResultSet rs = ps.executeQuery();
			boolean hasRows = false;
			while (rs.next()) {
				hasRows = true;
				String customerId = rs.getString("CustomerID");
				String username = rs.getString("CustomerUsername");
				String password = rs.getString("CustomerPassword");
				String customerName = rs.getString("CustomerName");
				Date customerDOB = rs.getDate("CustomerDOB");
				String customerTel = rs.getString("CustomerTel");
				String customerEmail = rs.getString("CustomerEmail");
				String CustomerAdd = rs.getString("CustomerAddress");
				String customerCity = rs.getString("CustomerCity");
				String customerCountry = rs.getString("CustomerCountry");
				Date CustomerLastestLogin = rs.getDate("CustomerLastestLogin");
				c = new Customer(customerId, username, password, customerName, customerDOB, customerTel, customerEmail, CustomerAdd,
						customerCity, customerCountry, CustomerLastestLogin);
			}
			
			if(!hasRows){
				return null;
			}

		} catch (SQLException ex) {
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			close();
		}
		return c;
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
				String username = rs.getString("CustomerUsername");
				String password = rs.getString("CustomerPassword");
				String customerName = rs.getString("CustomerName");
				Date customerDOB = rs.getDate("CustomerDOB");
				String customerTel = rs.getString("CustomerTel");
				String customerEmail = rs.getString("CustomerEmail");
				String CustomerAdd = rs.getString("CustomerAddress");
				String customerCity = rs.getString("CustomerCity");
				String customerCountry = rs.getString("CustomerCountry");
				Date CustomerLastestLogin = rs.getDate("CustomerLastestLogin");
				c = new Customer(customerId, username, password, customerName, customerDOB, customerTel, customerEmail, CustomerAdd,
						customerCity, customerCountry, CustomerLastestLogin);
			}

		} catch (SQLException ex) {
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			close();
		}
		return c;
	}

	public void updateCustomer(Customer c) {
		open();
		String sql = "update Customer set CustomerName=?, CustomerUsername=?, CustomerPasswrod=?, CustomerDOB=?,CustomerTel=?, CustomerEmail=?,CustomerAddress=?, CustomerCity=?,CustomerCountry=?,CustomerLastestLogin=? where CustomerID=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, c.getCustomername());
			ps.setString(2, c.getCustomerusername());
			ps.setString(3, c.getCustomerpassword());
			ps.setDate(3, c.getCustomerdob());
			ps.setString(4, c.getCustomertel());
			ps.setString(5, c.getCustomeremail());
			ps.setString(6, c.getCustomeraddress());
			ps.setString(7, c.getCustomercity());
			ps.setString(8, c.getCustomercountry());
			ps.setDate(9, c.getCustomerlastestlogin());
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			close();
		}
	}

	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
