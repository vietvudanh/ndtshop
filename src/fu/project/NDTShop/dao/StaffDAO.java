/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.dao;

import fu.project.NDTShop.model.Staff;
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
public class StaffDAO {
    private Connection conn = null;
     public void open(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn = DriverManager.getConnection("jdbc:sqlserver://Lucci-PC:1433;databaseName=NDT_Shop", "sa", "1234567");
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void addStaff(Staff s) {
		open();
		String sql = "insert into Staff value(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, s.getStaffid());
			ps.setString(2, s.getStaffname());			
                        ps.setString(3, s.getStafftel());
                        ps.setDate(4, s.getStaffdob());
			ps.setString(5, s.getStaffemail());
			ps.setString(6, s.getStaffaddress());
                        ps.setString(7, s.getStaffcity());
			ps.setString(8, s.getStaffcountry());
                        ps.setString(9, s.getDepartmentid());
			ps.setString(10, s.getRoleid());
			ps.setDate(9, s.getStafflastestlogin());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
            }
	}
        
        public List<Staff> getList() {
		open();
		String sql = "select * from Staff";
		List<Staff> list = new ArrayList<Staff>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                                Staff staff = new Staff();
                                staff.setStaffid(rs.getString("StaffID"));
				staff.setStaffname(rs.getString("StaffName"));
                                staff.setStafftel(rs.getString("StaffTel"));
                                staff.setStaffdob(rs.getDate("StaffDOB"));
				staff.setStaffemail(rs.getString("StaffEmail"));
                                staff.setStaffaddress(rs.getString("StaffAddress"));
                                staff.setStaffcity(rs.getString("StaffCity"));
				staff.setStaffcountry(rs.getString("StaffCountry"));
                                staff.setDepartmentid(rs.getString("DepartmentID"));
				staff.setRoleid(rs.getString("RoleID"));
                                staff.setStafflastestlogin(rs.getDate("StaffLastestLogin"));
				list.add(staff);
			}
			conn.close();
		} catch (SQLException ex) {
                    Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return list;
	}
        
        public void delStaff(String staffId) {
                open();
		try {
                    PreparedStatement pstmt = conn.prepareStatement(""+ "DELETE FROM Staff WHERE StaffID =?");
                        pstmt.setString(1, staffId);
                        pstmt.executeUpdate();
                } catch (SQLException ex) {
                        Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    close();
                }

	}
        
        public Staff getStaff(String stafId) {
                open();
		String sql = "select * from Staff where StaffID=?";
		Staff s = new Staff();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                        ps.setString(1, stafId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String staffId = rs.getString("StaffID");
				String staffName = rs.getString("StaffName");		
                                String staffTel = rs.getString("StaffTel");
                                Date staffDOB = rs.getDate("StaffDOB");
				String staffEmail = rs.getString("StaffEmail");
				String StaffAdd = rs.getString("StaffAddress");
                                String staffCity = rs.getString("StaffCity");
				String staffCountry = rs.getString("StaffCountry");
                                String dep = rs.getString("DepartmentID");
				String role = rs.getString("RoleID");
				Date StaffLastestLogin = rs.getDate("StaffLastestLogin");
				s = new Staff(staffId, staffName, staffTel, staffDOB, staffEmail, StaffAdd, staffCity, staffCountry, dep, role, StaffLastestLogin);
			}
			
		} catch (SQLException ex) {
                        Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
		return s;
	}
  
        public void updateStaff(Staff s) {
		open();
		String sql = "update Staff set StaffName=?,StaffTel=?, StaffDOB=?, StaffEmail=?,StaffAddress=?, StaffCity=?,StaffCountry=?, DepartmentID=?,RoleID=?,StaffLastestLogin where StaffID=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, s.getStaffname());			
			ps.setString(2, s.getStafftel());
                        ps.setDate(3, s.getStaffdob());
                        ps.setString(4, s.getStaffemail());
			ps.setString(5, s.getStaffaddress());
			ps.setString(6, s.getStaffcity());
                        ps.setString(7, s.getStaffcountry());
                        ps.setString(8, s.getDepartmentid());
                        ps.setString(9, s.getRoleid());
			ps.setDate(10, s.getStafflastestlogin());
			ps.executeUpdate();
		} catch (SQLException ex) {
                        Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
                    close();
                }
	}
     
     public void close(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
