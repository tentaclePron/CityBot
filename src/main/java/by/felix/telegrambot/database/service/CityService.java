package by.felix.telegrambot.database.service;

import by.felix.telegrambot.database.entity.City;

import java.util.List;

public interface CityService {

    City addCity(City city);
    void delete(long id);
    City getByName(String name);
    City editCity(City city);
    List<City> getAll();

}
