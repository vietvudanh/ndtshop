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
public class Category {
    private String categoryid;
    private String categoryname;
    private String categorydescription;

    public Category() {
    }

    public Category(String categoryid, String categoryname, String categorydescription) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
        this.categorydescription = categorydescription;
    }

    
    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getCategorydescription() {
        return categorydescription;
    }

    public void setCategorydescription(String categorydescription) {
        this.categorydescription = categorydescription;
    }

    @Override
    public String toString() {
        return categoryname;
    }
    
}
