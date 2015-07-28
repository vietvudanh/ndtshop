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
public class ProductSupplier {
    private String supplierid;
    private String productid;
    private float productimportprice;
    private Date productimportdate;
    private int productimportquantity;

    public ProductSupplier() {
    }

    public ProductSupplier(String supplierid, String productid, float productimportprice, Date productimportdate, int productimportquantity) {
        this.supplierid = supplierid;
        this.productid = productid;
        this.productimportprice = productimportprice;
        this.productimportdate = productimportdate;
        this.productimportquantity = productimportquantity;
    }

    
    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public float getProductimportprice() {
        return productimportprice;
    }

    public void setProductimportprice(float productimportprice) {
        this.productimportprice = productimportprice;
    }

    public Date getProductimportdate() {
        return productimportdate;
    }

    public void setProductimportdate(Date productimportdate) {
        this.productimportdate = productimportdate;
    }

    public int getProductimportquantity() {
        return productimportquantity;
    }

    public void setProductimportquantity(int productimportquantity) {
        this.productimportquantity = productimportquantity;
    }

    @Override
    public String toString() {
        return "ProductSupplier{" + "supplierid=" + supplierid + ", productid=" + productid + ", productimportprice=" + productimportprice + ", productimportdate=" + productimportdate + ", productimportquantity=" + productimportquantity + '}';
    }
    
}
