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
public class News {
    private String newsid;
    private String newstitle;
    private String newdescription;
    private String staffid;
    private Date newsposteddate;

    public News() {
    }

    public News(String newsid, String newstitle, String newdescription, String staffid, Date newsposteddate) {
        this.newsid = newsid;
        this.newstitle = newstitle;
        this.newdescription = newdescription;
        this.staffid = staffid;
        this.newsposteddate = newsposteddate;
    }

    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getNewdescription() {
        return newdescription;
    }

    public void setNewdescription(String newdescription) {
        this.newdescription = newdescription;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public Date getNewsposteddate() {
        return newsposteddate;
    }

    public void setNewsposteddate(Date newsposteddate) {
        this.newsposteddate = newsposteddate;
    }

    @Override
    public String toString() {
        return "News{" + "newsid=" + newsid + ", newstitle=" + newstitle + ", newdescription=" + newdescription + ", staffid=" + staffid + ", newsposteddate=" + newsposteddate + '}';
    }
    
}
