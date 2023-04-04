package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admincoupon;
import com.example.demo.repository.AdmincouponRepository;

@Service
public class AdmincouponServiceImpl implements AdmincouponService{

	@Autowired
	
	private AdmincouponRepository admincouponRepository;
	@Override
	public List<Admincoupon> getAllCoupons() {
		return admincouponRepository.findAll();
	}
	@Override
	public void saveCoupons(Admincoupon admincoupon) {
		this.admincouponRepository.save(admincoupon);
		
	}
	@Override
	public Admincoupon getAdmincouponById(long id) {
		java.util.Optional<Admincoupon> optional = admincouponRepository.findById(id);
		Admincoupon admincoupon=null;
		if(optional.isPresent()) {
			admincoupon=optional.get();
		}
		else {
			throw new RuntimeException("Coupon not found for id::"+id);
		}
		return admincoupon;
	}
	@Override
	public void deleteCouponbyId(long id) {
		this.admincouponRepository.deleteById(id);
		
	}

	

}
