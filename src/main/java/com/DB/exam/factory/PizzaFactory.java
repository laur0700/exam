package com.DB.exam.factory;

import com.DB.exam.enums.PizzaType;
import com.DB.exam.error.InvalidPizzaTypeException;
import com.DB.exam.model.Pizza;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PizzaFactory {
    public static Pizza createPizza(PizzaType pizzaType) throws InvalidPizzaTypeException {
        Pizza newPizza = new Pizza();
        if (Arrays.stream(PizzaType.values()).toList().contains(pizzaType)){
            newPizza.setPizzaType(pizzaType);

            return newPizza;
        }
        else {
            throw new InvalidPizzaTypeException("The pizza with the selected pizza-type doesn't exist!");
        }
    }
}
