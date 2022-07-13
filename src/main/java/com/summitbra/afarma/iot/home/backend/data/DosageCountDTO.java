package com.summitbra.afarma.iot.home.backend.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DosageCountDTO {

    @Id
    @JsonProperty("dosage_count")
    @Column(name = "dosage_count")
    private Long residentCount;

    public Long getResidentCount() {
        return residentCount;
    }

    public void setResidentCount(Long residentCount) {
        this.residentCount = residentCount;
    }
}