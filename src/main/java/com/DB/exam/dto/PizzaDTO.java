package com.DB.exam.dto;

import com.DB.exam.enums.PizzaType;
import com.DB.exam.enums.Toppings;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDTO {
    private PizzaType pizzaType;
    private List<Toppings> extraToppings;
}
