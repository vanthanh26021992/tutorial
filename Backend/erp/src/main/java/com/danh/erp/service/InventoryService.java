package com.danh.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danh.erp.dto.Inventory;
import com.danh.erp.mapper.InventoryMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryMapper invMapper;
	

	@Transactional
	public void insert (Inventory inventory) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(inventory));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		invMapper.insert(inventory);
	}

	@Transactional
	public void update (Inventory inventory) {
		String code = inventory.getProductCode();
		Inventory inventoryTerm = invMapper.selectByCode( code);
		System.out.println(" " +inventoryTerm.getProductCode());
		System.out.println(" " +inventoryTerm.getId());
		int quantity =  inventoryTerm.getQuantity()-inventory.getQuantity();
		inventoryTerm.setQuantity(quantity);
		long	 priceTotal =  inventoryTerm.getPriceTotal()-inventory.getPriceTotal();
		inventoryTerm.setPriceTotal(priceTotal);
		invMapper.updateByCode(inventoryTerm);
		
		//insert 
	}
	
	@Transactional(readOnly = true)
	public Inventory searchInventoryByName(String name) {
		return invMapper.searchInventoryByName(name);
	}
}
