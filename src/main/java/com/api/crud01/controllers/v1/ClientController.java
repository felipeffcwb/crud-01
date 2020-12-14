package com.api.crud01.controllers.v1;

import com.api.crud01.entities.client.Client;
import com.api.crud01.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(name = "/client")
public class ClientController {
    @Autowired
    private ClientService service;

    @RequestMapping(value = "/add-new-people", method = RequestMethod.POST)
    public ResponseEntity insertNewPeople(@RequestBody Client client) throws Exception {
        return new ResponseEntity(service.insertNewPeopleClient(client), HttpStatus.CREATED);
    }
}
