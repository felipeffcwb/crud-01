package com.api.crud01.entities.client;

import com.api.crud01.entities.car.Car;
import com.api.crud01.enums.ClientStatus;
import com.api.crud01.enums.ClientType;

import java.util.List;

public interface Builder {
    void setClientType(ClientType type);
    void setName(String name);
    void setDocument(String document);
    void setEmail(String email);
    void setStatus(ClientStatus status);
    void setCars(List<Car> cars);
    Client getResult();
}
