package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admincategory;

@Repository
public interface AdmincategoryRepository extends JpaRepository<Admincategory, Long>{

}