package com.bussiness.marketingDept.controller;

import java.util.ArrayList;
import java.util.List;

import com.bussiness.marketingDept.model.SaleOrderDetails;
import com.bussiness.marketingDept.service.SaleOrderDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderdetails")
public class SaleOrderDetailsController {
    
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @PostMapping("/create")
    public void saveData(@RequestBody SaleOrderDetails saleOrderDetails){
        saleOrderDetailService.saveData(saleOrderDetails);
    }

    @GetMapping("/retrive")
    public List<SaleOrderDetails> getAllOrderDetails(){
        List<SaleOrderDetails> allData=new ArrayList<>();
        saleOrderDetailService.getAllsale_order().forEach(order->allData.add(order));
        return allData;
    }

    @GetMapping("/retrivebyid/orderNo/{ord_no}/productNo/{prod_no}")
    public SaleOrderDetails getDetailsById(@PathVariable(name="ord_no") String orderNo,@PathVariable(name = "prod_no") String productNo){
    
        return saleOrderDetailService.getById(orderNo,productNo);

    }


}
