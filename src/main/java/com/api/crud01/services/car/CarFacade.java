package com.api.crud01.services.car;

import com.api.crud01.entities.car.AvailableState;
import com.api.crud01.entities.car.Car;
import com.api.crud01.entities.car.ReservedState;
import com.api.crud01.entities.car.State;
import com.api.crud01.enums.CarType;
import com.api.crud01.enums.StatesEnum;
import com.api.crud01.utils.Utils;

public class CarFacade implements Utils {
    @Override
    public String isDocumentOk(String document) {
        return null;
    }

    @Override
    public boolean stringIsNullOrEmpty(String param) {
        return null == param || param.isEmpty();
    }

    public boolean carIsNull(Car car) {
        return null == car;
    }

    public boolean carIdIsEmpty(long id) {
        return 0 == id;
    }

    public Strategy verifyCarType(CarType type) {
        Strategy strategy;
        switch (type) {
            case POPULAR:
                strategy = new PopularCarStrategy();
                return strategy;
            default:
                break;
        }
        return null;
    }

    public State verifyStateType(Car car, StatesEnum statesEnum) {
        State state;
        switch (statesEnum) {
            case AVAILABLE:
                state = new AvailableState(car);
                return state;
            default:
                break;
        }
        return null;
    }
}
