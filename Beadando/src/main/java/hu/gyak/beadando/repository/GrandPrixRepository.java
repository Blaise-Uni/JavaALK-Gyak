package hu.gyak.beadando.repository;

import hu.gyak.beadando.entity.GrandPrix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface GrandPrixRepository extends JpaRepository<GrandPrix, Date> {
}
