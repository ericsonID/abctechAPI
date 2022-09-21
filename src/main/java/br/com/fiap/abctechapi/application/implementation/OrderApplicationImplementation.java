package br.com.fiap.abctechapi.application.implementation;

import br.com.fiap.abctechapi.application.IOrderApplication;
import br.com.fiap.abctechapi.application.dto.OrderDto;
import br.com.fiap.abctechapi.application.dto.OrderLocationDTO;
import br.com.fiap.abctechapi.model.Order;
import br.com.fiap.abctechapi.model.OrderLocation;
import br.com.fiap.abctechapi.repository.IAssistanceRepository;
import br.com.fiap.abctechapi.repository.IOrderRepository;
import br.com.fiap.abctechapi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderApplicationImplementation implements IOrderApplication {
    private IOrderService orderService;

    public OrderApplicationImplementation(@Autowired IOrderService orderService){
        this.orderService = orderService;
    }


    @Override
    public void createOrder (OrderDto orderDto) throws Exception {
        Order order = new Order();
        order.setOperatorId(orderDto.getOperationId());
        order.setStartOrderLocation(getOrderLocationFromOrderLocationDto(orderDto.getStart()));
        order.setEndOrderLocation(getOrderLocationFromOrderLocationDto(orderDto.getEnd()));
        this.orderService.saveOrder(order, orderDto.getAssists());
    }
    private OrderLocation getOrderLocationFromOrderLocationDto(OrderLocationDTO orderLocationDto){
        OrderLocation orderLocation = new OrderLocation();
        orderLocation.setLatitude(orderLocationDto.getLatitude());
        orderLocation.setLongitude(orderLocationDto.getLongitude());
        orderLocation.setDate(orderLocationDto.getDateTime());
        return orderLocation;
    }
}
