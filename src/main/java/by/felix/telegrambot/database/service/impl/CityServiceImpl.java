package by.felix.telegrambot.database.service.impl;

import by.felix.telegrambot.database.entity.City;
import by.felix.telegrambot.database.repository.CityRepository;
import by.felix.telegrambot.database.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository repository;

    @Override
    public City addCity(City city) {
        return repository.saveAndFlush(city);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public City getByName(String name) {
        return repository.findByName(name).orElse(new City());
    }

    public City getById(long id){
        return repository.findById(id).orElse(new City());
    }

    @Override
    public City editCity(City city) {
        return repository.saveAndFlush(city);
    }

    @Override
    public List<City> getAll() {
        return repository.findAll();
    }
}
