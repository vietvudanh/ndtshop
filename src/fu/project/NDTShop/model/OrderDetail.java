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
public class OrderDetail {
    private String orderdetailid;
    private float productexportprice;
    private String orderid;
    private int productsalequantity;
    private float discount;

    public OrderDetail() {
    }

    public OrderDetail(String orderdetailid, float productexportprice, String orderid, int productsalequantity, float discount) {
        this.orderdetailid = orderdetailid;
        this.productexportprice = productexportprice;
        this.orderid = orderid;
        this.productsalequantity = productsalequantity;
        this.discount = discount;
    }

    public String getOrderdetailid() {
        return orderdetailid;
    }

    public void setOrderdetailid(String orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    public float getProductexportprice() {
        return productexportprice;
    }

    public void setProductexportprice(float productexportprice) {
        this.productexportprice = productexportprice;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public int getProductsalequantity() {
        return productsalequantity;
    }

    public void setProductsalequantity(int productsalequantity) {
        this.productsalequantity = productsalequantity;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "orderdetailid=" + orderdetailid + ", productexportprice=" + productexportprice + ", orderid=" + orderid + ", productsalequantity=" + productsalequantity + ", discount=" + discount + '}';
    }
    
}
