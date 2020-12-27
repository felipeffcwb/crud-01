package com.api.crud01.services.car;

import com.api.crud01.consts.CarConsts;
import com.api.crud01.entities.car.*;
import com.api.crud01.enums.StatesEnum;
import org.springframework.stereotype.Component;

@Component
public class PopularCarStrategy extends CarFacade implements Strategy {

    @Override
    public Car saveCar(Car car) throws Exception {
        Builder builder = new CarBuilder(car.getName(), car.getMark(), car.getDoors(), car.getMotor(), car.getType(), car.getClient(), car.getState());

        DirectorCar director = new DirectorCar();

        car = director.constructPopularCar(builder);

        return car;
    }

    @Override
    public Car next(Car car, StatesEnum to) throws Exception {
        State state = verifyStateType(car, to);

        car.setState(state.next());

        return car;
    }

    @Override
    public Car prev(Car car, String to) throws Exception {
        State state = (State) Class.forName(CarConsts.CAR_ENTITY_PACKAGE_PATH + to).newInstance();

        car.setState(state.prev());

        return car;
    }
}
