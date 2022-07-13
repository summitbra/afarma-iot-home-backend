package com.summitbra.afarma.iot.home.backend.repositories;

import com.summitbra.afarma.iot.home.backend.data.ResidentCountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceConfigurationRepository extends JpaRepository<ResidentCountDTO, Long > {

    @Query(value = "SELECT COUNT(*) AS resident_count  FROM `afarma-iot`.device_configuration " +
            "WHERE  resident_active = true ", nativeQuery = true)
    List<ResidentCountDTO> findResidents();

}
