package com.bussiness.marketingDept.controller;

import java.util.List;

import com.bussiness.marketingDept.dto.SaleOrderDTO;
import com.bussiness.marketingDept.errorHandler.RequestErrorHandler;
import com.bussiness.marketingDept.service.SaleOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saleorder")
public class SaleOrderController {

    @Autowired
    private SaleOrderService saleOrderService;

    @PostMapping("/create")
    private RequestErrorHandler saveData(@RequestBody SaleOrderDTO saleOrderDTO){
        return saleOrderService.saveData(saleOrderDTO);
    }

    @GetMapping("/retrive")
    public List<SaleOrderDTO> getAllOrderedData(){

        return saleOrderService.getAllSalesOrder();

    }

    @GetMapping("/retrivebyid/{id}")
    public String getOrderedDataById(@PathVariable String id){
        return saleOrderService.getSaleOrderById(id);
    }

    @PutMapping("/updatebyid/{id}")
    public SaleOrderDTO updateOrderedById(@PathVariable String id,@RequestBody SaleOrderDTO saleOrderDTO){
        return saleOrderService.updateSalesmanById(saleOrderDTO);
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteById(@PathVariable String id){
        saleOrderService.deleteSaleOrderDataById(id);
    }
}
