package com.app.web;

import com.app.model.dto.CarDto;
import com.app.model.entity.CarEntity;
import com.app.service.CarServiceImpl;
import com.app.service.api.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarWeb {
    private CarService carService;

    @GetMapping("/get-car-by-id/{id}")
    public CarEntity findCarById(@PathVariable long id) {
        return carService.findCarById(id);
    }

    @PostMapping("/save-car")
    public void addCar(@RequestBody CarDto carDto) {
        carService.addCar(carDto);
    }

    @GetMapping("/find-all-cars")
    public List<CarEntity> findAllCars() {
        return carService.findAllCars();
    }

    @DeleteMapping("/delete-car")
    public void deleteCar(@RequestBody CarDto CarDto) {
        carService.deleteCar( CarDto);
    }


    @Autowired
    public void setCarService(CarServiceImpl carService) {
        this.carService = carService;
    }
}
