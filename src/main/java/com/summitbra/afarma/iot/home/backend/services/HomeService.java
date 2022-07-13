package com.summitbra.afarma.iot.home.backend.services;

import com.summitbra.afarma.iot.home.backend.data.DosageCountDTO;
import com.summitbra.afarma.iot.home.backend.data.ResidentCountDTO;
import com.summitbra.afarma.iot.home.backend.repositories.DeviceConfigurationRepository;
import com.summitbra.afarma.iot.home.backend.repositories.EventsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    private final DeviceConfigurationRepository deviceConfigurationRepository;
    private final EventsRepository eventsRepository;

    public HomeService(DeviceConfigurationRepository deviceConfigurationRepository,
                       EventsRepository eventsRepository) {
        this.deviceConfigurationRepository = deviceConfigurationRepository;
        this.eventsRepository = eventsRepository;
    }

    public List<ResidentCountDTO> findResidents(){
        return deviceConfigurationRepository.findResidents();
    }

    public List<DosageCountDTO> findDosage(){
        return eventsRepository.findEvents();
    }


    public List<DosageCountDTO> findEvents(){
        return eventsRepository.findTotalEvents();
    }

}
