package com.example.carsbackend;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarCRUDController {

    @PostMapping(value = "car")
    public void create(@RequestBody Car car){
        CRUD.create(car);
    }

    @GetMapping(value = "car")
    public List<Car>  readAll(){
        List<Car> cars = CRUD.readAll();
        return cars;
    }

    @GetMapping(value = "car/{id}")
    public Car readById(@PathVariable int id){
        Car car = CRUD.readById(id);
        return car;
    }

    @PutMapping(value = "car/{id}")
    public Car update(@PathVariable int id, @RequestBody Car car){
        Car updatedCar = CRUD.update(id, car);
        return updatedCar;
    }

    @DeleteMapping(value = "car/{id}")
    public void delete(@PathVariable int id){
        CRUD.delete(id);
    }
}
