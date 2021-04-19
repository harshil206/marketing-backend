package com.bussiness.marketingDept.controller;


import java.util.List;

import com.bussiness.marketingDept.dto.ProductDTO;
import com.bussiness.marketingDept.errorHandler.RequestErrorHandler;
import com.bussiness.marketingDept.service.ProductMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductMasterService productMasterService;

    @PostMapping("/create")
    public RequestErrorHandler saveData(@RequestBody ProductDTO productDTO){
        return productMasterService.saveProduct(productDTO);
    }

    @GetMapping("/retrive")
    public List<ProductDTO> getAllProduct(){
        
        return productMasterService.getAllProduct();
        
    }

    @GetMapping("/retrivebyid/{id}")
    public ProductDTO getProductById(@PathVariable String id){
        return productMasterService.getProductById(id);
    }

    @PutMapping(value="/updatebyid/{id}")
    public ProductDTO updateProductById(@PathVariable String id, @RequestBody ProductDTO productDTO) {
        
        return productMasterService.updateProductById(productDTO);
    }

    @DeleteMapping(".removeproduct/{id}")
    public void removeProduct(@PathVariable String id){
        productMasterService.deleteProductDataById(id);
    }
 }
