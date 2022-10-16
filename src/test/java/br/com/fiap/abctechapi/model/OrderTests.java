package br.com.fiap.abctechapi.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

public class OrderTests {
    private Order order;
    @Mock
    private AssistanceTests assistanceTests;

    @BeforeEach
    public void setUp() {
        order = new Order();
        assistanceTests = new AssistanceTests();
    }

    @Test
    public void test_order_not_null() {
        Assertions.assertNotNull(order);
    }
    @Test
    public void test_order_args() {
        Assistance assistance1 = new Assistance(123L,"Teste","TesteName");
        Assistance assistance2 = new Assistance(122L,"Teste1","TesteName1");
        OrderLocation orderLocationStart = new OrderLocation(new Long(123), 13.123, 12.3455, new Date());
        OrderLocation orderLocationEnd = new OrderLocation(new Long(122), 13.133, 12.3415, new Date());
        order = new Order(1L,234L, List.of(assistance1,assistance2),orderLocationStart,orderLocationEnd);
        Assertions.assertNotNull(order);
    }
    @Test
    public void test_order_id() {
        Long id = new Long(123456);
        order.setId(id);
        Assertions.assertEquals(order.getId(), id);
    }
    @Test
    public void test_order_operationId() {
        Long operationId = new Long(123L);
        order.setOperatorId(operationId);
        Assertions.assertEquals(order.getOperatorId(), operationId);
    }

}
