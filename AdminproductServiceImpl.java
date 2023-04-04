package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Adminproduct;
import com.example.demo.repository.AdminproductRepository;

//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class AdminproductServiceImpl implements AdminproductService {

	@Autowired
	private AdminproductRepository adminproductRepository;
	@Override
	public List<Adminproduct> getAllProducts() {
		return adminproductRepository.findAll();
	}
	@Override
	public void saveProduct(Adminproduct adminproduct) {
		this.adminproductRepository.save(adminproduct);
		
	}
	@Override
	public Adminproduct getAdminproductById(long id) {
		java.util.Optional<Adminproduct> optional = adminproductRepository.findById(id);
		Adminproduct adminproduct=null;
		if(optional.isPresent()) {
			adminproduct=optional.get();
		}
		else {
			throw new RuntimeException("Product not found for id::"+id);
		}
		return adminproduct;
	}
	@Override
	public void deleteEmployeebyId(long id) {
		this.adminproductRepository.deleteById(id);
		
	}
	
	}


