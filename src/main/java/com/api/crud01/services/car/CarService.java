package com.api.crud01.services.car;

import com.api.crud01.consts.CarConsts;
import com.api.crud01.entities.car.Car;
import com.api.crud01.entities.client.Client;
import com.api.crud01.exceptions.NotFoundException;
import com.api.crud01.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CarService extends CarFacade {
    @Autowired
    CarRepository repository;

    @Autowired
    Environment environment;

    public Car insertNewCar(Car car, String type) throws Exception {

        Strategy strategy;

        strategy = (Strategy) Class.forName(environment.getProperty("car.package.path") + type).newInstance();

        try {
            return repository.save(strategy.saveCar(car));
        } catch (Exception e) {
            throw new Exception(CarConsts.SOMETHING_WENT_WRONG + e.getMessage());
        }
    }

    public Car reserveCar(long carId, String type, String to) throws Exception {
        if (carIdIsEmpty(carId)) {
            throw new NotFoundException(CarConsts.CAR_NOT_FOUND);
        }

        Car car;

        try {
            car = repository.getOne(carId);
        } catch (Exception e)
        {
            throw new Exception(CarConsts.SOMETHING_WENT_WRONG + e.getMessage());
        }

        if (carIsNull(car)) {
            throw new NotFoundException(CarConsts.CAR_NOT_FOUND);
        }

        Strategy strategy;

        strategy = (Strategy) Class.forName(environment.getProperty("car.package.path") + type).newInstance();

        strategy.next(car, to);

        return car;
    }


}
