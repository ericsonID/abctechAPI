package br.com.fiap.abctechapi.application.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderLocationDTO {

    private Double latitude;
    private Double longitude;
    private Date dateTime;
}
