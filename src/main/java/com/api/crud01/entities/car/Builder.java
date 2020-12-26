package com.api.crud01.entities.car;

import com.api.crud01.entities.client.Client;
import com.api.crud01.enums.CarType;
import com.api.crud01.enums.StatesEnum;

public interface Builder {
    void setName(String name);
    void setMark(String mark);
    void setDoors(int doors);
    void setMotor(int motor);
    void setCarType(CarType carType);
    void setClient(Client client);
    void setState(StatesEnum state);
    Car build();
}
