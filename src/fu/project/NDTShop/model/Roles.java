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
public class Roles {
    private String roleid;
    private String rolename;

    public Roles() {
    }

    public Roles(String roleid, String rolename) {
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "Roles{" + "roleid=" + roleid + ", rolename=" + rolename + '}';
    }
    
}
