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
public class SubCategory {
    private String subcategoryid;
    private String subcategoryname;
    private String subcategorydescription;
    private String categoryid;

    public SubCategory() {
    }

    public SubCategory(String subcategoryid, String subcategoryname, String subcategorydescription, String categoryid) {
        this.subcategoryid = subcategoryid;
        this.subcategoryname = subcategoryname;
        this.subcategorydescription = subcategorydescription;
        this.categoryid = categoryid;
    }

    public String getSubcategoryid() {
        return subcategoryid;
    }

    public void setSubcategoryid(String subcategoryid) {
        this.subcategoryid = subcategoryid;
    }

    public String getSubcategoryname() {
        return subcategoryname;
    }

    public void setSubcategoryname(String subcategoryname) {
        this.subcategoryname = subcategoryname;
    }

    public String getSubcategorydescription() {
        return subcategorydescription;
    }

    public void setSubcategorydescription(String subcategorydescription) {
        this.subcategorydescription = subcategorydescription;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public String toString() {
        return "SubCategory{" + "subcategoryid=" + subcategoryid + ", subcategoryname=" + subcategoryname + ", subcategorydescription=" + subcategorydescription + ", categoryid=" + categoryid + '}';
    }
    
}
