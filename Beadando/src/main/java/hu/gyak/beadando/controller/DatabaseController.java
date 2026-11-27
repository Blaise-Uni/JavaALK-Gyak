package hu.gyak.beadando.controller;

import hu.gyak.beadando.repository.DriverRepository;
import hu.gyak.beadando.repository.GrandPrixRepository;
import hu.gyak.beadando.repository.ResultRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatabaseController {
    private final DriverRepository driverRepository;
    private final GrandPrixRepository grandPrixRepository;
    private final ResultRepository resultRepository;

    public DatabaseController(DriverRepository driverRepository, GrandPrixRepository grandPrixRepository, ResultRepository resultRepository) {
        this.driverRepository = driverRepository;
        this.grandPrixRepository = grandPrixRepository;
        this.resultRepository = resultRepository;
    }

    @GetMapping("/database")
    public String databasePage() {
        return "database";
    }
}
