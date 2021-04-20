package com.bussiness.marketingDept.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bussiness.marketingDept.dto.ProductDTO;
import com.bussiness.marketingDept.errorHandler.RequestErrorHandler;
import com.bussiness.marketingDept.model.ProductMaster;
import com.bussiness.marketingDept.repository.ProductMasterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMasterService {
   
    @Autowired
    private ProductMasterRepository productMasterRepository;

    public RequestErrorHandler saveProduct(ProductDTO productDTO){
        ProductMaster productMaster= new ProductMaster();
        RequestErrorHandler requestErrorHandler=new RequestErrorHandler();
        productMaster=productDTOtoProductMaster(productDTO,productMaster);
        try {
            productMasterRepository.save(productMaster);
        }catch (Exception e) {
            requestErrorHandler.setMessage("Some data is left or attribute is left out...");
            requestErrorHandler.setStatus("500");
            requestErrorHandler.setId(productDTO.getProductNo());
            return requestErrorHandler;
        }
        return requestErrorHandler;
    }

    
    public List<ProductDTO> getAllProduct(){
        List<ProductDTO> productDTOList=new ArrayList<>();
        List<ProductMaster> product_MasterList=new ArrayList<>();

        productMasterRepository.findAll().forEach(product->product_MasterList.add(product));
        for(ProductMaster product_Master:product_MasterList){
            ProductDTO productDTO=new ProductDTO();
            productDTO=productMasterToProductDTO(productDTO,product_Master);
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }

    public String getProductById(String id){
        ProductDTO productDTO=new ProductDTO();
        Optional<ProductMaster> product_Master=productMasterRepository.findById(id);

        if(product_Master.isPresent()) {
            productMasterToProductDTO(productDTO, product_Master.get());
            return productDTO.toString();
        }
        else
        {
            RequestErrorHandler requestErrorHandler=new RequestErrorHandler();
            requestErrorHandler.setId(id);
            requestErrorHandler.setMessage("Error. No such id is present...");
            requestErrorHandler.setStatus("500");
            requestErrorHandler.setResult("Error!!!");
            return requestErrorHandler.toString();
        }
    }

    public ProductDTO updateProductById(ProductDTO productDTO){
        ProductMaster productMaster= new ProductMaster();
        productMaster=productDTOtoProductMaster(productDTO,productMaster);
        productMasterRepository.save(productMaster);
        
        return productDTO;
    }

    public void deleteProductDataById(String id){
        productMasterRepository.deleteById(id);
    }


    private ProductMaster productDTOtoProductMaster(ProductDTO productDTO,ProductMaster productMaster){

        productMaster.setProductNo(productDTO.getProductNo());
        productMaster.setDescription(productDTO.getDescription());
        productMaster.setCostPrice(productDTO.getCostPrice());
        productMaster.setProductRate(productDTO.getProductRate());
        productMaster.setProfilePercent(productDTO.getProfilePercent());
        productMaster.setQuantityNoHand(productDTO.getQuantityNoHand());
        productMaster.setReorderLvl(productDTO.getReorderLvl());
        productMaster.setSellPrice(productDTO.getSellPrice());
        productMaster.setUnitMeasure(productDTO.getUnitMeasure());
        return productMaster;
    }

    private ProductDTO productMasterToProductDTO(ProductDTO productDTO,ProductMaster product_Master){
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

}
