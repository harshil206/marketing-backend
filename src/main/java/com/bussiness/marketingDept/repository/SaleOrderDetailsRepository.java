package com.bussiness.marketingDept.repository;

import com.bussiness.marketingDept.model.ProductOrderedKeys;
import com.bussiness.marketingDept.model.SaleOrderDetails;

import org.springframework.data.repository.CrudRepository;

public interface SaleOrderDetailsRepository extends CrudRepository<SaleOrderDetails,ProductOrderedKeys>{
    
}
