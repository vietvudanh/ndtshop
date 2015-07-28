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
public class Orders {
    private String orderid;
    private String customerid;
    private String staffid;
    private Date orderdate;
    private Date saledate;

    public Orders() {
    }

    public Orders(String orderid, String customerid, String staffid, Date orderdate, Date saledate) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.staffid = staffid;
        this.orderdate = orderdate;
        this.saledate = saledate;
    }

    
    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getSaledate() {
        return saledate;
    }

    public void setSaledate(Date saledate) {
        this.saledate = saledate;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderid=" + orderid + ", customerid=" + customerid + ", staffid=" + staffid + ", orderdate=" + orderdate + ", saledate=" + saledate + '}';
    }
    
}
