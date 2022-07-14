package com.summitbra.afarma.iot.home.backend.services;

import com.summitbra.afarma.iot.home.backend.data.DosageCountDTO;
import com.summitbra.afarma.iot.home.backend.data.ResidentCountDTO;
import com.summitbra.afarma.iot.home.backend.repositories.DeviceConfigurationRepository;
import com.summitbra.afarma.iot.home.backend.repositories.EventsRepository;
import com.summitbra.afarma.iot.home.backend.repositories.GraphicValueRepository;
import com.summitbra.afarma.iot.home.backend.util.HomeUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    private final DeviceConfigurationRepository deviceConfigurationRepository;
    private final EventsRepository eventsRepository;
    private final GraphicValueRepository graphicValueRepository;

    public HomeService(DeviceConfigurationRepository deviceConfigurationRepository,
                       EventsRepository eventsRepository, GraphicValueRepository graphicValueRepository) {
        this.deviceConfigurationRepository = deviceConfigurationRepository;
        this.eventsRepository = eventsRepository;
        this.graphicValueRepository = graphicValueRepository;
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

    public ResponseEntity<Object> findMedia(){
        return ResponseEntity.ok().body(HomeUtil.getPercentage(eventsRepository.findTotal().doubleValue(),
                eventsRepository.findOk().doubleValue()));
    }

    public ResponseEntity<Object> findGraphicValues(){
        return ResponseEntity.ok().body(HomeUtil.getGraphicValue(graphicValueRepository.findQuantityOfMonth()));
    }



}
