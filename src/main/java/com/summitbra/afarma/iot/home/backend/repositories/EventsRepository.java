package com.summitbra.afarma.iot.home.backend.repositories;

import com.summitbra.afarma.iot.home.backend.data.DosageCountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<DosageCountDTO, Long > {

    @Query(value = "SELECT COUNT(*) as dosage_count FROM `afarma-iot-events`.events " +
            "WHERE  is_late = false AND event_name = 'MEDICACAO_TOMADA' ", nativeQuery = true)
    List<DosageCountDTO> findEvents();


    @Query(value = "SELECT COUNT(*) as dosage_count FROM `afarma-iot-events`.events ", nativeQuery = true)
    List<DosageCountDTO> findTotalEvents();



}
