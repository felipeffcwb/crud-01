package com.api.crud01.entities.car;

import com.api.crud01.entities.client.Client;
import com.api.crud01.enums.CarType;
import com.api.crud01.enums.StatesEnum;

import javax.persistence.*;

@Entity
@Table(	name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String mark;
    private int doors;
    private int motor;
    private CarType type;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private StatesEnum state;

    public Car() {
    }

    public Car(String name, String mark, int doors, int motor, CarType type, Client client, StatesEnum state) {
        this.name = name;
        this.mark = mark;
        this.doors = doors;
        this.motor = motor;
        this.type = type;
        this.client = client;
        this.state = state;
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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getMotor() {
        return motor;
    }

    public void setMotor(int motor) {
        this.motor = motor;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public StatesEnum getState() {
        return state;
    }

    public void setState(StatesEnum state) {
        this.state = state;
    }
}
