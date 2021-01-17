package com.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.dto.CarDto;
import com.app.service.CarServiceImpl;
import com.app.service.api.CarService;

@RestController
@RequestMapping("/car")
public class CarWeb {
    private CarService carService;

    @GetMapping("/get-car-by-id/{id}")
    public CarDto findCarById(@PathVariable long id) {
        return carService.findCarById(id);
    }

    @PostMapping("/save-car")
    public void addCar(@RequestBody CarDto carDto) {
        carService.addCar(carDto);
    }

    @GetMapping("/find-all-car")
    public List<CarDto> findAllCars() {
        return carService.findAllCars();
    }

    @GetMapping("/find-cars-equal-status/{id}")
    public List<CarDto> findCarsEqualStatus(@PathVariable long id) {
        return carService.findCarsEqualStatus(id);
    }

    @DeleteMapping("/delete-car")
    public void deleteCar(@RequestBody CarDto CarDto) {
        carService.deleteCar( CarDto);
    }

    @DeleteMapping("/delete-car-by-id/{id}")
    public void deleteCar(@PathVariable long id) {
        carService.deleteCarById(id);
    }

    @GetMapping("/get-car-by-number/{number}")
    public CarDto getCarByNumber(@PathVariable String number){
        return carService.getCarByNumber(number);
    }


    @Autowired
    public void setCarService(CarServiceImpl carService) {
        this.carService = carService;
    }
}
