/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.dao;

import fu.project.NDTShop.model.Comment;
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
public class CommentDAO {
    private Connection conn = null;
     public void open(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn = DriverManager.getConnection("jdbc:sqlserver://ADMIN;databaseName=NDT_Shop");
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addComment(Comment c) {
		open();
		String sql = "insert into Comment value(?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, c.getCommentid());
			ps.setString(2, c.getCommentcontent());
			ps.setString(3, c.getProductid());
                        ps.setString(4, c.getCustomerid());
                        ps.setDate(5, c.getCommentdate());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
            }
	}
    public List<Comment> getList() {
		open();
		String sql = "select * from Comment";
		List<Comment> list = new ArrayList<Comment>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                                Comment comment = new Comment();
                                comment.setCommentid(rs.getString("CommentID"));
				comment.setCommentcontent(rs.getString("CommentContent"));
                                comment.setProductid(rs.getString("ProductID"));
                                comment.setCustomerid(rs.getString("CustomerID"));
                                comment.setCommentdate(rs.getDate("CommentDate"));
				list.add(comment);
			}
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return list;
	}
        
        public void delComment(String commentID) {
                open();
		try {
                    PreparedStatement pstmt = conn.prepareStatement(""+ "DELETE FROM Comment WHERE CommentID =?");
                        pstmt.setString(1, commentID);
                        pstmt.executeUpdate();
                } catch (SQLException ex) {
                        Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    close();
                }

	}
        
        public Comment getComment(String commentID) {
                open();
		String sql = "select * from Comment where CommentID=?";
		Comment c = new Comment();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                        ps.setString(1, commentID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String commentId = rs.getString("CommentID");
				String commentContent = rs.getString("CommentContent");
                                String productId = rs.getString("ProductID");
                                String customerId = rs.getString("CustomerID");
                                Date commentDate = rs.getDate("CommentDate");
				c = new Comment(commentId, commentContent, productId,customerId,commentDate);
			}
			
		} catch (SQLException ex) {
                        Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return c;
	}   
        
     public void close(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}