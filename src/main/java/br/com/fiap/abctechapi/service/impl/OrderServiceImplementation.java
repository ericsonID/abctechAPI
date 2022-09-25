package br.com.fiap.abctechapi.service.impl;

import br.com.fiap.abctechapi.handler.exception.MaxAssistsException;
import br.com.fiap.abctechapi.handler.exception.MinimumAssistRequiredException;
import br.com.fiap.abctechapi.model.Assistance;
import br.com.fiap.abctechapi.model.Order;
import br.com.fiap.abctechapi.repository.IAssistanceRepository;
import br.com.fiap.abctechapi.repository.IOrderRepository;
import br.com.fiap.abctechapi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImplementation implements IOrderService {

    private IOrderRepository orderRepository;
    private IAssistanceRepository assistanceRepository;

    public OrderServiceImplementation(
            @Autowired IOrderRepository orderRepository,
            @Autowired IAssistanceRepository assistanceRepository) {
        this.orderRepository = orderRepository;
        this.assistanceRepository = assistanceRepository;
    }

    @Override
    public void saveOrder(Order order, List<Long> arrayAssists) throws Exception{
        ArrayList<Assistance> assistances = new ArrayList<>();
        arrayAssists.forEach(i -> {
            Assistance assistance = assistanceRepository.findById(i).orElseThrow();
            assistances.add(assistance);
        });

        order.setAssists(assistances);

        if(!order.hasMinAssists()){
            //throw new Exception();
            throw new MinimumAssistRequiredException("Invalid Assists", "Necessário no minímo 1 assistência");
        }else if (order.exceedsMaxAssists()){
            //throw new Exception();
            throw new MaxAssistsException("Invalid Assists", "Número máximo de assistências é 15");
        }

        orderRepository.save(order);
    }

    @Override
    public List<Order> listOrderByOperator(Long operationId) {
        return null;
    }
}
