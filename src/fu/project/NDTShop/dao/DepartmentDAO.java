/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.dao;

import fu.project.NDTShop.model.Department;
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
public class DepartmentDAO {
    private Connection conn = null;
    public void open(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn = DriverManager.getConnection("jdbc:sqlserver://Lucci-PC:1433;databaseName=NDT_Shop", "sa", "1234567");
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void addDepartment(Department d) {
		open();
		String sql = "insert into Department value(?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, d.getDepartmentid());
			ps.setString(2, d.getDepartmentname());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
            }
	}
        
        public List<Department> getList() {
		open();
		String sql = "select * from Department";
		List<Department> list = new ArrayList<Department>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                                Department department = new Department();
                                department.setDepartmentid(rs.getString("DepartmentID"));
				department.setDepartmentname(rs.getString("DepartmentName"));
				list.add(department);
			}
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return list;
	}
        
        public void delDepartment(String departmentid) {
                open();
		try {
                    PreparedStatement pstmt = conn.prepareStatement(""+ "DELETE FROM Department WHERE DepartmentID =?");
                        pstmt.setString(1, departmentid);
                        pstmt.executeUpdate();
                } catch (SQLException ex) {
                        Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    close();
                }

	}
        
        public Department getDepartment(String departmentId) {
                open();
		String sql = "select * from Department where DepartmentID=?";
		Department d = new Department();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                        ps.setString(1, departmentId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String departmentid = rs.getString("DepartmentID");
				String departmentname = rs.getString("DepartmentName");
				d = new Department(departmentid, departmentname);
			}
			
		} catch (SQLException ex) {
                        Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return d;
	}
  
        public void updateDepartment(Department d) {
		open();
		String sql = "update Department set DepartmentName=? where DepartmentID=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, d.getDepartmentname());
			ps.setString(2, d.getDepartmentid());
			ps.executeUpdate();
		} catch (SQLException ex) {
                        Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
	}
     
    public void close(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
