package com.epam.vsharstuk.controller;

import com.epam.vsharstuk.model.Car;
import com.epam.vsharstuk.service.CarService;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    private CarService carService;

    private Logger LOG = Logger.getLogger(SettingsController.class);

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

    @RequestMapping(value = "/uploadImg/{id}", method = RequestMethod.POST)
    public String uploadImg(@RequestParam("file") MultipartFile file,
                            @PathVariable("id") String id, HttpSession session, Model model) {

        Car car = carService.findCarById(Integer.valueOf(id)).get(0);

        try {
            InputStream is = file.getInputStream();
            if (is != null) {
                byte[] content = IOUtils.toByteArray(is);
                String fileName =car.getMake() + "_" + car.getId() + ".png";
                String path = "D:/photo/";
                LOG.info("FILE was upload: " + path + fileName);
                FileOutputStream fos = new FileOutputStream(new File(path + fileName));
                OutputStream os = new BufferedOutputStream(fos);
                os.write(content);
                car.setImg(fileName);
                carService.update(car);
                LOG.info("Car was updated" + car);
                model.addAttribute("result", true);
            }
        } catch (IOException e) {
            LOG.warn(e);
        }

        return "settings";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        LOG.warn(e);
    }
}
