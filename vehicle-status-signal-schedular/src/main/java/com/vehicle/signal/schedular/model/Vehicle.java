/**
 * 
 */
package com.vehicle.signal.schedular.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author P Nabee
 *
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Vehicle {

	private String id;
	private String registrationNumber;
	private Status status;
	private LocalDateTime lastPulseTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
