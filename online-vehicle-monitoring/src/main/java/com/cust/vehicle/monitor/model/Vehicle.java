
package com.cust.vehicle.monitor.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "vehicle")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Vehicle implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "vid")
	private String vid;
	
	@Size(max=50)
    @Column(name = "REG_NUM")
	private String registrationNumber;
	
	@Column(name = "status")
	private Status status;
	private LocalDateTime lastPulseTime;
	
	//@Size(max=50)
    @ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "custid", referencedColumnName = "custid", nullable = false)
	private Customer customer; //Vehicle <-> Customer  Many to one 
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getLastPulseTime() {
		return lastPulseTime;
	}

	public void setLastPulseTime(LocalDateTime lastPulseTime) {
		this.lastPulseTime = lastPulseTime;
	}
	
}
