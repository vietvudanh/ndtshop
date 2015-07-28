/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.dao;

import fu.project.NDTShop.model.SubCategory;
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
public class SubCategoryDAO {
    private Connection conn = null;
     public void open(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn = DriverManager.getConnection("jdbc:sqlserver://Lucci-PC:1433;databaseName=NDT_Shop", "sa", "1234567");
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SubCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SubCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void addSubCategory(SubCategory s) {
		open();
		String sql = "insert into SubCategory value(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, s.getSubcategoryid());
			ps.setString(2, s.getSubcategoryname());
			ps.setString(3, s.getSubcategorydescription());
                        ps.setString(4, s.getCategoryid());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(SubCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
            }
	}
        
        public List<SubCategory> getList() {
		open();
		String sql = "select * from SubCategory";
		List<SubCategory> list = new ArrayList<SubCategory>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                                SubCategory subCategory = new SubCategory();
                                subCategory.setSubcategoryid(rs.getString("SubCategoryID"));
				subCategory.setSubcategoryname(rs.getString("SubCategoryName"));
                                subCategory.setSubcategorydescription(rs.getString("SubCategoryDescription"));
				list.add(subCategory);
			}
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(SubCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return list;
	}
        
        public void delSubCategory(String subcategoryid) {
                open();
		try {
                    PreparedStatement pstmt = conn.prepareStatement(""+ "DELETE FROM SubCategory WHERE SubCategoryID =?");
                        pstmt.setString(1, subcategoryid);
                        pstmt.executeUpdate();
                } catch (SQLException ex) {
                        Logger.getLogger(SubCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    close();
                }

	}
        
        public SubCategory getSubCategory(String cateid) {
                open();
		String sql = "select * from SubCategory where SubCategoryID=?";
		SubCategory s = new SubCategory();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                        ps.setString(1, cateid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String subId = rs.getString("SubCategoryID");
				String subName = rs.getString("SubCategoryName");
				String subDescription = rs.getString("SubCategoryDescription");
                                String catId = rs.getString("CategoryID");
				s = new SubCategory(subId, subName, subDescription,catId);
			}
			
		} catch (SQLException ex) {
                        Logger.getLogger(SubCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return s;
	}
  
        public void updateSubCategory(SubCategory s) {
		open();
		String sql = "update SubCategory set SubCategoryName=?, SubCategoryDescription=?,CategoryName=? where CategoryID=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, s.getSubcategoryid());
			ps.setString(2, s.getSubcategorydescription());
			ps.setString(3, s.getCategoryid());
                        ps.setString(4, s.getSubcategoryid());
			ps.executeUpdate();
		} catch (SQLException ex) {
                        Logger.getLogger(SubCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
	}
     
     public void close(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SubCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
