package by.felix.telegrambot.database.repository;

import by.felix.telegrambot.database.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query("select c from City c where c.name =:name")
    City findByName(@Param("name") String name);
}
