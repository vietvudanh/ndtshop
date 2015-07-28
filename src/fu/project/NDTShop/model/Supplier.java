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
public class Supplier {
    private String supplierid;
    private String suppliername;
    private String suppliertel;
    private String supplieremail;
    private String supplieraddress;
    private String suppliercity;
    private String suppliercountry;

    public Supplier() {
    }

    public Supplier(String supplierid, String suppliername, String suppliertel, String supplieremail, String supplieraddress, String suppliercity, String suppliercountry) {
        this.supplierid = supplierid;
        this.suppliername = suppliername;
        this.suppliertel = suppliertel;
        this.supplieremail = supplieremail;
        this.supplieraddress = supplieraddress;
        this.suppliercity = suppliercity;
        this.suppliercountry = suppliercountry;
    }

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getSuppliertel() {
        return suppliertel;
    }

    public void setSuppliertel(String suppliertel) {
        this.suppliertel = suppliertel;
    }

    public String getSupplieremail() {
        return supplieremail;
    }

    public void setSupplieremail(String supplieremail) {
        this.supplieremail = supplieremail;
    }

    public String getSupplieraddress() {
        return supplieraddress;
    }

    public void setSupplieraddress(String supplieraddress) {
        this.supplieraddress = supplieraddress;
    }

    public String getSuppliercity() {
        return suppliercity;
    }

    public void setSuppliercity(String suppliercity) {
        this.suppliercity = suppliercity;
    }

    public String getSuppliercountry() {
        return suppliercountry;
    }

    public void setSuppliercountry(String suppliercountry) {
        this.suppliercountry = suppliercountry;
    }

    @Override
    public String toString() {
        return "Supplier{" + "supplierid=" + supplierid + ", suppliername=" + suppliername + ", suppliertel=" + suppliertel + ", supplieremail=" + supplieremail + ", supplieraddress=" + supplieraddress + ", suppliercity=" + suppliercity + ", suppliercountry=" + suppliercountry + '}';
    }
    
}
