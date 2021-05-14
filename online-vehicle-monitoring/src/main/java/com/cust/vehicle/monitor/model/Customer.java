package com.cust.vehicle.monitor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "custid")
	private String custid;
	@Size(max=50)
    @Column(name = "name", unique=true, nullable=false)
	private String name;
	@Size(max = 200)
	@Column(name = "address")
	private String address;
	
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
	private Set <Vehicle> vehicles = new HashSet<>(); //Customer <-> Vehicle OneToMany
	
	
	
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
		
	}

}
