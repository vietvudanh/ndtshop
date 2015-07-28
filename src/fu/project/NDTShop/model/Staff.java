/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.model;

import java.sql.Date;

/**
 *
 * @author Lucci
 */
public class Staff {
    private String staffid;
    private String staffname;
    private String stafftel;
    private Date staffdob;
    private String staffemail;
    private String staffaddress;
    private String staffcity;
    private String staffcountry;
    private String departmentid;
    private String roleid;
    private Date stafflastestlogin;

    public Staff() {
    }

    public Staff(String staffid, String staffname, String stafftel, Date staffdob, String staffemail, String staffaddress, String staffcity, String staffcountry, String departmentid, String roleid, Date stafflastestlogin) {
        this.staffid = staffid;
        this.staffname = staffname;
        this.stafftel = stafftel;
        this.staffdob = staffdob;
        this.staffemail = staffemail;
        this.staffaddress = staffaddress;
        this.staffcity = staffcity;
        this.staffcountry = staffcountry;
        this.departmentid = departmentid;
        this.roleid = roleid;
        this.stafflastestlogin = stafflastestlogin;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStafftel() {
        return stafftel;
    }

    public void setStafftel(String stafftel) {
        this.stafftel = stafftel;
    }

    public Date getStaffdob() {
        return staffdob;
    }

    public void setStaffdob(Date staffdob) {
        this.staffdob = staffdob;
    }

    public String getStaffemail() {
        return staffemail;
    }

    public void setStaffemail(String staffemail) {
        this.staffemail = staffemail;
    }

    public String getStaffaddress() {
        return staffaddress;
    }

    public void setStaffaddress(String staffaddress) {
        this.staffaddress = staffaddress;
    }

    public String getStaffcity() {
        return staffcity;
    }

    public void setStaffcity(String staffcity) {
        this.staffcity = staffcity;
    }

    public String getStaffcountry() {
        return staffcountry;
    }

    public void setStaffcountry(String staffcountry) {
        this.staffcountry = staffcountry;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public Date getStafflastestlogin() {
        return stafflastestlogin;
    }

    public void setStafflastestlogin(Date stafflastestlogin) {
        this.stafflastestlogin = stafflastestlogin;
    }

    @Override
    public String toString() {
        return "Staff{" + "staffid=" + staffid + ", staffname=" + staffname + ", stafftel=" + stafftel + ", staffdob=" + staffdob + ", staffemail=" + staffemail + ", staffaddress=" + staffaddress + ", staffcity=" + staffcity + ", staffcountry=" + staffcountry + ", departmentid=" + departmentid + ", roleid=" + roleid + ", stafflastestlogin=" + stafflastestlogin + '}';
    }
    
}
