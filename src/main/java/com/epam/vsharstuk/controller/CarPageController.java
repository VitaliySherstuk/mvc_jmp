package com.epam.vsharstuk.controller;

import com.epam.vsharstuk.model.Car;
import com.epam.vsharstuk.service.CarService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarPageController {

    @Autowired
    private CarService carService;

    private Logger LOG = Logger.getLogger(CarPageController.class);

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

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        LOG.warn(e);
    }
}
