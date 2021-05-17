package com.demo.pizzastore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.pizzastore.Domain.SideDish;


@Repository
public interface SideDishRepo extends JpaRepository<SideDish, Long>{
		
}
