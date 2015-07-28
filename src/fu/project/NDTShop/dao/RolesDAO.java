/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.dao;

import fu.project.NDTShop.model.Roles;
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
public class RolesDAO {
    private Connection conn = null;
     public void open(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn = DriverManager.getConnection("jdbc:sqlserver://Lucci-PC:1433;databaseName=NDT_Shop", "sa", "1234567");
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void addRole(Roles r) {
		open();
		String sql = "insert into Roles value(?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, r.getRoleid());
			ps.setString(2, r.getRolename());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
            }
	}
        
        public List<Roles> getList() {
		open();
		String sql = "select * from Roles";
		List<Roles> list = new ArrayList<Roles>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                                Roles role = new Roles();
                                role.setRoleid(rs.getString("RoleID"));
				role.setRolename(rs.getString("RoleName"));
				list.add(role);
			}
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return list;
	}
        
        public void delRole(String roleid) {
                open();
		try {
                    PreparedStatement pstmt = conn.prepareStatement(""+ "DELETE FROM Roles WHERE RoleID =?");
                        pstmt.setString(1, roleid);
                        pstmt.executeUpdate();
                } catch (SQLException ex) {
                        Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    close();
                }

	}
        
        public Roles getRole(String cateid) {
                open();
		String sql = "select * from Roles where RoleID=?";
		Roles c = new Roles();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                        ps.setString(1, cateid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String roleid = rs.getString("RoleID");
				String rolename = rs.getString("RoleName");
				c = new Roles(roleid, rolename);
			}
			
		} catch (SQLException ex) {
                        Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return c;
	}
  
        public void updateRole(Roles r) {
		open();
		String sql = "update Roles set RoleName=?where RoleID=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, r.getRolename());
			ps.setString(2, r.getRoleid());
			ps.executeUpdate();
		} catch (SQLException ex) {
                        Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
	}
     
     public void close(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
