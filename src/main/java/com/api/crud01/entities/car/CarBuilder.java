package com.api.crud01.entities.car;

import com.api.crud01.entities.client.Client;
import com.api.crud01.enums.CarType;
import com.api.crud01.enums.StatesEnum;

public class CarBuilder implements Builder {
    private String name;
    private String mark;
    private int doors;
    private int motor;
    private CarType carType;
    private Client client;
    private StatesEnum state;


    public CarBuilder(String name, String mark, int doors, int motor, CarType carType, Client client, StatesEnum state) {
        this.name = name;
        this.mark = mark;
        this.doors = doors;
        this.motor = motor;
        this.carType = carType;
        this.client = client;
        this.state = state;
    }


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public void setMotor(int motor) {
        this.motor = motor;
    }

    @Override
    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void setState(StatesEnum state) {
        this.state = state;
    }

    @Override
    public Car build() {
        return new Car(this.name, this.mark, this.doors, this.motor, this.carType, this.client, this.state);
    }
}
