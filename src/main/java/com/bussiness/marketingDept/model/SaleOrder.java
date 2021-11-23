package com.bussiness.marketingDept.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "sale_order")
public class SaleOrder {

    @Id
    @Column(length = 6)
    private String orderNo;

    private Date orderDate;

    
    @ManyToOne(targetEntity = ClientMaster.class)
    private ClientMaster clientNo;

    @Column(length = 25)
    private String delyAddr;

    
    @ManyToOne(targetEntity = SalesmanMaster.class)
    private SalesmanMaster salesmanNo;


    @Enumerated(EnumType.STRING)
    private DeliveryType delyType;

    @Column(length = 1)
    private Character billedYn;

    private Date delyDate;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


    @OneToMany(mappedBy = "orderNo",cascade = CascadeType.ALL)
    @JsonIgnore
    Set<SaleOrderDetails> orderquantity=new HashSet<>();

    public Set<SaleOrderDetails> getOrderquantity() {
        return this.orderquantity;
    }

    public void setOrderquantity(Set<SaleOrderDetails> orderquantity) {
        this.orderquantity = orderquantity;
    }

    // @JoinTable(name = "sale_order_details")
    // @ManyToMany(targetEntity = Product_Master.class)
    // private List<Product_Master> productNo;


    public enum DeliveryType {
        PART("P"),FULL("F");

        private String code;

        DeliveryType(String code) {
            this.code=code;
        }

        public String getCode() {
            return code;
        }
    }

    public enum OrderStatus{
        INPROCESS,FULFILLED,BACKORDER,CANCELLED;
    }

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

    // /**
    //  * @return List<Product_Master> return the productNo
    //  */
    // public List<Product_Master> getProductNo() {
    //     return productNo;
    // }

    // /**
    //  * @param productNo the productNo to set
    //  */
    // public void setProductNo(List<Product_Master> productNo) {
    //     this.productNo = productNo;
    // }


}
