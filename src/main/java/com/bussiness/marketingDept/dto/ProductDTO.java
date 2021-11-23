package com.bussiness.marketingDept.dto;

import java.util.HashSet;
import java.util.Set;

import com.bussiness.marketingDept.model.SaleOrderDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductDTO {
    
    private String productNo;

    
    private String description;

    
    private Double profilePercent;

    
    private String unitMeasure;

    
    private Long quantityNoHand;

    
    private Long reorderLvl;

    
    private Double sellPrice;

    
    private Double costPrice;

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

    @Override
    public String toString() {
        return "{" +
                "productNo=" + productNo + '\n' +
                ", description=" + description + '\n' +
                ", profilePercent=" + profilePercent +
                ", unitMeasure=" + unitMeasure + '\n' +
                ", quantityNoHand=" + quantityNoHand +
                ", reorderLvl=" + reorderLvl +
                ", sellPrice=" + sellPrice +
                ", costPrice=" + costPrice +
                ", productRate=" + productRate +
                '}';
    }
}
