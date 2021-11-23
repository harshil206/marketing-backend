package com.bussiness.marketingDept.service;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.bussiness.marketingDept.dto.ClientDTO;
import com.bussiness.marketingDept.errorHandler.RequestErrorHandler;
import com.bussiness.marketingDept.model.ClientMaster;
import com.bussiness.marketingDept.repository.ClientMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientMasterService {

    @Autowired
    private ClientMasterRepository clientMasterRepository;

    public RequestErrorHandler saveData(ClientDTO clientDTO){
        RequestErrorHandler requestErrorHandler=new RequestErrorHandler();
        ClientMaster client_master=new ClientMaster();
        client_master=clientDTOtoclientMaster(client_master,clientDTO);

        try{
            clientMasterRepository.save(client_master);
        }catch (Exception e){
            requestErrorHandler.setMessage("Some data is left or attribute is left out...");
            requestErrorHandler.setStatus("500");
            requestErrorHandler.setId(clientDTO.getClientNo());
            return requestErrorHandler;
        }
        return requestErrorHandler;
    }

    public List<ClientDTO> getAllData() {
        List<ClientDTO> clientDTOList=new ArrayList<>();
        List<ClientMaster> client_masterList=new ArrayList<>();
        clientMasterRepository.findAll().forEach(client->client_masterList.add(client));
        for(ClientMaster client_master:client_masterList){
            ClientDTO client=new ClientDTO();
            client=clientMastertoClientDTO(client_master,client);
            clientDTOList.add(client);
        }

        return clientDTOList;

    }

    public String getClientById(String id) {
        ClientDTO clientDTO=new ClientDTO();
        Optional<ClientMaster> client_master=clientMasterRepository.findById(id);
        if(client_master.isPresent()){
            clientDTO=clientMastertoClientDTO(client_master.get(),clientDTO);
            return clientDTO.toString();
        }
        else{
            RequestErrorHandler requestErrorHandler=new RequestErrorHandler();
            requestErrorHandler.setId(id);
            requestErrorHandler.setMessage("Error. No such id is present...");
            requestErrorHandler.setStatus("500");
            requestErrorHandler.setResult("Error!!!");
            return requestErrorHandler.toString();
        }
    }

    public ClientDTO updateClient(ClientDTO clientDTO) {
        ClientMaster client_master=new ClientMaster();
        System.out.println("Clients*****"+client_master);
        client_master=clientDTOtoclientMaster(client_master,clientDTO);
        System.out.println("Clients*****"+client_master);
        clientMasterRepository.save(client_master);
        
        return clientDTO;
    }

    public void deleteClientDataById(String id){
        clientMasterRepository.deleteById(id);
    }



    public ClientMaster clientDTOtoclientMaster(ClientMaster client_master,ClientDTO clientDTO){
        client_master.setName(clientDTO.getName());
        client_master.setClientNo(clientDTO.getClientNo());
        client_master.setAddress1(clientDTO.getAddress1());
        client_master.setAddress2(clientDTO.getAddress2());
        client_master.setPincode(clientDTO.getPincode());
        client_master.setBalanceDue(clientDTO.getBalanceDue());
        client_master.setCity(clientDTO.getCity());
        client_master.setState(clientDTO.getState());
        return client_master;
    }

    public ClientDTO clientMastertoClientDTO(ClientMaster client_master,ClientDTO clientDTO){
        clientDTO.setName(client_master.getName());
        clientDTO.setClientNo(client_master.getClientNo());
        clientDTO.setCity(client_master.getCity());
        clientDTO.setAddress1(client_master.getAddress1());
        clientDTO.setAddress2(client_master.getAddress2());
        clientDTO.setBalanceDue(client_master.getBalanceDue());
        clientDTO.setPincode(client_master.getPincode());
        clientDTO.setState(client_master.getState());
        return clientDTO;
    }

}
