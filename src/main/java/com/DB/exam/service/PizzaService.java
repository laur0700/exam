package com.DB.exam.service;

import com.DB.exam.dto.PizzaDTO;
import com.DB.exam.error.InvalidPizzaTypeException;
import com.DB.exam.factory.PizzaFactory;
import com.DB.exam.model.Pizza;
import com.DB.exam.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    PizzaFactory pizzaFactory;

    public List<Pizza> findAll(){
        return pizzaRepository.findAll();
    }

    public Pizza findById(Long id){
        Optional<Pizza> pizzaOptional = pizzaRepository.findById(id);

        return pizzaOptional.orElse(null);
    }

    public void create(PizzaDTO pizzaDTO) throws InvalidPizzaTypeException {
        Pizza newPizza = PizzaFactory.createPizza(pizzaDTO.getPizzaType());

        pizzaRepository.save(newPizza);
    }
}
