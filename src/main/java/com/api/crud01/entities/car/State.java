package com.api.crud01.entities.car;

import com.api.crud01.enums.StatesEnum;

public abstract class State {
    Car car;
    State(Car car) {
        this.car = car;
    }
    public abstract StatesEnum next();
    public abstract StatesEnum prev();
    public abstract StatesEnum getState();
}
