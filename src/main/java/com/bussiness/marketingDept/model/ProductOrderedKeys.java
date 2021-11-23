package com.bussiness.marketingDept.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductOrderedKeys implements Serializable {

    private static final long serialVersionUID = 1L;

    
    @Column(name = "order_no",length = 6)
    private String orderNo;

    @Column(name = "product_no",length = 6)
    private String productNo;    


    public ProductOrderedKeys() {
    }

    public ProductOrderedKeys(String orderNo, String productNo) {
        this.orderNo = orderNo;
        this.productNo = productNo;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductNo() {
        return this.productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public ProductOrderedKeys orderNo(String orderNo) {
        setOrderNo(orderNo);
        return this;
    }

    public ProductOrderedKeys productNo(String productNo) {
        setProductNo(productNo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductOrderedKeys)) {
            return false;
        }
        ProductOrderedKeys productOrderedKeys = (ProductOrderedKeys) o;
        return Objects.equals(orderNo, productOrderedKeys.orderNo) && Objects.equals(productNo, productOrderedKeys.productNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNo, productNo);
    }

    @Override
    public String toString() {
        return "{" +
            " orderNo='" + getOrderNo() + "'" +
            ", productNo='" + getProductNo() + "'" +
            "}";
    }
    

    


}
