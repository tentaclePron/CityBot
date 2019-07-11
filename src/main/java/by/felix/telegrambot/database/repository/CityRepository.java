package by.felix.telegrambot.database.repository;

import by.felix.telegrambot.database.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "select c from City c where c.name = :name")
    Optional<City> findByName(@Param("name") String name);
}
