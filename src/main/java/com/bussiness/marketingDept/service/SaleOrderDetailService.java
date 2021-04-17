package com.bussiness.marketingDept.service;

import com.bussiness.marketingDept.model.ProductOrderedKeys;
import com.bussiness.marketingDept.model.SaleOrderDetails;
import com.bussiness.marketingDept.repository.SaleOrderDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleOrderDetailService {
    
    @Autowired
    private SaleOrderDetailsRepository saleOrderDetailsRepository;

    public void saveData(SaleOrderDetails saleOrderDetails){
        // System.out.println("SaleOrder********"+saleOrderDetails.getOrderNo());
        // System.out.print("Product    ^^^^^^^^^"+saleOrderDetails.getProductNo());
        // System.out.println("Id$$$$"+saleOrderDetails.getId());
       saleOrderDetailsRepository.save(saleOrderDetails);
    }

    public Iterable<SaleOrderDetails> getAllsale_order(){
        return saleOrderDetailsRepository.findAll();
    }

    public SaleOrderDetails getById(String orderNo,String productNo){
        ProductOrderedKeys productOrderedKeys=new ProductOrderedKeys(orderNo,productNo);
        return saleOrderDetailsRepository.findById(productOrderedKeys).get();
    }
}
