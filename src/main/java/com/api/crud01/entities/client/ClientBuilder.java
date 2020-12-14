package com.api.crud01.entities.client;

import com.api.crud01.entities.car.Car;
import com.api.crud01.enums.CarType;
import com.api.crud01.enums.ClientStatus;
import com.api.crud01.enums.ClientType;

import java.util.ArrayList;
import java.util.List;

public class ClientBuilder implements Builder {
    private ClientType type;
    private String name;
    private String document;
    private String email;
    private ClientStatus status;
    private List<Car> cars = new ArrayList<>();

    public ClientBuilder(String name, String document, String email, List<Car> cars) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.cars = cars;
    }

    @Override
    public void setClientType(ClientType type) {
        this.type = type;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setStatus(ClientStatus status) {
        this.status = status;
    }

    @Override
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public Client getResult(){
        return new Client(name, document, email, status, type, cars);
    }
}
