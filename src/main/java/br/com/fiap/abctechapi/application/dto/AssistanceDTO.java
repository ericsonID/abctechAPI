package br.com.fiap.abctechapi.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class AssistanceDTO {

    private Long id;
    private String name;
    private String description;

}
