package com.api.crud01.repositories;

import com.api.crud01.entities.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car, Long>{
    @Query(
            value = "SELECT * FROM cars c WHERE c.id = ?1",
            nativeQuery = true)
    Car findCarById(long id);
}
