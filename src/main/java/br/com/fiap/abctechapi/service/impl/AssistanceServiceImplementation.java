package br.com.fiap.abctechapi.service.impl;

import br.com.fiap.abctechapi.service.IAssistanceService;
import br.com.fiap.abctechapi.model.Assistance;
import br.com.fiap.abctechapi.repository.IAssistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssistanceServiceImplementation implements IAssistanceService {
    private final IAssistanceRepository repository;

   @Autowired
   public AssistanceServiceImplementation(IAssistanceRepository repository){
       this.repository = repository;
   }
    @Override
    public List<Assistance> getAssistanceList() {
        return repository.findAll();
    }
}
