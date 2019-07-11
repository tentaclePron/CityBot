package by.felix.telegrambot.rest.controller;

import by.felix.telegrambot.database.entity.City;
import by.felix.telegrambot.database.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private CityService cityService;


    @GetMapping("/cities")
    List<City> all() {
        return cityService.getAll();
    }

    @PostMapping("/cities")
    City newCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    @GetMapping("/cities/{id}")
    City one(@PathVariable Long id) {

        return cityService.getById(id);
    }

    @PutMapping("/cities/{id}")
    City replaceCity(@RequestBody City newCity, @PathVariable Long id) {
        City city = cityService.getById(id);
        city.setName(newCity.getName());
        city.setText(newCity.getText());

        return cityService.editCity(city);
    }

    @DeleteMapping("/cities/{id}")
    void deleteCity(@PathVariable Long id) {
        cityService.delete(id);
    }
}
