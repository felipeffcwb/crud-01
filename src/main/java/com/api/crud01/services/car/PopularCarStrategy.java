package com.api.crud01.services.car;

import com.api.crud01.consts.CarConsts;
import com.api.crud01.entities.car.Builder;
import com.api.crud01.entities.car.Car;
import com.api.crud01.entities.car.CarBuilder;
import com.api.crud01.entities.car.DirectorCar;
import com.api.crud01.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopularCarStrategy implements Strategy{

    @Override
    public Car saveCar(Car car) throws Exception {
        Builder builder = new CarBuilder(car.getName(), car.getMark(), car.getDoors(), car.getMotor(), car.getType(), car.getClient());

        DirectorCar director = new DirectorCar();

        car = director.constructPopularCar(builder);

        return car;
    }
}
