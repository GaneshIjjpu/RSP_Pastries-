package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Adminevent;

@Repository
public interface AdmineventRepository extends JpaRepository<Adminevent, Long>{

}