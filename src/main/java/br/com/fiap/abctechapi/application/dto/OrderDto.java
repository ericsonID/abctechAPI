package br.com.fiap.abctechapi.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

    private Long operationId;
    private List<Long> assists;
    private OrderLocationDTO start;
    private OrderLocationDTO end;
    
}
