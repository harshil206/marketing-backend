package com.bussiness.marketingDept.service;

import java.util.ArrayList;
import java.util.List;

import com.bussiness.marketingDept.DTO.SalesmanDTO;
import com.bussiness.marketingDept.model.Salesman_MAster;
import com.bussiness.marketingDept.repository.SalesmanMasterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanMasterRepository salesmanMasterRepository;

    public void saveData(SalesmanDTO salesmanDTO){
        Salesman_MAster salesman_MAster=new Salesman_MAster();

        salesman_MAster.setSalesmanNo(salesmanDTO.getSalesmanNo());
        salesman_MAster.setSalesmanName(salesmanDTO.getSalesmanName());
        salesman_MAster.setAddress1(salesmanDTO.getAddress1());
        salesman_MAster.setAddress2(salesmanDTO.getAddress2());
        salesman_MAster.setCity(salesmanDTO.getCity());
        salesman_MAster.setPincode(salesmanDTO.getPincode());
        salesman_MAster.setState(salesmanDTO.getState());
        salesman_MAster.setSaleAmount(salesmanDTO.getSaleAmount());
        salesman_MAster.setTgtToGet(salesmanDTO.getTgtToGet());
        salesman_MAster.setYtdSales(salesmanDTO.getYtdSales());
        salesman_MAster.setRemarks(salesmanDTO.getRemarks());

        salesmanMasterRepository.save(salesman_MAster);
    }

    public List<SalesmanDTO> getAllSalesman(){
        List<SalesmanDTO> salesmanDTOList=new ArrayList<>();
        List<Salesman_MAster> salesman_MAsterList=new ArrayList<>();
        
        salesmanMasterRepository.findAll().forEach(salesman->salesman_MAsterList.add(salesman));
        for(Salesman_MAster salesman_MAster:salesman_MAsterList){
            SalesmanDTO salesmanDTO=new SalesmanDTO();
            salesmanDTO.setSalesmanNo(salesman_MAster.getSalesmanNo());
            salesmanDTO.setSalesmanName(salesman_MAster.getSalesmanName());
            salesmanDTO.setAddress1(salesman_MAster.getAddress1());
            salesmanDTO.setAddress2(salesman_MAster.getAddress2());
            salesmanDTO.setCity(salesman_MAster.getCity());
            salesmanDTO.setPincode(salesman_MAster.getPincode());
            salesmanDTO.setState(salesman_MAster.getState());
            salesmanDTO.setSaleAmount(salesman_MAster.getSaleAmount());
            salesmanDTO.setTgtToGet(salesman_MAster.getTgtToGet());
            salesmanDTO.setYtdSales(salesman_MAster.getYtdSales());
            salesmanDTO.setRemarks(salesman_MAster.getRemarks());

            salesmanDTOList.add(salesmanDTO);
        }
        return salesmanDTOList;
    }

    public SalesmanDTO getSalesmanById(String id){
        Salesman_MAster salesman_MAster=salesmanMasterRepository.findById(id).get();
        SalesmanDTO salesmanDTO=new SalesmanDTO();
            salesmanDTO.setSalesmanNo(salesman_MAster.getSalesmanNo());
            salesmanDTO.setSalesmanName(salesman_MAster.getSalesmanName());
            salesmanDTO.setAddress1(salesman_MAster.getAddress1());
            salesmanDTO.setAddress2(salesman_MAster.getAddress2());
            salesmanDTO.setCity(salesman_MAster.getCity());
            salesmanDTO.setPincode(salesman_MAster.getPincode());
            salesmanDTO.setState(salesman_MAster.getState());
            salesmanDTO.setSaleAmount(salesman_MAster.getSaleAmount());
            salesmanDTO.setTgtToGet(salesman_MAster.getTgtToGet());
            salesmanDTO.setYtdSales(salesman_MAster.getYtdSales());
            salesmanDTO.setRemarks(salesman_MAster.getRemarks());

        return salesmanDTO;

    }

    public SalesmanDTO updateSalesmanById(SalesmanDTO salesmanDTO){

        Salesman_MAster salesman_MAster=new Salesman_MAster();

        salesman_MAster.setSalesmanNo(salesmanDTO.getSalesmanNo());
        salesman_MAster.setSalesmanName(salesmanDTO.getSalesmanName());
        salesman_MAster.setAddress1(salesmanDTO.getAddress1());
        salesman_MAster.setAddress2(salesmanDTO.getAddress2());
        salesman_MAster.setCity(salesmanDTO.getCity());
        salesman_MAster.setPincode(salesmanDTO.getPincode());
        salesman_MAster.setState(salesmanDTO.getState());
        salesman_MAster.setSaleAmount(salesmanDTO.getSaleAmount());
        salesman_MAster.setTgtToGet(salesmanDTO.getTgtToGet());
        salesman_MAster.setYtdSales(salesmanDTO.getYtdSales());
        salesman_MAster.setRemarks(salesmanDTO.getRemarks());

        salesmanMasterRepository.save(salesman_MAster);

        return salesmanDTO;
    }    

    public void deleteSalesmanDataById(String id){
        salesmanMasterRepository.deleteById(id);
    }
    
}
