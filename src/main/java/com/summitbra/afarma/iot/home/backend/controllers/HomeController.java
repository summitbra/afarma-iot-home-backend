package com.summitbra.afarma.iot.home.backend.controllers;

import com.summitbra.afarma.iot.home.backend.data.DosageCountDTO;
import com.summitbra.afarma.iot.home.backend.data.ResidentCountDTO;
import com.summitbra.afarma.iot.home.backend.services.HomeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/backend/home")
public class HomeController {

    private HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/resident")
    public List<ResidentCountDTO> listOrders() {
        return homeService.findResidents();
    }

    @GetMapping("/dosage")
    public List<DosageCountDTO> listDosage() {
        return homeService.findDosage();
    }

    @GetMapping("/events")
    public List<DosageCountDTO> listEvents() {
        return homeService.findEvents();
    }
}
