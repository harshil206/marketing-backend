package com.bussiness.marketingDept.service;

import java.util.ArrayList;
import java.util.List;

import com.bussiness.marketingDept.DTO.SaleOrderDTO;
import com.bussiness.marketingDept.model.Sale_Order;
import com.bussiness.marketingDept.repository.SaleOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleOrderService {

    @Autowired
    private SaleOrderRepository saleOrderRepository;

    public void saveData(SaleOrderDTO saleOrderDTO){

        Sale_Order sale_Order=new Sale_Order();
        
        sale_Order.setOrderNo(saleOrderDTO.getOrderNo());
        sale_Order.setClientNo(saleOrderDTO.getClientNo());
        sale_Order.setBilledYn(saleOrderDTO.getBilledYn());
        sale_Order.setDelyAddr(saleOrderDTO.getDelyAddr());
        sale_Order.setDelyDate(saleOrderDTO.getDelyDate());
        sale_Order.setDelyType(saleOrderDTO.getDelyType());
        sale_Order.setOrderDate(saleOrderDTO.getOrderDate());
        sale_Order.setOrderStatus(saleOrderDTO.getOrderStatus());
        sale_Order.setSalesmanNo(saleOrderDTO.getSalesmanNo());
        sale_Order.setOrderquantity(saleOrderDTO.getOrderquantity());

        saleOrderRepository.save(sale_Order);
    }

    public List<SaleOrderDTO> getAllSalesOrder(){
        List<SaleOrderDTO> saleOrderDTOList=new ArrayList<>();
        List<Sale_Order> saleOrderList=new ArrayList<>();
        saleOrderRepository.findAll().forEach(saleOrder->saleOrderList.add(saleOrder));

        for(Sale_Order sale_Order:saleOrderList){
            SaleOrderDTO saleOrderDTO=new SaleOrderDTO();
            saleOrderDTO.setOrderNo(sale_Order.getOrderNo());
            saleOrderDTO.setClientNo(sale_Order.getClientNo());
            saleOrderDTO.setBilledYn(sale_Order.getBilledYn());
            saleOrderDTO.setDelyAddr(sale_Order.getDelyAddr());
            saleOrderDTO.setDelyDate(sale_Order.getDelyDate());
            saleOrderDTO.setDelyType(sale_Order.getDelyType());
            saleOrderDTO.setOrderDate(sale_Order.getOrderDate());
            saleOrderDTO.setOrderStatus(sale_Order.getOrderStatus());
            saleOrderDTO.setSalesmanNo(sale_Order.getSalesmanNo());
            saleOrderDTO.setOrderquantity(sale_Order.getOrderquantity());
            saleOrderDTOList.add(saleOrderDTO); 
        }

        return saleOrderDTOList;
    }

    public SaleOrderDTO getSaleOrderById(String id){

        SaleOrderDTO saleOrderDTO=new SaleOrderDTO();
        Sale_Order sale_Order=saleOrderRepository.findById(id).get();
        saleOrderDTO.setOrderNo(sale_Order.getOrderNo());
        saleOrderDTO.setClientNo(sale_Order.getClientNo());
        saleOrderDTO.setBilledYn(sale_Order.getBilledYn());
        saleOrderDTO.setDelyAddr(sale_Order.getDelyAddr());
        saleOrderDTO.setDelyDate(sale_Order.getDelyDate());
        saleOrderDTO.setDelyType(sale_Order.getDelyType());
        saleOrderDTO.setOrderDate(sale_Order.getOrderDate());
        saleOrderDTO.setOrderStatus(sale_Order.getOrderStatus());
        saleOrderDTO.setSalesmanNo(sale_Order.getSalesmanNo());
        saleOrderDTO.setOrderquantity(sale_Order.getOrderquantity());

        return saleOrderDTO;

    }

    public SaleOrderDTO updateSalesmanById(SaleOrderDTO saleOrderDTO){
        Sale_Order sale_Order=new Sale_Order();
        
        sale_Order.setOrderNo(saleOrderDTO.getOrderNo());
        sale_Order.setClientNo(saleOrderDTO.getClientNo());
        sale_Order.setBilledYn(saleOrderDTO.getBilledYn());
        sale_Order.setDelyAddr(saleOrderDTO.getDelyAddr());
        sale_Order.setDelyDate(saleOrderDTO.getDelyDate());
        sale_Order.setDelyType(saleOrderDTO.getDelyType());
        sale_Order.setOrderDate(saleOrderDTO.getOrderDate());
        sale_Order.setOrderStatus(saleOrderDTO.getOrderStatus());
        sale_Order.setSalesmanNo(saleOrderDTO.getSalesmanNo());
        sale_Order.setOrderquantity(saleOrderDTO.getOrderquantity());

        saleOrderRepository.save(sale_Order);
        return saleOrderDTO;
    }    

    public void deleteSaleOrderDataById(String id){
        saleOrderRepository.deleteById(id);
    }
    
    
}
