package com.cust.vehicle.monitor.repo;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cust.vehicle.monitor.model.Vehicle;





@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	@Query(value = "SELECT * FROM vehicle WHERE custid=?",  nativeQuery = true)
	List<Vehicle> findByVehiclesByCustId(@Param("custid") String custid);
	
	

}
