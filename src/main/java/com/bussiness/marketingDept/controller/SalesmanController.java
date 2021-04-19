package com.bussiness.marketingDept.controller;

import java.util.List;

import com.bussiness.marketingDept.dto.SalesmanDTO;
import com.bussiness.marketingDept.errorHandler.RequestErrorHandler;
import com.bussiness.marketingDept.service.SalesmanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("salesman")
public class SalesmanController {
    
    @Autowired
    private SalesmanService salesmanService;

    @PostMapping("/create")
    public RequestErrorHandler saveSalesmanData(@RequestBody SalesmanDTO salesmanDTO){
        return salesmanService.saveData(salesmanDTO);
    }

    @GetMapping("/getallsalesman")
    public List<SalesmanDTO> getAllSalesman(){
        
        return salesmanService.getAllSalesman();
    }

    @GetMapping("/getsalesmanbyid/{id}")
    public SalesmanDTO getSalesman(@PathVariable String id){
        return salesmanService.getSalesmanById(id);
    }

    @PutMapping(value="/updatesalesmanbyid/{id}")
    public SalesmanDTO updateSalesmnaById(@PathVariable String id, @RequestBody SalesmanDTO salesmanDTO) {
        
        return salesmanService.updateSalesmanById(salesmanDTO);
    }
}
