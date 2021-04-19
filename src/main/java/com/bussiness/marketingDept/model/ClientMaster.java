package com.bussiness.marketingDept.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientMaster {

    @Id
    @Column(name = "Client_no", length = 6)
    private String clientNo;

    @Column(name="name",length = 20,nullable = false)
    private String name;

    @Column(name = "address1",length = 30)
    private String address1;

    @Column(name = "address2",length = 30)
    private String address2;

    @Column(name = "city",length = 15)
    private String city;

    @Column(name = "pincode",length = 8)
    private Long pincode;

    @Column(name = "state",length = 15)
    private String state;

    @Column(name = "bal_due", length = 10)
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
        return "Client_master [address1=" + address1 + ", address2=" + address2 + ", balanceDue=" + balanceDue
                + ", city=" + city + ", clientNo=" + clientNo + ", name=" + name + ", pincode=" + pincode + ", state="
                + state + "]";
    }


}
