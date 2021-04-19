package com.bussiness.marketingDept.DTO;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.bussiness.marketingDept.model.ClientMaster;
import com.bussiness.marketingDept.model.SaleOrderDetails;
import com.bussiness.marketingDept.model.SalesmanMaster;
import com.bussiness.marketingDept.model.SaleOrder.DeliveryType;
import com.bussiness.marketingDept.model.SaleOrder.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SaleOrderDTO {
    
    private String orderNo;

    private Date orderDate;
    
    private ClientMaster clientNo;
    
    private String delyAddr;
    
    private SalesmanMaster salesmanNo;
    
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

    public ClientMaster getClientNo() {
        return clientNo;
    }

    public void setClientNo(ClientMaster clientNo) {
        this.clientNo = clientNo;
    }

    public String getDelyAddr() {
        return delyAddr;
    }

    public void setDelyAddr(String delyAddr) {
        this.delyAddr = delyAddr;
    }

    public SalesmanMaster getSalesmanNo() {
        return salesmanNo;
    }

    public void setSalesmanNo(SalesmanMaster salesmanNo) {
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
