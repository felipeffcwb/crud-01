package com.api.crud01.entities.car;

import com.api.crud01.enums.StatesEnum;

public class ReturnedState extends State {
    ReturnedState(Car car) {
        super(car);
    }

    @Override
    public StatesEnum next() {
        return null;
    }

    @Override
    public StatesEnum prev() {
        car.setState(new PayedState(car).getState());
        return car.getState();
    }

    @Override
    public StatesEnum getState() {
        return StatesEnum.RETURNED;
    }
}
