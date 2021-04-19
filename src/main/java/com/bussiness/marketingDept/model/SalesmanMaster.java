package com.bussiness.marketingDept.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SalesmanMaster {

    @Id
    @Column(length = 6)
    private String salesmanNo;

    @Column(length = 20,nullable = false)
    private String salesmanName;

    @Column(length = 30,nullable = false)
    private String address1;

    @Column(length = 30)
    private String address2;

    @Column(length = 20)
    private String city;

    @Column(length = 8)
    private String pincode;

    @Column(length = 20)
    private String state;

    @Column(name = "sal_amt",length = 8,nullable = false)
    private Double saleAmount;

    @Column(length = 6,nullable = false )
    private Double tgtToGet;

    @Column(length = 6,nullable = false)
    private Double ytdSales;

    @Column(length = 60)
    private String remarks;

    public String getSalesmanNo() {
        return salesmanNo;
    }

    public void setSalesmanNo(String salesmanNo) {
        this.salesmanNo = salesmanNo;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Double getTgtToGet() {
        return tgtToGet;
    }

    public void setTgtToGet(Double tgtToGet) {
        this.tgtToGet = tgtToGet;
    }

    public Double getYtdSales() {
        return ytdSales;
    }

    public void setYtdSales(Double ytdSales) {
        this.ytdSales = ytdSales;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
