package com.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.dto.ClientDto;
import com.app.service.api.ClientService;

@RestController
@RequestMapping("/client")
public class ClientWeb {
    private ClientService clientService;

    @GetMapping("/get-client-by-id/{id}")
    public ClientDto findClientById(@PathVariable long id) {
        return clientService.findClientById(id);
    }

    @PostMapping("/save-client")
    public void addClient(@RequestBody ClientDto clientDto) {
        clientService.addClient(clientDto);
    }

    @GetMapping("/find-all-client")
    public List<ClientDto> findAllClients() {
        return clientService.findAllClient();
    }

    @DeleteMapping("/delete-client")
    public void deleteClient(@RequestBody ClientDto ClientDto) {
        clientService.deleteClient(ClientDto);
    }

    @DeleteMapping("/delete-client-by-id/{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.deleteClientById(id);
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}
