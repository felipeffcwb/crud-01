package com.api.crud01.entities.client;

import com.api.crud01.entities.car.Car;
import com.api.crud01.enums.ClientStatus;
import com.api.crud01.enums.ClientType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(	name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String document;
    private String email;
    private ClientStatus status;
    private ClientType type;
    @OneToMany(mappedBy = "client")
    private List<Car> cars = new ArrayList<Car>();

    public Client(long id, String name, String document, String email, ClientStatus status, ClientType type, List<Car> cars) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
        this.status = status;
        this.type = type;
        this.cars = cars;
    }

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
