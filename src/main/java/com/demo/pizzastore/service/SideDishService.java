package com.demo.pizzastore.service;

import java.util.List;

import com.demo.pizzastore.domain.SideDish;
import com.demo.pizzastore.repository.SideDishRepo;

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

}
