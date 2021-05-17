package com.demo.pizzastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.pizzastore.domain.Pizza;

@Repository
public interface PizzaRepo extends JpaRepository<Pizza, Long>{

}
