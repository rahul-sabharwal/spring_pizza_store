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
		Order order =  new Order("Raj");
		
		Pizza pizza1 = new Pizza("thin","small","parmezan");
		Pizza pizza2 = new Pizza("regular","large","pineapple");
		Pizza pizza3 = new Pizza("thin","small","parmezan");
		
		SideDish sideDish = new SideDish("gb",1);
		SideDish sideDish1 = new SideDish("gbind",2);
		SideDish sideDish2 = new SideDish("gbkknsd",3);
		
		order.getPizza().add(pizza1);
		order.getPizza().add(pizza2);
		order.getPizza().add(pizza3);
		
		order.getSideDish().add(sideDish);
		order.getSideDish().add(sideDish1);
		order.getSideDish().add(sideDish2);

		orderRepo.save(order);

	}

}
