package com.bussiness.marketingDept.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bussiness.marketingDept.dto.SalesmanDTO;
import com.bussiness.marketingDept.errorHandler.RequestErrorHandler;
import com.bussiness.marketingDept.model.SalesmanMaster;
import com.bussiness.marketingDept.repository.SalesmanMasterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanMasterRepository salesmanMasterRepository;

    public RequestErrorHandler saveData(SalesmanDTO salesmanDTO){
        SalesmanMaster salesman_Master =new SalesmanMaster();
        RequestErrorHandler requestErrorHandler=new RequestErrorHandler();

        salesman_Master=salesmanDTOtosalesman(salesman_Master,salesmanDTO);

        try {
            salesmanMasterRepository.save(salesman_Master);
        }catch (Exception e){
            requestErrorHandler.setMessage("Some data is left or attribute is left out...");
            requestErrorHandler.setStatus("500");
            requestErrorHandler.setId(salesmanDTO.getSalesmanNo());
            return requestErrorHandler;
        }
        return requestErrorHandler;
    }

    public List<SalesmanDTO> getAllSalesman(){
        List<SalesmanDTO> salesmanDTOList=new ArrayList<>();
        List<SalesmanMaster> salesman_MasterList =new ArrayList<>();
        
        salesmanMasterRepository.findAll().forEach(salesman-> salesman_MasterList.add(salesman));
        for(SalesmanMaster salesman_Master : salesman_MasterList){
            SalesmanDTO salesmanDTO=new SalesmanDTO();
            salesmanDTO=salesmanTosalemanDTO(salesmanDTO,salesman_Master);
            salesmanDTOList.add(salesmanDTO);
        }
        return salesmanDTOList;
    }

    public String getSalesmanById(String id){
        SalesmanDTO salesmanDTO=new SalesmanDTO();
        Optional<SalesmanMaster> salesman_Master =salesmanMasterRepository.findById(id);

        if(salesman_Master.isPresent())
        {
            salesmanTosalemanDTO(salesmanDTO, salesman_Master.get());
            return salesmanDTO.toString();
        }
        else{
            RequestErrorHandler requestErrorHandler=new RequestErrorHandler();
            requestErrorHandler.setId(id);
            requestErrorHandler.setMessage("no such id is present...");
            requestErrorHandler.setStatus("500");
            requestErrorHandler.setResult("Error!!!");
            return requestErrorHandler.toString();
        }
    }

    public SalesmanDTO updateSalesmanById(SalesmanDTO salesmanDTO){

        SalesmanMaster salesman_Master =new SalesmanMaster();
        salesman_Master=salesmanDTOtosalesman(salesman_Master,salesmanDTO);
        salesmanMasterRepository.save(salesman_Master);

        return salesmanDTO;
    }    

    public void deleteSalesmanDataById(String id){
        salesmanMasterRepository.deleteById(id);
    }

    private SalesmanDTO salesmanTosalemanDTO(SalesmanDTO salesmanDTO,SalesmanMaster salesman_Master){
        salesmanDTO.setSalesmanNo(salesman_Master.getSalesmanNo());
        salesmanDTO.setSalesmanName(salesman_Master.getSalesmanName());
        salesmanDTO.setAddress1(salesman_Master.getAddress1());
        salesmanDTO.setAddress2(salesman_Master.getAddress2());
        salesmanDTO.setCity(salesman_Master.getCity());
        salesmanDTO.setPincode(salesman_Master.getPincode());
        salesmanDTO.setState(salesman_Master.getState());
        salesmanDTO.setSaleAmount(salesman_Master.getSaleAmount());
        salesmanDTO.setTgtToGet(salesman_Master.getTgtToGet());
        salesmanDTO.setYtdSales(salesman_Master.getYtdSales());
        salesmanDTO.setRemarks(salesman_Master.getRemarks());
        return salesmanDTO;

    }

    private SalesmanMaster salesmanDTOtosalesman(SalesmanMaster salesman_Master,SalesmanDTO salesmanDTO){
        salesman_Master.setSalesmanNo(salesmanDTO.getSalesmanNo());
        salesman_Master.setSalesmanName(salesmanDTO.getSalesmanName());
        salesman_Master.setAddress1(salesmanDTO.getAddress1());
        salesman_Master.setAddress2(salesmanDTO.getAddress2());
        salesman_Master.setCity(salesmanDTO.getCity());
        salesman_Master.setPincode(salesmanDTO.getPincode());
        salesman_Master.setState(salesmanDTO.getState());
        salesman_Master.setSaleAmount(salesmanDTO.getSaleAmount());
        salesman_Master.setTgtToGet(salesmanDTO.getTgtToGet());
        salesman_Master.setYtdSales(salesmanDTO.getYtdSales());
        salesman_Master.setRemarks(salesmanDTO.getRemarks());
        return salesman_Master;
    }
    
}
