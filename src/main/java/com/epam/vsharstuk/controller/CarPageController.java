package com.epam.vsharstuk.controller;

import com.epam.vsharstuk.model.Car;
import com.epam.vsharstuk.model.User;
import com.epam.vsharstuk.service.CarSearchCriteria;
import com.epam.vsharstuk.service.CarService;
import com.epam.vsharstuk.service.UserService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
    public String findCarsByMake(@RequestParam(value="make") String make,
                                 @RequestParam(value="model") String model,
                                 @RequestParam(value="year") String year,
                                 @RequestParam(value="cost") String cost,
                                 @RequestParam(value ="order", required = false) String order, Model m) {
        CarSearchCriteria criteria = new CarSearchCriteria();
        criteria.setMake(make);
        criteria.setModel(model);

        if (StringUtils.isNoneBlank(year)) {
            criteria.setYear(Integer.valueOf(year));
        }

        if (StringUtils.isNoneBlank(cost)) {
            criteria.setCost(Integer.valueOf(cost));
        }

        List<Car> cars = carService.findCarByCriteria(criteria, order);
        if(cars != null)
        {
            m.addAttribute("cars", cars);
            m.addAttribute("isVisible", true);
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
