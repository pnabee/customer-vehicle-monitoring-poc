package com.vehicle.signal.schedular.client;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vehicle.signal.schedular.model.Vehicle;


@FeignClient("online-vehicle-monitoring")
public interface VehicleClient {

	@GetMapping("/api/vehicle")
	List<Vehicle> findAll();

	@PostMapping("/api/vehicle/{vehicleId}")
	Optional<Vehicle> pulse(@RequestParam String vehicleId);
	
	

}
