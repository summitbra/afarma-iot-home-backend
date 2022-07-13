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


    @JsonProperty("message")
    @Column(name = "message")
    private String message;

    public Long getResidentCount() {
        return residentCount;
    }

    public void setResidentCount(Long residentCount) {
        this.residentCount = residentCount;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DosageCountDTO() {
    }

    public DosageCountDTO(Long residentCount, String message) {
        this.residentCount = residentCount;
        this.message = message;
    }
}
