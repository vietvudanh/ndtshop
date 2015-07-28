/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.model;

/**
 *
 * @author Lucci
 */
public class Department {
    private String departmentid;
    private String departmentname;

    public Department() {
    }

    public Department(String departmentid, String departmentname) {
        this.departmentid = departmentid;
        this.departmentname = departmentname;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    @Override
    public String toString() {
        return "Department{" + "departmentid=" + departmentid + ", departmentname=" + departmentname + '}';
    }
    
}
