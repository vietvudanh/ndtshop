/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.dao;

import fu.project.NDTShop.model.News;
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
public class NewsDAO {
    private Connection conn = null;
    public void open(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn = DriverManager.getConnection("jdbc:sqlserver://Lucci-PC:1433;databaseName=NDT_Shop", "sa", "1234567");
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addNews(News n) {
		open();
		String sql = "insert into News value(?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, n.getNewsid());
			ps.setString(2, n.getNewstitle());
			ps.setString(3, n.getNewdescription());
                        ps.setString(4, n.getStaffid());
			ps.setDate(5, n.getNewsposteddate());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
            }
	}
        
        public List<News> getList() {
		open();
		String sql = "select * from News";
		List<News> list = new ArrayList<News>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                                News news = new News();
                                news.setNewsid(rs.getString("NewsID"));
				news.setNewstitle(rs.getString("NewsTitle"));
                                news.setNewdescription(rs.getString("NewsDescription"));
                                news.setStaffid(rs.getString("StaffID"));
                                news.setNewsposteddate(rs.getDate("NewPostedDate"));
				list.add(news);
			}
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return list;
	}
        
        public void delNews(String newsid) {
                open();
		try {
                    PreparedStatement pstmt = conn.prepareStatement(""+ "DELETE FROM News WHERE NewsID =?");
                        pstmt.setString(1, newsid);
                        pstmt.executeUpdate();
                } catch (SQLException ex) {
                        Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    close();
                }

	}
        
        public News getNews(String newId) {
                open();
		String sql = "select * from News where NewsID=?";
		News n = new News();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                        ps.setString(1, newId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String newsid = rs.getString("NewsID");
				String newTitle = rs.getString("NewsTitle");
				String newsDescription = rs.getString("NewsDescription");
                                String staffId = rs.getString("StaffId");
				Date newPostedDate = rs.getDate("NewsPostedDate");
				n = new News(newsid, newTitle, newsDescription, staffId, newPostedDate);
			}
			
		} catch (SQLException ex) {
                        Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return n;
	}
  
        public void updateNews(News n) {
		open();
		String sql = "update News set NewsName=?, NewsTitle=?, NewsDescription=?,StaffId=?, NewsPostedDate=? where NewsID=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, n.getNewstitle());
			ps.setString(2, n.getNewdescription());
			ps.setString(3, n.getStaffid());
                        ps.setDate(4, n.getNewsposteddate());
                        ps.setString(5, n.getNewsid());
			ps.executeUpdate();
		} catch (SQLException ex) {
                        Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
	}
    
    public void close(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
