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
public class Comment {
    private String commentid;
    private String commentcontent;
    private String productid;
    private String customerid;
    private Date commentdate;

    public Comment() {
    }

    public Comment(String commentid, String commentcontent, String productid, String customerid, Date commentdate) {
        this.commentid = commentid;
        this.commentcontent = commentcontent;
        this.productid = productid;
        this.customerid = customerid;
        this.commentdate = commentdate;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public Date getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentid=" + commentid + ", commentcontent=" + commentcontent + ", productid=" + productid + ", customerid=" + customerid + ", commentdate=" + commentdate + '}';
    }
    
}
