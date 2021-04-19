package com.bussiness.marketingDept.service;

import java.util.ArrayList;
import java.util.List;

import com.bussiness.marketingDept.dto.SaleOrderDTO;
import com.bussiness.marketingDept.errorHandler.RequestErrorHandler;
import com.bussiness.marketingDept.model.SaleOrder;
import com.bussiness.marketingDept.repository.SaleOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleOrderService {

    @Autowired
    private SaleOrderRepository saleOrderRepository;

    public RequestErrorHandler saveData(SaleOrderDTO saleOrderDTO){

        SaleOrder sale_Order=new SaleOrder();
        RequestErrorHandler requestErrorHandler=new RequestErrorHandler();

        sale_Order=SaleOrderDTOtoSaleOrder(sale_Order,saleOrderDTO);
        try{
            saleOrderRepository.save(sale_Order);
        }catch (Exception e) {
            requestErrorHandler.setMessage("Some data is left or attribute is left out...");
            requestErrorHandler.setStatus("500");
            requestErrorHandler.setId(saleOrderDTO.getOrderNo());
            return requestErrorHandler;
        }
        return requestErrorHandler;


    }

    public List<SaleOrderDTO> getAllSalesOrder(){
        List<SaleOrderDTO> saleOrderDTOList=new ArrayList<>();
        List<SaleOrder> saleOrderList=new ArrayList<>();
        saleOrderRepository.findAll().forEach(saleOrder->saleOrderList.add(saleOrder));

        for(SaleOrder sale_Order:saleOrderList){
            SaleOrderDTO saleOrderDTO=new SaleOrderDTO();
            saleOrderDTO=saleOrdertSaleOderDTO(sale_Order,saleOrderDTO);
            saleOrderDTOList.add(saleOrderDTO); 
        }

        return saleOrderDTOList;
    }

    public SaleOrderDTO getSaleOrderById(String id){

        SaleOrderDTO saleOrderDTO=new SaleOrderDTO();
        SaleOrder sale_Order=saleOrderRepository.findById(id).get();
        saleOrderDTO=saleOrdertSaleOderDTO(sale_Order,saleOrderDTO);
        return saleOrderDTO;

    }

    public SaleOrderDTO updateSalesmanById(SaleOrderDTO saleOrderDTO){
        SaleOrder sale_Order=new SaleOrder();
        sale_Order=SaleOrderDTOtoSaleOrder(sale_Order,saleOrderDTO);
        saleOrderRepository.save(sale_Order);
        return saleOrderDTO;
    }    

    public void deleteSaleOrderDataById(String id){
        saleOrderRepository.deleteById(id);
    }


    private SaleOrder SaleOrderDTOtoSaleOrder(SaleOrder sale_Order,SaleOrderDTO saleOrderDTO){
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
        return sale_Order;
    }

    private SaleOrderDTO saleOrdertSaleOderDTO(SaleOrder sale_Order,SaleOrderDTO saleOrderDTO){
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
    
}
