package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Adminproduct;

public interface AdminproductService {
	List<Adminproduct> getAllProducts();
	void saveProduct(Adminproduct adminproduct);
	Adminproduct getAdminproductById(long id);
	void deleteEmployeebyId(long id);
	
}
