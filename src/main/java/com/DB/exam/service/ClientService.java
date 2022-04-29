package com.DB.exam.service;

import com.DB.exam.dto.ClientDTO;
import com.DB.exam.model.Client;
import com.DB.exam.model.Order;
import com.DB.exam.model.Pizza;
import com.DB.exam.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PizzaService pizzaService;

    @Autowired
    OrderService orderService;

    public Client findById(Long id){
        Optional<Client> optionalClient = clientRepository.findById(id);

        return optionalClient.orElse(null);
    }

    public void create(ClientDTO clientDTO){
        Client newClient = new Client();
        newClient.setAddress(clientDTO.getAddress());
        newClient.setFirstName(clientDTO.getFirstName());
        newClient.setLastName(clientDTO.getLastName());


        clientRepository.save(newClient);
    }

    public void orderPizza(Long pizzaId, Client client){
        Order newOrder = new Order();
        newOrder.getPizzaList().add(pizzaService.findById(pizzaId));
        newOrder.setClient(this.findById(client.getId()));
        orderService.saveNewOrder(newOrder);

        client.getOrders().add(newOrder);

        clientRepository.save(client);
    }
}
