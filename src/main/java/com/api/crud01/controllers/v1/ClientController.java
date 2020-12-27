package com.api.crud01.controllers.v1;

import com.api.crud01.entities.client.Client;
import com.api.crud01.enums.ClientType;
import com.api.crud01.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    private ClientService service;

    @RequestMapping(
            path = "/add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity insertNewClient(@RequestBody Client client, @RequestHeader ClientType type) throws Exception {
        return new ResponseEntity(service.insertNewClient(client, type), HttpStatus.CREATED);
    }
}
