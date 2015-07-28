/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.dao;

import fu.project.NDTShop.model.ProductSupplier;
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
public class ProductSupplierDAO {
    private Connection conn = null;
     public void open(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn = DriverManager.getConnection("jdbc:sqlserver://Lucci-PC:1433;databaseName=NDT_Shop", "sa", "1234567");
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void addProductSupplier(ProductSupplier p) {
		open();
		String sql = "insert into ProductSupplier value(?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getSupplierid());
			ps.setString(2, p.getProductid());
			ps.setFloat(3, p.getProductimportprice());
                        ps.setDate(4, p.getProductimportdate());
                        ps.setInt(5, p.getProductimportquantity());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(ProductSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
            }
	}
        
        public List<ProductSupplier> getList() {
		open();
		String sql = "select * from ProductSupplier";
		List<ProductSupplier> list = new ArrayList<ProductSupplier>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                                ProductSupplier pSupplier = new ProductSupplier();
                                pSupplier.setSupplierid(rs.getString("ProductSupplierID"));
				pSupplier.setProductid(rs.getString("ProductID"));
                                pSupplier.setProductimportprice(rs.getFloat("ProductImportPrice"));
                                pSupplier.setProductimportdate(rs.getDate("ProductImportDate"));
                                pSupplier.setProductimportprice(rs.getInt("ProductImportQuantity"));
				list.add(pSupplier);
			}
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(ProductSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return list;
	}
        
        public void delProductSupplier(String pSupplierid) {
                open();
		try {
                    PreparedStatement pstmt = conn.prepareStatement(""+ "DELETE FROM ProductSupplier WHERE ProductSupplierID =?");
                        pstmt.setString(1, pSupplierid);
                        pstmt.executeUpdate();
                } catch (SQLException ex) {
                        Logger.getLogger(ProductSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    close();
                }

	}
        
        public ProductSupplier getProductSupplier(String supId) {
                open();
		String sql = "select * from ProductSupplier where ProductSupplierID=?";
		ProductSupplier p = new ProductSupplier();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                        ps.setString(1, supId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String pSupplierid = rs.getString("ProductSupplierID");
				String pProductId = rs.getString("ProductID");
				Float pProductImPrice = rs.getFloat("ProductImportPrice");
                                Date pProductImDate = rs.getDate("ProductImportDate");
                                int pProductImQuantity = rs.getInt("ProductImportQuantity");
				p = new ProductSupplier(pSupplierid, pProductId, pProductImPrice, pProductImDate, pProductImQuantity);
			}
			
		} catch (SQLException ex) {
                        Logger.getLogger(ProductSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return p;
	}
  
        public void updateProductSupplier(ProductSupplier p) {
		open();
		String sql = "update ProductSupplier set ProductID=?, ProductImportPrice=?,ProductImportDate=?,ProductImportQuantity where SupplierID=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getProductid());
			ps.setFloat(2, p.getProductimportprice());
                        ps.setDate(3, p.getProductimportdate());
                        ps.setInt(4, p.getProductimportquantity());
			ps.setString(3, p.getSupplierid());
			ps.executeUpdate();
		} catch (SQLException ex) {
                        Logger.getLogger(ProductSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
	}
     
     public void close(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
