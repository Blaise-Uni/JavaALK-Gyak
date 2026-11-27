package hu.gyak.beadando.controller;

import hu.gyak.beadando.entity.Driver;
import hu.gyak.beadando.repository.DriverCRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CRUDController {
    @Autowired
    private DriverCRUDRepository driverCRUDRepository;

    @GetMapping("/crud")
    public String crudPage(Model model) {
        model.addAttribute("drivers", driverCRUDRepository.findAll());
        return "crud";
    }

    @GetMapping("/crud/create")
    public String createDriver(Model model) {
        model.addAttribute("driver", new Driver());
        return "crud/create";
    }

    @PostMapping(value = "/crud/create")
    public String createDriver(@ModelAttribute Driver driver) {
        driverCRUDRepository.save(driver);
        return "redirect:/crud";
    }

    @GetMapping("/crud/edit/{id}")
    public String updateDriver(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("driver", driverCRUDRepository.findById(id).get());
        return "crud/edit";
    }

    @PostMapping(value = "/crud/edit")
    public String updateDriver(@ModelAttribute Driver driver) {
        driverCRUDRepository.save(driver);
        return "redirect:/crud";
    }

    @GetMapping("/crud/delete/{id}")
    public String deleteDriver(@PathVariable(name = "id") Long id, Model model) {
        driverCRUDRepository.delete(driverCRUDRepository.findById(id).get());
        return "redirect:/crud";
    }
}
