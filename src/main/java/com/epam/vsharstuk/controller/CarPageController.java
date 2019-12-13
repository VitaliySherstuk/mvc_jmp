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
@RequestMapping("/cars")
public class CarPageController {

    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public String getCarPage() {
        return "cars";
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public String findCarsByMake(@RequestParam(value="make") String make, Model model) {
        Car car = carService.findCarByMake(make);
        if(car != null) {
            model.addAttribute("newCar", car);
        }

        return "cars";
    }


}
