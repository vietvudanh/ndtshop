/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import fu.project.NDTShop.model.Category;
import fu.project.NDTShop.util.DBUtil;

/**
 *
 * @author Lucci
 */
public class CategoryDAO {
	private Connection conn = null;

	public CategoryDAO(){
		conn = DBUtil.getConnection();
	}

	public void addCategory(Category c) {
		String sql = "insert into Category value(?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, c.getCategoryid());
			ps.setString(2, c.getCategoryname());
			ps.setString(3, c.getCategorydescription());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			close();
		}
	}

	public List<Category> getList() {
		String sql = "select * from Category";
		List<Category> list = new ArrayList<Category>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setCategoryid(rs.getString("CategoryID"));
				category.setCategoryname(rs.getString("CategoryName"));
				category.setCategorydescription(rs.getString("CategoryDescription"));
				list.add(category);
			}
			conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			close();
		}
		return list;
	}

	public void delCategory(String categoryid) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("" + "DELETE FROM Category WHERE CategoryID =?");
			pstmt.setString(1, categoryid);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			close();
		}

	}

	public Category getCategory(String cateid) {
		String sql = "select * from Category where CategoryID=?";
		Category c = new Category();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, cateid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String categoryid = rs.getString("CategoryID");
				String categoryname = rs.getString("CategoryName");
				String categorydescription = rs.getString("CategoryDescription");
				c = new Category(categoryid, categoryname, categorydescription);
			}

		} catch (SQLException ex) {
			Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			close();
		}
		return c;
	}

	public void updateCategory(Category c) {
		String sql = "update Category set CategoryName=?, CategoryDescription=? where CategoryID=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, c.getCategoryname());
			ps.setString(2, c.getCategorydescription());
			ps.setString(3, c.getCategoryid());
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			close();
		}
	}

	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

}
