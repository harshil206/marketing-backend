package com.bussiness.marketingDept.service;


import java.util.ArrayList;
import java.util.List;

import com.bussiness.marketingDept.DTO.ClientDTO;
import com.bussiness.marketingDept.model.ClientMaster;
import com.bussiness.marketingDept.repository.ClientMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientMasterService {

    @Autowired
    private ClientMasterRepository clientMasterRepository;

    public void saveData(ClientDTO clientDTO){
        ClientMaster client_master=new ClientMaster();
        System.out.println("Clients*****"+client_master);
        client_master.setName(clientDTO.getName());
        client_master.setClientNo(clientDTO.getClientNo());
        client_master.setAddress1(clientDTO.getAddress1());
        client_master.setAddress2(clientDTO.getAddress2());
        client_master.setPincode(clientDTO.getPincode());
        client_master.setBalanceDue(clientDTO.getBalanceDue());
        client_master.setCity(clientDTO.getCity());
        client_master.setState(clientDTO.getState());

        System.out.println("Clients*****"+client_master);
        clientMasterRepository.save(client_master);
    }

    public List<ClientDTO> getAllData() {
        List<ClientDTO> clientDTOList=new ArrayList<>();
        List<ClientMaster> client_masterList=new ArrayList<>();
        clientMasterRepository.findAll().forEach(client->client_masterList.add(client));
        for(ClientMaster client_master:client_masterList){
            ClientDTO client=new ClientDTO();
            client.setName(client_master.getName());
            client.setClientNo(client_master.getClientNo());
            client.setCity(client_master.getCity());
            client.setAddress1(client_master.getAddress1());
            client.setAddress2(client_master.getAddress2());
            client.setBalanceDue(client_master.getBalanceDue());
            client.setPincode(client_master.getPincode());
            client.setState(client_master.getState());
            clientDTOList.add(client);
        }

        return clientDTOList;

    }

    public ClientDTO getClientById(String id) {
        ClientDTO clientDTO=new ClientDTO();
        ClientMaster client_master=clientMasterRepository.findById(id).get();
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

    public ClientDTO updateClient(ClientDTO clientDTO) {
        ClientMaster client_master=new ClientMaster();
        System.out.println("Clients*****"+client_master);
        client_master.setName(clientDTO.getName());
        client_master.setClientNo(clientDTO.getClientNo());
        client_master.setAddress1(clientDTO.getAddress1());
        client_master.setAddress2(clientDTO.getAddress2());
        client_master.setPincode(clientDTO.getPincode());
        client_master.setBalanceDue(clientDTO.getBalanceDue());
        client_master.setCity(clientDTO.getCity());
        client_master.setState(clientDTO.getState());

        System.out.println("Clients*****"+client_master);
        clientMasterRepository.save(client_master);
        
        return clientDTO;
    }

    public void deleteClientDataById(String id){
        clientMasterRepository.deleteById(id);
    }

}
