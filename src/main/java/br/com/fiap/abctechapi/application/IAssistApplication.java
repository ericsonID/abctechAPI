package br.com.fiap.abctechapi.application;

import br.com.fiap.abctechapi.application.dto.AssistanceDTO;

import java.util.List;

public interface IAssistApplication {
    List<AssistanceDTO> getAssists();
}
