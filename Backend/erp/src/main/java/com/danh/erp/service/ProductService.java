package com.danh.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danh.erp.dto.Product;
import com.danh.erp.mapper.InventoryMapper;
import com.danh.erp.mapper.ProductMapper;

@Service
public class ProductService {

	@Autowired
	private ProductMapper proMapper;
	


	public List<Product> searchProductByName(String mame) {
		return proMapper.searchProductByName(mame);
	}
	
}
