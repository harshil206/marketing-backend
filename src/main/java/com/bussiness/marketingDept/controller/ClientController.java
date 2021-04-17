package com.bussiness.marketingDept.controller;

import java.util.List;

import com.bussiness.marketingDept.DTO.ClientDTO;
import com.bussiness.marketingDept.service.ClientMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientMasterService clientMasterService;

    @PostMapping("/create")
    public void saveData(@RequestBody ClientDTO clientDTO){
        System.out.println(clientDTO);
        clientMasterService.saveData(clientDTO);
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
