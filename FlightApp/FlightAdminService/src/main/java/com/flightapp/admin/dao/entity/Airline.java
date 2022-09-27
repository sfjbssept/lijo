/**
 * 
 */
package com.flightapp.admin.dao.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author LIJO JOSEPH
 *
 */
@Entity
@Getter
@Setter
@Table(name = "tb_airline")
public class Airline implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer id;
	
	@Column(name = "airline_name")
	private String airlineName;
	
	@Column(name = "airline_code")
	private String airlineCode;
	
	private String status;
	
	@Column(name = "no_of_flights")
	private Integer flightCount;
	
	@Column(name = "contact_no")
	private Long ContactNumber;
	
	@Column(name = "website")
	private String websiteUrl;
	
	@OneToMany(mappedBy = "airline" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Flight> flightList;
}
