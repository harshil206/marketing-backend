package com.bussiness.marketingDept.model;



import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "sale_order_details")
// @IdClass(ProductOrderedKeys.class)
public class SaleOrderDetails{

    @EmbeddedId
    private ProductOrderedKeys id;
    
    @ManyToOne
    @MapsId("orderNo")
    @JoinColumn(name = "order_no")
    private SaleOrder orderNo;


    @ManyToOne
    @MapsId("productNo")
    @JoinColumn(name = "product_no")
    private ProductMaster productNo;



    @Column
    private Integer qtyOrdered;

    @Column
    private Integer qtyDisplay;

    @Column
    private Double productRate;

    public SaleOrderDetails() {
    }

    public SaleOrderDetails(ProductOrderedKeys id, SaleOrder orderNo, ProductMaster productNo, Integer qtyOrdered, Integer qtyDisplay, Double productRate) {
        this.id = id;
        this.orderNo = orderNo;
        this.productNo = productNo;
        this.qtyOrdered = qtyOrdered;
        this.qtyDisplay = qtyDisplay;
        this.productRate = productRate;
    }

    public ProductOrderedKeys getId() {
        return this.id;
    }

    public void setId(ProductOrderedKeys id) {
        this.id = id;
    }

    public SaleOrder getOrderNo() {
        return this.orderNo;
    }

    public void setOrderNo(SaleOrder orderNo) {
        this.orderNo = orderNo;
    }

    public ProductMaster getProductNo() {
        return this.productNo;
    }

    public void setProductNo(ProductMaster productNo) {
        this.productNo = productNo;
    }

    public Integer getQtyOrdered() {
        return this.qtyOrdered;
    }

    public void setQtyOrdered(Integer qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public Integer getQtyDisplay() {
        return this.qtyDisplay;
    }

    public void setQtyDisplay(Integer qtyDisplay) {
        this.qtyDisplay = qtyDisplay;
    }

    public Double getProductRate() {
        return this.productRate;
    }

    public void setProductRate(Double productRate) {
        this.productRate = productRate;
    }

    public SaleOrderDetails id(ProductOrderedKeys id) {
        setId(id);
        return this;
    }

    public SaleOrderDetails orderNo(SaleOrder orderNo) {
        setOrderNo(orderNo);
        return this;
    }

    public SaleOrderDetails productNo(ProductMaster productNo) {
        setProductNo(productNo);
        return this;
    }

    public SaleOrderDetails qtyOrdered(Integer qtyOrdered) {
        setQtyOrdered(qtyOrdered);
        return this;
    }

    public SaleOrderDetails qtyDisplay(Integer qtyDisplay) {
        setQtyDisplay(qtyDisplay);
        return this;
    }

    public SaleOrderDetails productRate(Double productRate) {
        setProductRate(productRate);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SaleOrderDetails)) {
            return false;
        }
        SaleOrderDetails saleOrderDetails = (SaleOrderDetails) o;
        return Objects.equals(id, saleOrderDetails.id) && Objects.equals(orderNo, saleOrderDetails.orderNo) && Objects.equals(productNo, saleOrderDetails.productNo) && Objects.equals(qtyOrdered, saleOrderDetails.qtyOrdered) && Objects.equals(qtyDisplay, saleOrderDetails.qtyDisplay) && Objects.equals(productRate, saleOrderDetails.productRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNo, productNo, qtyOrdered, qtyDisplay, productRate);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", orderNo='" + getOrderNo() + "'" +
            ", productNo='" + getProductNo() + "'" +
            ", qtyOrdered='" + getQtyOrdered() + "'" +
            ", qtyDisplay='" + getQtyDisplay() + "'" +
            ", productRate='" + getProductRate() + "'" +
            "}";
    }

    
}