package com.api.crud01.entities.client;

import com.api.crud01.enums.ClientStatus;
import com.api.crud01.enums.ClientType;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Director {
    public Client constructCompanyClient(Builder builder) {
        builder.setName(builder.getResult().getName());
        builder.setDocument(builder.getResult().getDocument());
        builder.setEmail(builder.getResult().getEmail());
        builder.setStatus(ClientStatus.ACTIVE);
        builder.setClientType(ClientType.COMPANY);
        builder.setCars(builder.getResult().getCars());

        return builder.getResult();
    }

    public Client constructPeopleClient(Builder builder) {
        builder.setName(builder.getResult().getName());
        builder.setDocument(builder.getResult().getDocument());
        builder.setEmail(builder.getResult().getEmail());
        builder.setStatus(ClientStatus.ACTIVE);
        builder.setClientType(ClientType.PEOPLE);
        builder.setCars(builder.getResult().getCars());

        return builder.getResult();
    }
}
