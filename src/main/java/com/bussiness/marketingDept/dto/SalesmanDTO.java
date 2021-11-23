package com.bussiness.marketingDept.dto;

public class SalesmanDTO {
    
    private String salesmanNo;

    private String salesmanName;

    private String address1;

    private String address2;

    private String city;

    private String pincode;

    private String state;

    private Double saleAmount;

    private Double tgtToGet;

    private Double ytdSales;

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

    @Override
    public String toString() {
        return "{" +
                "salesmanNo=" + salesmanNo + '\n' +
                ", salesmanName=" + salesmanName + '\n' +
                ", address1=" + address1 + '\n' +
                ", address2=" + address2 + '\n' +
                ", city=" + city + '\n' +
                ", pincode=" + pincode + '\n' +
                ", state=" + state + '\n' +
                ", saleAmount=" + saleAmount +
                ", tgtToGet=" + tgtToGet +
                ", ytdSales=" + ytdSales +
                ", remarks=" + remarks +
                '}';
    }
}
