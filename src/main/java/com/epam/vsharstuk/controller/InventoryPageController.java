package com.epam.vsharstuk.controller;

import com.epam.vsharstuk.model.Car;
import com.epam.vsharstuk.service.CarService;
import com.epam.vsharstuk.service.UserService;
import com.epam.vsharstuk.service.impl.UserDetailsServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/inventory")
public class InventoryPageController {

    @Autowired
    private CarService carService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getInventoryPage(Model model) {
        String name = userDetailsService.getUserDetails().getUsername();
        Integer userId =userService.findUserByName(name).get(0).getId();
        List<Car> cars = carService.findCarByUserId(userId);

        if (CollectionUtils.isNotEmpty(cars)) {
            model.addAttribute("isVisible", true);
            model.addAttribute("cars", cars);
        }
        return "inventory";
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public String addCar(@RequestParam(value = "make") String make,
                         @RequestParam(value = "model") String model,
                         @RequestParam(value = "year") String year,
                         @RequestParam(value = "cost") String cost) {

        String username = userDetailsService.getUserDetails().getUsername();
        Integer userId = userService.findUserByName(username).get(0).getId();
        carService.addCar(make, model, year, cost, userId);
        return "redirect:/inventory";
    }
}
