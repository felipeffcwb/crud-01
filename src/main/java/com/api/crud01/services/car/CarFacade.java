package com.api.crud01.services.car;

import com.api.crud01.entities.car.Car;
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
}
