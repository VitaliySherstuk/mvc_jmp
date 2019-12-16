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

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public String setNewCost() {
        return "settings";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String setNewCost(@PathVariable(value="id") String id, Model model) {

        List<Car> cars = carService.findCarById(Integer.valueOf(id));
        model.addAttribute("cars", cars);
        return "settings";
    }

    @RequestMapping(value = "/{id}/cost", method = RequestMethod.POST)
    public String setNewCost(@PathVariable(value="id") String id,
                             @RequestParam(value="cost") String cost,
                             Model model) {

        Car car = carService.update(Integer.valueOf(id), Integer.valueOf(cost));
        model.addAttribute("cars", Arrays.asList(car));
        return "settings";
    }
}
