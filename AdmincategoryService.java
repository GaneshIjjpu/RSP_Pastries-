package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Admincategory;

public interface AdmincategoryService {
	List<Admincategory> getAllCategories();
	void saveCategory(Admincategory admincategory);
	Admincategory getAdmincategoryById(long id);
	void deleteCategorybyId(long id);
}
