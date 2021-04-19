package com.bussiness.marketingDept.controller;

import java.util.List;

import com.bussiness.marketingDept.dto.ClientDTO;
import com.bussiness.marketingDept.errorHandler.RequestErrorHandler;
import com.bussiness.marketingDept.model.ClientMaster;
import com.bussiness.marketingDept.service.ClientMasterService;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientMasterService clientMasterService;

    @PostMapping(value = "/create",produces = "application/json")
    @ResponseBody()
    public RequestErrorHandler saveData(@RequestBody ClientDTO clientDTO){
       return clientMasterService.saveData(clientDTO);
    }

    @GetMapping("/retrive")
    public List<ClientDTO> getAllCleint(){
        return clientMasterService.getAllData();
    }

    @GetMapping("/retrivebyid/{id}")
    public ClientDTO getById(@PathVariable String id){
        return clientMasterService.getClientById(id);
    }


    @PutMapping("/updateclient/{id}")
    public ClientDTO updateClient(@PathVariable String id,@RequestBody ClientDTO clientDTO){
        return clientMasterService.updateClient(clientDTO);    
    }

    @DeleteMapping("removeclientbyid/{id}")
    public void deleteClientDataById(@PathVariable String id)
    {
        clientMasterService.deleteClientDataById(id);
    }
    
}

