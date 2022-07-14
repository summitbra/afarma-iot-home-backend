package com.summitbra.afarma.iot.home.backend.repositories;

import com.summitbra.afarma.iot.home.backend.data.GraphicValueDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphicValueRepository extends JpaRepository<GraphicValueDTO, String > {


    @Query(value = "SELECT COUNT(*) AS total, MONTH(insert_date) AS mes " +
            "FROM `afarma-iot-events`.events " +
            "WHERE event_status = 'MEDICACAO_TOMADA' " +
            "GROUP BY MONTH(insert_date) " +
            "ORDER BY mes ASC;", nativeQuery = true)
    List<GraphicValueDTO> findQuantityOfMonth();

}
