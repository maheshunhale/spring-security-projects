package com.mahesh.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.springcloud.model.Coupon;
import com.mahesh.springcloud.repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
	
	@Autowired
	private CouponRepo couponRepo;
	
	@PostMapping("/coupons")
	public Coupon create(@RequestBody Coupon coupon) {
		System.out.println("Request => "+coupon.toString());
		return couponRepo.save(coupon);
	}
	
	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return couponRepo.findByCode(code);
	}
	

}
