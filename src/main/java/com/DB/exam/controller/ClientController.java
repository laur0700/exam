package com.DB.exam.controller;

import com.DB.exam.dto.ClientDTO;
import com.DB.exam.model.Client;
import com.DB.exam.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("create-new")
    public void create(@RequestBody ClientDTO clientDTO){
        clientService.create(clientDTO);
    }

    @PostMapping("order-pizza/id/{pizzaId}")
    public void orderPizza(@PathVariable Long pizzaId, @RequestBody Client client){
        clientService.orderPizza(pizzaId, client);
    }
}
