package br.com.fiap.abctechapi.controller;

import br.com.fiap.abctechapi.application.IOrderApplication;
import br.com.fiap.abctechapi.application.dto.OrderDto;
import br.com.fiap.abctechapi.application.dto.OrderLocationDTO;
import br.com.fiap.abctechapi.repository.IAssistanceRepository;
import br.com.fiap.abctechapi.repository.IOrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;


public class OrderControllerTest {
    @InjectMocks
    OrderController orderController;
    @Mock
    private IOrderApplication orderApplication;
    @Mock
    private IOrderRepository orderRepository;
    @Mock
    private IAssistanceRepository assistanceRepository;

    @BeforeEach
    public void init() {
        orderApplication = new IOrderApplication() {
            @Override
            public void createOrder(OrderDto orderDto) throws Exception {

            }
        };
    }
    @Test
    public void orderApplication_not_null (){
        Assertions.assertNotNull(orderApplication);
    }
    @Test
    public void testcreateOrder() throws Exception {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        OrderDto newOrder = new OrderDto();
        Date startDate = new Date(1998,3, 06);
        Date endDate = new Date(1998,4, 07);
        OrderLocationDTO orderLocationDTO = new OrderLocationDTO();
        orderLocationDTO.setLongitude(123.0);
        orderLocationDTO.setLongitude(24.0);
        orderLocationDTO.setDateTime(startDate);
        newOrder.setOperationId(1234L);
        newOrder.setAssists(List.of(1L, 2L));
        newOrder.setStart(orderLocationDTO);
        orderLocationDTO.setDateTime(endDate);
        newOrder.setEnd(orderLocationDTO);
        orderApplication.createOrder(newOrder);
        verify(orderApplication, atLeastOnce()).createOrder(newOrder);


    }
}
