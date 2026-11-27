package hu.gyak.beadando.repository;

import hu.gyak.beadando.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
