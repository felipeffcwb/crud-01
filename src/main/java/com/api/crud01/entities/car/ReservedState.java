package com.api.crud01.entities.car;

import com.api.crud01.consts.CarConsts;
import com.api.crud01.enums.StatesEnum;

public class ReservedState extends State{

    ReservedState(Car car) {
        super(car);
    }

    @Override
    public StatesEnum next() {
        car.setState(new PayedState(car).getState());
        return car.getState();
    }

    @Override
    public StatesEnum prev() {
        car.setState(new AvailableState(car).getState());
        return car.getState();
    }

    @Override
    public StatesEnum getState() {
        return StatesEnum.RESERVED;
    }
}
