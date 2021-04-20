package com.bussiness.marketingDept.service;

import com.bussiness.marketingDept.errorHandler.RequestErrorHandler;
import com.bussiness.marketingDept.model.ProductOrderedKeys;
import com.bussiness.marketingDept.model.SaleOrderDetails;
import com.bussiness.marketingDept.repository.SaleOrderDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public String getById(String orderNo,String productNo){
        ProductOrderedKeys productOrderedKeys=new ProductOrderedKeys(orderNo,productNo);

        Optional<SaleOrderDetails> saleOrderDetails=saleOrderDetailsRepository.findById(productOrderedKeys);
        if(saleOrderDetails.isPresent()){
            return saleOrderDetails.get().toString();
        }else {
            RequestErrorHandler requestErrorHandler=new RequestErrorHandler();
            requestErrorHandler.setId(orderNo+"  "+productNo);
            requestErrorHandler.setMessage("Error. No such id is present...");
            requestErrorHandler.setStatus("500");
            requestErrorHandler.setResult("Error!!!");
            return requestErrorHandler.toString();
        }

    }
}
