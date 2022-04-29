package com.DB.exam.model;

import com.DB.exam.enums.PizzaType;
import com.DB.exam.enums.Toppings;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {
    @Id
    private Long id;

    private PizzaType pizzaType;
    private List<Toppings> extraToppings;

    @ManyToOne
    private Order order;
}
