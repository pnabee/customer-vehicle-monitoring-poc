
package com.cust.vehicle.monitor.service;

import static java.time.LocalDateTime.now;
import static java.util.Optional.ofNullable;

import java.util.List;
import java.util.Optional;

//import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cust.vehicle.monitor.model.Status;
import com.cust.vehicle.monitor.model.Vehicle;
import com.cust.vehicle.monitor.repo.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	public void addVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	public Optional<Vehicle> findById(String vehicleId) {
		return vehicleRepository.findById(vehicleId);
	}

	public Boolean saveVehicle(Vehicle vehicle) {
	
		vehicleRepository.saveAndFlush(vehicle);
		return true;
	}
	
	public List<Vehicle> findByVehiclesById(String custid){
		
		return vehicleRepository.findByVehiclesByCustId(custid);
	}
	
	public Optional<Vehicle> pulse(String vehicleId) {
		return ofNullable(vehicleRepository.findById(vehicleId).map(vehicle -> {
			vehicle.setStatus(Status.CONNECTED);
			vehicle.setLastPulseTime(now());
			//System.out.println("vehicle status@@@@@@@@@@@::"+vehicle.getStatus()+"name@@:"+vehicle.getCustomer().getName());
			vehicleRepository.save(vehicle);
			return vehicle;
		}).orElse(null));
	}

}
