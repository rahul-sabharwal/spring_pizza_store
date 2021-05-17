package com.demo.pizzastore.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.demo.pizzastore.Domain.Item;
import com.demo.pizzastore.Domain.SideDish;
import com.demo.pizzastore.Repository.SideDishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SideDishService {
	
	@Autowired
	private SideDishRepo sdRepo;
	
	public SideDishService() {
		System.out.println("Service Created");
	}

	public void deleteSideDish(long id) {
		sdRepo.deleteById(id);
	}
	

	public SideDish updateSideDish(SideDish sideDish) {
		SideDish initsd = sdRepo.findById(sideDish.getId()).orElse(sideDish);
		initsd.setSdname(sideDish.getSdname());
		initsd.setSdquantity(sideDish.getSdquantity());
		return sdRepo.save(initsd);
	}

	public SideDish getSideDish(long id) {
		return sdRepo.findById(id).get();
	}

	public SideDish addSideDish(SideDish sideDish) {
		return sdRepo.save(sideDish);
	}

	public List<SideDish> getAllSideDishes() {
		return sdRepo.findAll();
	}

	public Item sdToItem(SideDish sideDish) {
		Item item = new SideDish();
		item = sideDish;
		return item;
	}
	
	public List<Item> sdToItem(List<SideDish> sideDish){
		return sideDish.stream().map(i -> sdToItem(i)).collect(Collectors.toList());
	}
}
