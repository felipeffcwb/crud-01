package com.api.crud01.services.car;

import com.api.crud01.entities.car.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PopularCarStrategy implements Strategy {

    @Autowired
    Environment environment;

    @Override
    public Car saveCar(Car car) throws Exception {
        Builder builder = new CarBuilder(car.getName(), car.getMark(), car.getDoors(), car.getMotor(), car.getType(), car.getClient(), car.getState());

        DirectorCar director = new DirectorCar();

        car = director.constructPopularCar(builder);

        return car;
    }

    @Override
    public Car next(Car car, String to) throws Exception {
        State state = (State) Class.forName(environment.getProperty("car.state.package.path") + to).newInstance();

        car.setState(state.next());

        return car;
    }

    @Override
    public Car prev(Car car, String to) throws Exception {
        State state = (State) Class.forName(environment.getProperty("car.state.package.path") + to).newInstance();

        car.setState(state.prev());

        return car;
    }
}
