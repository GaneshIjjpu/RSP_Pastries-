package com.example.demo.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admincoupon")
public class Admincoupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private int discount;
	@Column(nullable=false)
	private int eventid;
	@Column(nullable=false)
	private String coupon_code;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private Adminevent couponevent;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	

	public int getEventid() {
		return eventid;
	}


	public void setEventid(int eventid) {
		this.eventid = eventid;
	}


	public String getCoupon_code() {
		return coupon_code;
	}


	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}


	public Adminevent getCouponevent() {
		return couponevent;
	}


	public void setCouponevent(Adminevent couponevent) {
		this.couponevent = couponevent;
	}
	
	
}
