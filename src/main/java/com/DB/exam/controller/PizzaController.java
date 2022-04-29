package com.DB.exam.controller;

import com.DB.exam.dto.PizzaDTO;
import com.DB.exam.error.InvalidPizzaTypeException;
import com.DB.exam.model.Pizza;
import com.DB.exam.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pizza-menu")
public class PizzaController {
    @Autowired
    PizzaService pizzaService;

    @GetMapping("get-all")
    public List<Pizza> getAll(){
        return pizzaService.findAll();
    }

    @PostMapping("add-new")
    public void addNew(@RequestBody  PizzaDTO pizzaDTO) throws InvalidPizzaTypeException {
        pizzaService.create(pizzaDTO);
    }
}
