package com.api.crud01.controllers.v1;

import com.api.crud01.entities.car.Car;
import com.api.crud01.entities.client.Client;
import com.api.crud01.services.car.CarService;
import com.api.crud01.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/car")
public class CarController {
    @Autowired
    private CarService service;

    @RequestMapping(
            path = "/add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity insertNewCar(@RequestBody Car car, @RequestHeader String type) throws Exception {
        return new ResponseEntity(service.insertNewCar(car, type), HttpStatus.CREATED);
    }

    @RequestMapping(
            path = "/reserve",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity reserveCar(@RequestHeader long carId, @RequestHeader String type, @RequestHeader String to) throws Exception {
        return new ResponseEntity(service.reserveCar(carId, type, to), HttpStatus.CREATED);
    }
}
