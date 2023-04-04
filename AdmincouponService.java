package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Admincoupon;

public interface AdmincouponService {
	List<Admincoupon> getAllCoupons();
	void saveCoupons(Admincoupon admincoupon);
	void deleteCouponbyId(long id);
	Admincoupon getAdmincouponById(long id);
}
