package com.epam.vsharstuk.controller;

import com.epam.vsharstuk.model.Car;
import com.epam.vsharstuk.model.User;
import com.epam.vsharstuk.service.CarService;
import com.epam.vsharstuk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/orders")
public class OrderPageController {

    @Autowired
    private CarService carService;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getOrderPage() {
        return "orders";
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public String getCarCard(@PathVariable(value="id") String id, Model model) {
        Car car = carService.findCarById(Integer.valueOf(id)).get(0);
        User user = userService.findUserById(car.getUserId()).get(0);
        model.addAttribute("car", car);
        model.addAttribute("user", user);
        return "orders";
    }
}
