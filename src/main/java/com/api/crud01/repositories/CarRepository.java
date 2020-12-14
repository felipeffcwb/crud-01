package com.api.crud01.repositories;

import com.api.crud01.entities.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long>{
}
