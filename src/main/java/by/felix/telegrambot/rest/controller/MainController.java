package by.felix.telegrambot.rest.controller;

import by.felix.telegrambot.database.entity.City;
import by.felix.telegrambot.database.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class MainController {

    @Autowired
    private CityService cityService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printDB(Model model){
        Collection<City> cities = cityService.getAll();
        model.addAttribute("cities", cities);
        return "list";
    }
    @RequestMapping("/add")
    public String construct(Model model){
        model.addAttribute("city",new City());

        return "addcity";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCity(@ModelAttribute City city, Model model){
        cityService.addCity(city);


        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public String editConstruct(@PathVariable long id, Model model){
    model.addAttribute("city", cityService.getById(id));

    return "editCity";
    }

    public String editCity(@PathVariable long id,@ModelAttribute City city, Model model){
        cityService.editCity(city);

        return "redirect:/";
    }

}
