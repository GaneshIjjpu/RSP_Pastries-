package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admincoupon;

@Repository
public interface AdmincouponRepository extends JpaRepository<Admincoupon, Long>{

}
