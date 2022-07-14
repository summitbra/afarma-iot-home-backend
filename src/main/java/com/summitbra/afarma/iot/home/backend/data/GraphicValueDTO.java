package com.summitbra.afarma.iot.home.backend.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GraphicValueDTO {

    @Id
    @Column(name = "mes")
    private String month;

    @Column(name = "total")
    private Long count;

    public GraphicValueDTO() {
    }

    public GraphicValueDTO(String month, Long count) {
        this.month = month;
        this.count = count;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
