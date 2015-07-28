/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.dao;

import fu.project.NDTShop.model.Product;
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
public class ProductDAO {
    private Connection conn = null;
     public void open(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn = DriverManager.getConnection("jdbc:sqlserver://Lucci-PC:1433;databaseName=NDT_Shop", "sa", "1234567");
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void addProduct(Product p) {
		open();
		String sql = "insert into Product value(?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getProductid());
			ps.setString(2, p.getProductname());
			ps.setString(3, p.getProductdescription());
                      //  ps.setString(4, p.getProductimage());
			ps.setFloat(5, p.getProductsaleprice());
			ps.setString(6, p.getOrderdetailid());
                        ps.setString(7, p.getStaffid());
                        ps.setString(8, p.getSubcategoryid());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
            }
	}
        
        public List<Product> getList() {
		open();
		String sql = "select * from Product";
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                                Product product= new Product();
                                product.setProductid(rs.getString("ProductID"));
				product.setProductname(rs.getString("ProductName"));
                                product.setProductdescription(rs.getString("ProductDescription"));
                               // product.setProductimage(rs.getString("ProductImage"));
				product.setProductsaleprice(rs.getFloat("ProductName"));
                                product.setOrderdetailid(rs.getString("OrderDetailID"));
                                product.setStaffid(rs.getString("StaffID"));
				product.setSubcategoryid(rs.getString("SubCategoryID"));
				list.add(product);
			}
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return list;
	}
        
        public void delProduct(String productid) {
                open();
		try {
                    PreparedStatement pstmt = conn.prepareStatement(""+ "DELETE FROM Product WHERE ProductID =?");
                        pstmt.setString(1, productid);
                        pstmt.executeUpdate();
                } catch (SQLException ex) {
                        Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    close();
                }

	}
        
        public Product getProduct(String proId) {
                open();
		String sql = "select * from Product where ProductID=?";
		Product p = new Product();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                        ps.setString(1, proId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String productId = rs.getString("ProductID");
				String productName = rs.getString("ProductName");
				String productDescription = rs.getString("ProductDescription");
                                String productImage = rs.getString("ProductImage");
				Float productSale = rs.getFloat("ProductSalePrice");
				String orderDetail = rs.getString("OrderDetailID");
                                String staffId = rs.getString("StaffID");
				String subCategoryId = rs.getString("SubcategoryID");
			//	p = new Product(productId, productName, productDescription, productImage, productSale, orderDetail, staffId, subCategoryId);
			}
			
		} catch (SQLException ex) {
                        Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return p;
	}
  
        public void updateProduct(Product p) {
		open();
		String sql = "update Product set ProductName=?, ProductDescription=?, ProductImage=?, ProductSalePrice=?, OrderDetailID=?, StaffID=?, SubCategoryID=? where ProductID=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getProductname());
			ps.setString(2, p.getProductdescription());
                      //  ps.setString(3, p.getProductimage());
			ps.setFloat(4, p.getProductsaleprice());
                        ps.setString(5, p.getOrderdetailid());
			ps.setString(6, p.getStaffid());
                        ps.setString(7, p.getSubcategoryid());
			ps.setString(8, p.getProductid());
			ps.executeUpdate();
		} catch (SQLException ex) {
                        Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
	}
     
     public void close(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
