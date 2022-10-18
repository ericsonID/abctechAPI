package br.com.fiap.abctechapi.application.implementation;

import br.com.fiap.abctechapi.application.IAssistApplication;
import br.com.fiap.abctechapi.application.dto.AssistanceDTO;
import br.com.fiap.abctechapi.model.Assistance;
import br.com.fiap.abctechapi.service.IAssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssistanceApplicationImplementation implements IAssistApplication {
    private final IAssistanceService assistanceService;
    public AssistanceApplicationImplementation(
            @Autowired
            IAssistanceService assistanceService) {
        this.assistanceService = assistanceService;
    }
    @Override
    public List<AssistanceDTO> getAssists(){
        List<Assistance> listAssists = this.assistanceService.getAssistanceList();
        return listAssists.stream().map(
                assistance -> new AssistanceDTO(assistance.getId(), assistance.getName(), assistance.getDescription())
        ).collect(Collectors.toList());
    }
}
