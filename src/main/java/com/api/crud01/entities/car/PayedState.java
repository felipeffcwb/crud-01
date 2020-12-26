package com.api.crud01.entities.car;

import com.api.crud01.enums.StatesEnum;

public class PayedState extends State{

    PayedState(Car car) {
        super(car);
    }

    @Override
    public StatesEnum next() {
        car.setState(new ReturnedState(car).getState());
        return car.getState();
    }

    @Override
    public StatesEnum prev() {
        car.setState(new ReservedState(car).getState());
        return car.getState();
    }

    @Override
    public StatesEnum getState() {
        return StatesEnum.PAYED;
    }
}
