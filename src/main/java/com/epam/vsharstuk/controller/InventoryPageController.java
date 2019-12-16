package com.epam.vsharstuk.controller;

import com.epam.vsharstuk.model.Car;
import com.epam.vsharstuk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/inventory")
public class InventoryPageController {

    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public String getInventoryPage() {
        return "inventory";
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public String addCar(@RequestParam(value = "make") String make,
                         @RequestParam(value = "model") String model,
                         @RequestParam(value = "year") String year,
                         @RequestParam(value = "cost") String cost) {

        Car car = new Car();
        car.setMake(make);
        car.setModel(model);
        car.setYear(Integer.valueOf(year));
        car.setCost(Integer.valueOf(cost));
        carService.addCar(car);
        return "inventory";
    }
}
