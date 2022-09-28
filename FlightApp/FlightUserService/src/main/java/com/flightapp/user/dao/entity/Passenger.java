package com.flightapp.user.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_passenger")
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_id")
	private Integer  userId;
	
	private String name;
	
	private String address;
	
	@Column(name = "passport_no")
	private String passportNo;
	
	@Column(name = "id_card_no")
	private String idCardNo;
	
	@Column(name = "id_card_Type")
	private String idCardType;
	
	private String gender;
	private Integer age;
	private Date dob;
	private Long phone;
	private String email;
}
