package com.api.crud01.entities.car;

import com.api.crud01.consts.CarConsts;
import com.api.crud01.enums.StatesEnum;

public class AvailableState extends State{

    public AvailableState(Car car) {
        super(car);
    }

    @Override
    public StatesEnum next() {
        car.setState(new ReservedState(car).getState());
        return car.getState();
    }

    @Override
    public StatesEnum prev() {
        return null;
    }

    @Override
    public StatesEnum getState() {
        return StatesEnum.AVAILABLE;
    }
}
