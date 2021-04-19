package com.bussiness.marketingDept.dto;

public class ClientDTO {
    
    private String clientNo;

    
    private String name;

    
    private String address1;

    
    private String address2;

    
    private String city;

    
    private Long pincode;

    
    private String state;

    
    private Double balanceDue;

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getBalanceDue() {
        return balanceDue;
    }

    public void setBalanceDue(Double balanceDue) {
        this.balanceDue = balanceDue;
    }

    @Override
    public String toString() {
        return "ClientDTO [address1=" + address1 + ", address2=" + address2 + ", balanceDue=" + balanceDue + ", city="
                + city + ", clientNo=" + clientNo + ", name=" + name + ", pincode=" + pincode + ", state=" + state
                + "]";
    }
    


}
