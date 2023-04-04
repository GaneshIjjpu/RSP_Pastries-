package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admincategory;
import com.example.demo.repository.AdmincategoryRepository;

@Service
public class AdmincategoryServiceImpl implements AdmincategoryService{

	@Autowired
	
	private AdmincategoryRepository admincategoryRepository;
	@Override
	public List<Admincategory> getAllCategories() {
		return admincategoryRepository.findAll();
	}
	@Override
	public void saveCategory(Admincategory admincategory) {
		this.admincategoryRepository.save(admincategory);
		
	}
	@Override
	public Admincategory getAdmincategoryById(long id) {
		java.util.Optional<Admincategory> optional = admincategoryRepository.findById(id);
		Admincategory admincategory=null;
		if(optional.isPresent()) {
			admincategory=optional.get();
		}
		else {
			throw new RuntimeException("Product Category not found for id::"+id);
		}
		return admincategory;
	}
	@Override
	public void deleteCategorybyId(long id) {
		this.admincategoryRepository.deleteById(id);
		
	}
	

}
