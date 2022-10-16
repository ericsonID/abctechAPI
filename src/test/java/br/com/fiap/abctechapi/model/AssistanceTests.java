package br.com.fiap.abctechapi.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AssistanceTests {
    private Assistance assistance;

    @BeforeEach
    public void setUp() {
        assistance = new Assistance();
    }

    @Test
    public void test_assistance_not_null() {
        Assertions.assertNotNull(assistance);
    }
    @Test
    public void test_assistance_args() {
        assistance = new Assistance(123L,"Teste","TesteName");
        Assertions.assertNotNull(assistance);
    }
    @Test
    public void test_assistance_id() {
        Long id = new Long(123456);
        assistance.setId(id);
        Assertions.assertEquals(assistance.getId(), id);
    }
    @Test
    public void test_assistance_description() {
        String description = new String("Teste Description");
        assistance.setDescription(description);
        Assertions.assertEquals(assistance.getDescription(), description);
    }
    @Test
    public void test_assistance_name() {
        String name = new String("Teste Name");
        assistance.setName(name);
        Assertions.assertEquals(assistance.getName(), name);
    }

}
