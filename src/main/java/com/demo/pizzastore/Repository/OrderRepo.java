package com.demo.pizzastore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.pizzastore.Domain.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

}

