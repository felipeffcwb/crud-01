package com.api.crud01.services.client;

import com.api.crud01.consts.ClientConsts;
import com.api.crud01.entities.client.Builder;
import com.api.crud01.entities.client.Client;
import com.api.crud01.entities.client.ClientBuilder;
import com.api.crud01.entities.client.DirectorClient;
import com.api.crud01.exceptions.BadRequestException;
import com.api.crud01.repositories.ClientRepository;
import com.api.crud01.utils.DocumentMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends ClientFacade {
    @Autowired
    private ClientRepository repository;

    @Autowired
    private Environment environment;

    public Client insertNewPeopleClient(Client client, String type) throws Exception {
        if (clientIsEmptyOrNull(client)) {
            throw new BadRequestException(ClientConsts.CLIENT_IS_EMPTY);
        }

        String docValidator = isDocumentOk(client.getDocument());

        if (!docValidator.equals(DocumentMessages.OK)) {
            throw new BadRequestException(docValidator);
        }

        Strategy strategy;

        try {
            strategy = (Strategy) Class.forName(environment.getProperty("client.package.path") + type).newInstance();
            repository.save(strategy.saveClient(client));
        } catch (Exception e) {
            throw new Exception(ClientConsts.SOMETHING_WENT_WRONG + e.getMessage());
        }

        return client;
    }

}
