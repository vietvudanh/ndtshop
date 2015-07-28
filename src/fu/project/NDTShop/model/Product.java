/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.project.NDTShop.model;

import java.awt.Image;

/**
 *
 * @author Lucci
 */
public class Product {
    private String productid;
    private String productname;
    private String productdescription;
    private String productimage;
    private float productsaleprice;
    private String subcategoryid;

    public Product() {
    }

    public Product(
    		String productid, 
    		String productname, 
    		String productdescription, 
    		String productimage, 
    		float productsaleprice, 
    		String subcategoryid) {
        this.productid = productid;
        this.productname = productname;
        this.productdescription = productdescription;
        this.productimage = productimage;
        this.productsaleprice = productsaleprice;
        this.subcategoryid = subcategoryid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    public float getProductsaleprice() {
        return productsaleprice;
    }

    public void setProductsaleprice(float productsaleprice) {
        this.productsaleprice = productsaleprice;
    }

    public String getSubcategoryid() {
        return subcategoryid;
    }

    public void setSubcategoryid(String subcategoryid) {
        this.subcategoryid = subcategoryid;
    }

    @Override
    public String toString() {
        return "Product{" + "productid=" + productid + ", productname=" + productname + ", productdescription=" + productdescription + ", productimage=" + productimage + ", productsaleprice=" + productsaleprice + ", subcategoryid=" + subcategoryid + '}';
    }
    
}
