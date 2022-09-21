package br.com.fiap.abctechapi.controller;

import br.com.fiap.abctechapi.model.Assistance;
import br.com.fiap.abctechapi.service.IAssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assistance")
public class AssistanceController {

    private final IAssistanceService service;

    @Autowired
    public AssistanceController(IAssistanceService service){
        this.service=service;
    }
    @GetMapping()
    public ResponseEntity<List<Assistance>> getAssists(){
        List<Assistance> assistanceList = service.getAssistanceList();
        return ResponseEntity.ok(assistanceList);
    }
}
