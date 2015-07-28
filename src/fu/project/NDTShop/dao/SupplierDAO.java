/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.dao;

import fu.project.NDTShop.model.Supplier;
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
public class SupplierDAO {
    private Connection conn = null;
     public void open(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn = DriverManager.getConnection("jdbc:sqlserver://Lucci-PC:1433;databaseName=NDT_Shop", "sa", "1234567");
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void addSupplier(Supplier s) {
		open();
		String sql = "insert into Supplier value(?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, s.getSupplierid());
			ps.setString(2, s.getSuppliername());
                        ps.setString(3, s.getSuppliertel());
			ps.setString(4, s.getSupplieremail());
			ps.setString(5, s.getSupplieraddress());
                        ps.setString(6, s.getSuppliercity());
			ps.setString(7, s.getSuppliercountry());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
            }
	}
        
        public List<Supplier> getList() {
		open();
		String sql = "select * from Supplier";
		List<Supplier> list = new ArrayList<Supplier>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                                Supplier supplier = new Supplier();
                                supplier.setSupplierid(rs.getString("SupplierID"));
				supplier.setSuppliername(rs.getString("SupplierName"));
                                supplier.setSuppliertel(rs.getString("SupplierTel"));
				supplier.setSupplieremail(rs.getString("SupplierEmail"));
                                supplier.setSupplieraddress(rs.getString("SupplierAddress"));
                                supplier.setSuppliercity(rs.getString("SupplierCity"));
				supplier.setSuppliercountry(rs.getString("SupplierCountry"));
				list.add(supplier);
			}
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return list;
	}
        
        public void delSupplier(String supplierId) {
                open();
		try {
                    PreparedStatement pstmt = conn.prepareStatement(""+ "DELETE FROM SupplierWHERE SupplierID =?");
                        pstmt.setString(1, supplierId);
                        pstmt.executeUpdate();
                } catch (SQLException ex) {
                        Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    close();
                }

	}
        
        public Supplier getSupplier(String suppId) {
                open();
		String sql = "select * from Supplier where SupplierID=?";
		Supplier s = new Supplier();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                        ps.setString(1, suppId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String supplierId = rs.getString("SupplierID");
				String supplierName = rs.getString("SupplierName");
                                String supplierTel = rs.getString("SupplierTel");
				String supplierEmail = rs.getString("SupplierEmail");
				String SupplierAdd = rs.getString("SupplierAddress");
                                String supplierCity = rs.getString("SupplierCity");
				String supplierCountry = rs.getString("SupplierCountry");
				s = new Supplier(supplierId, supplierName, supplierTel, supplierEmail, SupplierAdd, supplierCity, supplierCountry);
			}
			
		} catch (SQLException ex) {
                        Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return s;
	}
  
        public void updateSupplier(Supplier s) {
		open();
		String sql = "update Supplierset SupplierName=?, SupplierTel=?, SupplierEmail=?,SupplierAddress=?, SupplierCity=?,SupplierCountry=? where SupplierID=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, s.getSuppliername());
			ps.setString(3, s.getSuppliertel());
                        ps.setString(4, s.getSupplieremail());
			ps.setString(5, s.getSupplieraddress());
			ps.setString(6, s.getSuppliercity());
                        ps.setString(7, s.getSuppliercountry());
			ps.executeUpdate();
		} catch (SQLException ex) {
                        Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
	}
     
     public void close(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
