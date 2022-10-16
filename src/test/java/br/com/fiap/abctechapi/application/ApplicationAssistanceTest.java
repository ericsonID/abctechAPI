package br.com.fiap.abctechapi.application;

import br.com.fiap.abctechapi.application.dto.AssistanceDTO;
import br.com.fiap.abctechapi.application.implementation.AssistanceApplicationImplementation;
import br.com.fiap.abctechapi.model.Assistance;
import br.com.fiap.abctechapi.repository.IAssistanceRepository;
import br.com.fiap.abctechapi.service.IAssistanceService;
import br.com.fiap.abctechapi.service.impl.AssistanceServiceImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

public class ApplicationAssistanceTest {
    @Mock
    private IAssistanceRepository assistanceRepository;
    private IAssistanceService assistanceService;
    private IAssistApplication assistanceApplication;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        assistanceService = new AssistanceServiceImplementation(assistanceRepository);
        assistanceApplication = new AssistanceApplicationImplementation();
    }

    @Test
    public void test_assistance_application_success(){
        Assistance itemAssist = new Assistance(1L, "Mock Name", "Mock Description");
        Assistance itemAssist2 = new Assistance(2L, "Mock Name 2", "Mock Description 2");

        when(assistanceRepository.findAll()).thenReturn(List.of(itemAssist,itemAssist2));

        List<AssistanceDTO> values = assistanceApplication.getAssists();

        Assertions.assertEquals(values.size(), 2);
    }

    @Test
    public void test_assistance_application_empty(){
        when(assistanceRepository.findAll()).thenReturn(List.of());

        List<AssistanceDTO> values = assistanceApplication.getAssists();

        Assertions.assertEquals(values.size(), 0);
    }
}
