package com.api.crud01.entities.car;

import com.api.crud01.enums.CarType;
import org.springframework.stereotype.Component;

@Component
public class DirectorCar {

    public Car constructPopularCar(Builder builder) {
        builder.setCarType(CarType.POPULAR);
        return builder.build();
    }
}
