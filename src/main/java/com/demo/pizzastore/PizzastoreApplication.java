package com.demo.pizzastore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.pizzastore.domain.Order;
import com.demo.pizzastore.domain.Pizza;
import com.demo.pizzastore.domain.SideDish;
import com.demo.pizzastore.repository.OrderRepo;

@SpringBootApplication
public class PizzastoreApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PizzastoreApplication.class, args);
	}
	
	@Autowired
	public OrderRepo orderRepo;
	

	@Override
	public void run(String... args) throws Exception {
		Order order =  new Order("Raghav");
		
		Pizza pizza1 = new Pizza("Regular","Medium","Parmezan");
		Pizza pizza2 = new Pizza("Thin","Large","Olives");
		Pizza pizza3 = new Pizza("Thin","Small","Jalapenos, Mushrooms");
		
		SideDish sideDish = new SideDish("Garlic Bread",1);
		SideDish sideDish1 = new SideDish("Garlic Dip",2);
		
		order.getPizza().add(pizza1);
		order.getPizza().add(pizza2);
		order.getPizza().add(pizza3);
		
		order.getSideDish().add(sideDish);
		order.getSideDish().add(sideDish1);

		orderRepo.save(order);

	}

}
