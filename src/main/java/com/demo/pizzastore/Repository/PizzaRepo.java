package com.demo.pizzastore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.pizzastore.Domain.Pizza;

@Repository
public interface PizzaRepo extends JpaRepository<Pizza, Long>{

}
