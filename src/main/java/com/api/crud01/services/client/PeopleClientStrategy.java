package com.api.crud01.services.client;

import com.api.crud01.entities.client.Builder;
import com.api.crud01.entities.client.Client;
import com.api.crud01.entities.client.ClientBuilder;
import com.api.crud01.entities.client.DirectorClient;

public class PeopleClientStrategy implements Strategy {
    @Override
    public Client saveClient(Client client) {
        Builder builder = new ClientBuilder(client.getId(), client.getName(), client.getDocument(), client.getEmail(), client.getCars());

        DirectorClient directorClient = new DirectorClient();
        client = directorClient.constructPeopleClient(builder);

        return client;
    }
}
