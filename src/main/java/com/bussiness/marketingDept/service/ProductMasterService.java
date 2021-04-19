package com.bussiness.marketingDept.service;

import java.util.ArrayList;
import java.util.List;

import com.bussiness.marketingDept.DTO.ProductDTO;
import com.bussiness.marketingDept.model.ProductMaster;
import com.bussiness.marketingDept.repository.ProductMasterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMasterService {
   
    @Autowired
    private ProductMasterRepository productMasterRepository;

    public void saveProduct(ProductDTO productDTO){
        ProductMaster productMaster= new ProductMaster();

        productMaster.setProductNo(productDTO.getProductNo());
        productMaster.setDescription(productDTO.getDescription());
        productMaster.setCostPrice(productDTO.getCostPrice());
        productMaster.setProductRate(productDTO.getProductRate());
        productMaster.setProfilePercent(productDTO.getProfilePercent());
        productMaster.setQuantityNoHand(productDTO.getQuantityNoHand());
        productMaster.setReorderLvl(productDTO.getReorderLvl());
        productMaster.setSellPrice(productDTO.getSellPrice());
        productMaster.setUnitMeasure(productDTO.getUnitMeasure());

        productMasterRepository.save(productMaster);
    }

    
    public List<ProductDTO> getAllProduct(){
        List<ProductDTO> productDTOList=new ArrayList<>();
        List<ProductMaster> product_MasterList=new ArrayList<>();

        productMasterRepository.findAll().forEach(product->product_MasterList.add(product));
        for(ProductMaster product_Master:product_MasterList){
            ProductDTO productDTO=new ProductDTO();
            productDTO.setProductNo(product_Master.getProductNo());
            productDTO.setDescription(product_Master.getDescription());
            productDTO.setCostPrice(product_Master.getCostPrice());
            productDTO.setProductRate(product_Master.getProductRate());
            productDTO.setProfilePercent(product_Master.getProfilePercent());
            productDTO.setQuantityNoHand(product_Master.getQuantityNoHand());
            productDTO.setReorderLvl(product_Master.getReorderLvl());
            productDTO.setSellPrice(product_Master.getSellPrice());
            productDTO.setUnitMeasure(product_Master.getUnitMeasure());
            
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }

    public ProductDTO getProductById(String id){
            ProductMaster product_Master=productMasterRepository.findById(id).get();
            ProductDTO productDTO=new ProductDTO();
            productDTO.setProductNo(product_Master.getProductNo());
            productDTO.setDescription(product_Master.getDescription());
            productDTO.setCostPrice(product_Master.getCostPrice());
            productDTO.setProductRate(product_Master.getProductRate());
            productDTO.setProfilePercent(product_Master.getProfilePercent());
            productDTO.setQuantityNoHand(product_Master.getQuantityNoHand());
            productDTO.setReorderLvl(product_Master.getReorderLvl());
            productDTO.setSellPrice(product_Master.getSellPrice());
            productDTO.setUnitMeasure(product_Master.getUnitMeasure()); 

            return productDTO;
    }

    public ProductDTO updateProductById(ProductDTO productDTO){
        ProductMaster productMaster= new ProductMaster();

        productMaster.setProductNo(productDTO.getProductNo());
        productMaster.setDescription(productDTO.getDescription());
        productMaster.setCostPrice(productDTO.getCostPrice());
        productMaster.setProductRate(productDTO.getProductRate());
        productMaster.setProfilePercent(productDTO.getProfilePercent());
        productMaster.setQuantityNoHand(productDTO.getQuantityNoHand());
        productMaster.setReorderLvl(productDTO.getReorderLvl());
        productMaster.setSellPrice(productDTO.getSellPrice());
        productMaster.setUnitMeasure(productDTO.getUnitMeasure());

        productMasterRepository.save(productMaster);
        
        return productDTO;
    }

    public void deleteProductDataById(String id){
        productMasterRepository.deleteById(id);
    }

}
