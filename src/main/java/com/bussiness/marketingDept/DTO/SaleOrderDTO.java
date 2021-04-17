package com.bussiness.marketingDept.DTO;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.bussiness.marketingDept.model.Client_master;
import com.bussiness.marketingDept.model.SaleOrderDetails;
import com.bussiness.marketingDept.model.Salesman_MAster;
import com.bussiness.marketingDept.model.Sale_Order.DeliveryType;
import com.bussiness.marketingDept.model.Sale_Order.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SaleOrderDTO {
    
    private String orderNo;

    private Date orderDate;
    
    private Client_master clientNo;
    
    private String delyAddr;
    
    private Salesman_MAster salesmanNo;
    
    private DeliveryType delyType;
    
    private Character billedYn;

    private Date delyDate;
    
    private OrderStatus orderStatus;

    @JsonIgnore
    Set<SaleOrderDetails> orderquantity=new HashSet<>();

    public Set<SaleOrderDetails> getOrderquantity() {
        return this.orderquantity;
    }

    public void setOrderquantity(Set<SaleOrderDetails> orderquantity) {
        this.orderquantity = orderquantity;
    }

    // public enum DeliveryType {
    //     PART("P"),FULL("F");

    //     private String code;

    //     DeliveryType(String code) {
    //         this.code=code;
    //     }

    //     public String getCode() {
    //         return code;
    //     }
    // }

    // public enum OrderStatus{
    //     INPROCESS,FULFILLED,BACKORDER,CANCELLED;
    // }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Client_master getClientNo() {
        return clientNo;
    }

    public void setClientNo(Client_master clientNo) {
        this.clientNo = clientNo;
    }

    public String getDelyAddr() {
        return delyAddr;
    }

    public void setDelyAddr(String delyAddr) {
        this.delyAddr = delyAddr;
    }

    public Salesman_MAster getSalesmanNo() {
        return salesmanNo;
    }

    public void setSalesmanNo(Salesman_MAster salesmanNo) {
        this.salesmanNo = salesmanNo;
    }

    public DeliveryType getDelyType() {
        return delyType;
    }

    public void setDelyType(DeliveryType delyType) {
        this.delyType = delyType;
    }

    public Character getBilledYn() {
        return billedYn;
    }

    public void setBilledYn(Character billedYn) {
        this.billedYn = billedYn;
    }

    public Date getDelyDate() {
        return delyDate;
    }

    public void setDelyDate(Date delyDate) {
        this.delyDate = delyDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}
