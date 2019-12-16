package com.epam.vsharstuk.controller;

import com.epam.vsharstuk.model.Car;
import com.epam.vsharstuk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        List<Car> cars = carService.findCarByMake(make);
        if(cars != null)
        {
            model.addAttribute("cars", cars);
            model.addAttribute("isVisible", true);
        }
        return "cars";
    }

    @RequestMapping(value = "/removed/{id}", method = RequestMethod.GET)
    public String findCarsByMake(@PathVariable(value="id") String id) {
        carService.delete(Integer.valueOf(id));
        return "cars";
    }

}
