/**
 * 
 */
package com.cust.vehicle.monitor.controller;

import static org.springframework.http.ResponseEntity.noContent;



import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cust.vehicle.monitor.exception.ElementNullException;
import com.cust.vehicle.monitor.exception.ResourceNotFoundException;
import com.cust.vehicle.monitor.model.Customer;
import com.cust.vehicle.monitor.model.Vehicle;
import com.cust.vehicle.monitor.repo.VehicleRepository;
import com.cust.vehicle.monitor.service.CustomerService;
import com.cust.vehicle.monitor.service.VehicleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "Vehicle-Customer API")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private VehicleRepository vehicleRepository;
	
	
	@ApiOperation(value = "Save vehicle")
	@PostMapping("/vehicle/{name}")
	public ResponseEntity<Vehicle> saveVehicle(@RequestBody Vehicle vehicle,@PathVariable("name")final String name) {
		Customer customer = customerService.findCustomerByName(name).orElseThrow(() -> new ResourceNotFoundException("No Vehicle with that Customer Name !"));
		vehicle.setCustomer(customer);
		vehicleService.saveVehicle(vehicle);
		
		return new ResponseEntity<Vehicle>(HttpStatus.OK);

	}

	@ApiOperation(value = "Get all vehicles")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public ResponseEntity<List<Vehicle>> findAllVehicles() {
		List<Vehicle> vehicles = vehicleService.findAll();
		if (vehicles.isEmpty()) {
			return noContent().build();
		}
		return ok(vehicles);
	}
	/*@ApiOperation(value = "Get vehicle by vehicle Id")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{vehicleId}")
	public ResponseEntity<Vehicle> findVehicleById(
			@PathVariable("vehicleId") long vehicleId) {
		System.out.println("Vehicle Id @@@@@@@@@@@@@@@::"+vehicleId);
		vehicleService.findById(vehicleId);
		return new ResponseEntity<Vehicle>(HttpStatus.OK);
	}*/
	@ApiOperation(value = "Get vehicle by vehicleid")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{vehicleId}")
	public ResponseEntity<Customer> findByVehicleId(
			@PathVariable("vehicleId") Long vehicleId) {
		return customerService.find(vehicleId).map(ResponseEntity::ok)
				.orElse(notFound().build());
	}
	
	
	@ApiOperation(value = "Get all vehicles by customer name")
	@GetMapping("/vehicles/{customername}")
	public ResponseEntity<Collection<Vehicle>> findAllVehiclesByCustometName(@Valid @PathVariable("customername") final String name){
		
		List<Vehicle> vehicleCollection = vehicleRepository.findByVehicleWithName((name));
		
		
		if(vehicleCollection.isEmpty())
			throw new ElementNullException("No data with this CustomerName !");
		
		return new ResponseEntity<Collection<Vehicle>> (vehicleCollection, HttpStatus.OK);
			
	}
	
	@ApiOperation(value = "Vehcile ping schedular will update the vehicle status")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/{vehicleId}")
	public ResponseEntity<Vehicle> vehiclePing(
			@PathVariable("vehicleId") Long vehicleId) {
		return vehicleService.pulse(vehicleId).map(ResponseEntity::ok)
				.orElse(notFound().build());
}

}



