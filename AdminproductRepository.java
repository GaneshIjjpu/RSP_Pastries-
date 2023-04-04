package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Adminproduct;

@Repository
public interface AdminproductRepository extends JpaRepository<Adminproduct, Long>{

}
