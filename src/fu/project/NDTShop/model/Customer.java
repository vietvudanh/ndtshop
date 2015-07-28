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
public class Customer {
    private String customerid;
    private String customername;
    private Date customerdob;
    private String customertel;
    private String customeremail;
    private String customeraddress;
    private String customercity;
    private String customercountry;
    private Date customerlastestlogin;

    public Customer() {
    }

    public Customer(String customerid, String customername, Date customerdob, String customertel, String customeremail, String customeraddress, String customercity, String customercountry, Date customerlastestlogin) {
        this.customerid = customerid;
        this.customername = customername;
        this.customerdob = customerdob;
        this.customertel = customertel;
        this.customeremail = customeremail;
        this.customeraddress = customeraddress;
        this.customercity = customercity;
        this.customercountry = customercountry;
        this.customerlastestlogin = customerlastestlogin;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public Date getCustomerdob() {
        return customerdob;
    }

    public void setCustomerdob(Date customerdob) {
        this.customerdob = customerdob;
    }

    public String getCustomertel() {
        return customertel;
    }

    public void setCustomertel(String customertel) {
        this.customertel = customertel;
    }

    public String getCustomeremail() {
        return customeremail;
    }

    public void setCustomeremail(String customeremail) {
        this.customeremail = customeremail;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    public String getCustomercity() {
        return customercity;
    }

    public void setCustomercity(String customercity) {
        this.customercity = customercity;
    }

    public String getCustomercountry() {
        return customercountry;
    }

    public void setCustomercountry(String customercountry) {
        this.customercountry = customercountry;
    }

    public Date getCustomerlastestlogin() {
        return customerlastestlogin;
    }

    public void setCustomerlastestlogin(Date customerlastestlogin) {
        this.customerlastestlogin = customerlastestlogin;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerid=" + customerid + ", customername=" + customername + ", customerdob=" + customerdob + ", customertel=" + customertel + ", customeremail=" + customeremail + ", customeraddress=" + customeraddress + ", customercity=" + customercity + ", customercountry=" + customercountry + ", customerlastestlogin=" + customerlastestlogin + '}';
    }
    
}
