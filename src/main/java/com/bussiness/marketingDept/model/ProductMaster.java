package com.bussiness.marketingDept.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProductMaster {

    @Id
    @Column(length = 6)
    private String productNo;

    @Column(length = 15,nullable = false)
    private String description;

    @Column(length = 4,nullable = false)
    private Double profilePercent;

    @Column(length = 10,nullable = false)
    private String unitMeasure;

    @Column(name = "qty_no_hand",length = 8,nullable = false)
    private Long quantityNoHand;

    @Column(name = "reorder_lvl",length = 8,nullable = false)
    private Long reorderLvl;

    @Column(length = 8,nullable = false)
    private Double sellPrice;

    @Column(length = 8,nullable = false)
    private Double costPrice;

    @OneToMany(mappedBy = "productNo",cascade = CascadeType.ALL)
    @JsonIgnore
    Set<SaleOrderDetails> productRate=new HashSet<>();

    public Set<SaleOrderDetails> getProductRate() {
        return this.productRate;
    }

    public void setProductRate(Set<SaleOrderDetails> productRate) {
        this.productRate = productRate;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getProfilePercent() {
        return profilePercent;
    }

    public void setProfilePercent(Double profilePercent) {
        this.profilePercent = profilePercent;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public Long getQuantityNoHand() {
        return quantityNoHand;
    }

    public void setQuantityNoHand(Long quantityNoHand) {
        this.quantityNoHand = quantityNoHand;
    }

    public Long getReorderLvl() {
        return reorderLvl;
    }

    public void setReorderLvl(Long reorderLvl) {
        this.reorderLvl = reorderLvl;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }
}
