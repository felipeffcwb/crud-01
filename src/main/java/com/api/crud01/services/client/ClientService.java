package com.api.crud01.services.client;

import com.api.crud01.entities.client.Builder;
import com.api.crud01.entities.client.Client;
import com.api.crud01.entities.client.ClientBuilder;
import com.api.crud01.entities.client.Director;
import com.api.crud01.exceptions.BadRequestException;
import com.api.crud01.repositories.ClientRepository;
import com.api.crud01.utils.DocumentMessages;
import com.api.crud01.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends ClientFacade {
    @Autowired
    private ClientRepository repository;

    @Autowired
    private Director director;

    public Client insertNewPeopleClient(Client client) throws Exception {
        if (clientIsEmptyOrNull(client)) {
            throw new BadRequestException("CLIENT_IS_EMPTY");
        }

        String docValidator = isDocumentOk(client.getDocument());

        if (docValidator.equals(DocumentMessages.OK)) {
            throw new BadRequestException(docValidator);
        }

        try {
            Builder builder = new ClientBuilder(client.getName(), client.getDocument(), client.getEmail(), client.getCars());
            repository.save(director.constructPeopleClient(builder));
        } catch (Exception e) {
            throw new Exception("SOMETHING_WENT_WRONG: " + e.getMessage());
        }

        return client;
    }

}
