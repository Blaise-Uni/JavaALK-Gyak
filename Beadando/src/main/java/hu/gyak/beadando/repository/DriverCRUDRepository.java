package hu.gyak.beadando.repository;

import hu.gyak.beadando.entity.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverCRUDRepository extends CrudRepository<Driver, Long> {
}
