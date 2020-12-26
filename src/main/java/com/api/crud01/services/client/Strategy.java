package com.api.crud01.services.client;

import com.api.crud01.entities.client.Builder;
import com.api.crud01.entities.client.Client;

public interface Strategy {
    Client saveClient(Client client);
}
