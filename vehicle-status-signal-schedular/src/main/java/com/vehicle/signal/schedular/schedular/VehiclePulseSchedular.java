package com.vehicle.signal.schedular.schedular;

import java.util.List;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.vehicle.signal.schedular.client.VehicleClient;
import com.vehicle.signal.schedular.model.Vehicle;

/**
 * @author P Nabee
 *
 */
@Component
public class VehiclePulseSchedular {

	private static final Logger logger = LoggerFactory.getLogger(VehiclePulseSchedular.class);

	@Autowired
	private VehicleClient vehicleClient;

	private Random rand = new Random();

	@Scheduled(fixedRate = 55000)
	public void pingVehicle() {

		logger.info("ping Vehicle");
		System.out.println("Hi Nabee !!!!!");

		List<Vehicle> vehicleList = vehicleClient.findAll();

		int vehicleCnt = rand.nextInt(vehicleList.size() - 1) + 1;

		for (int i = 0; i < vehicleCnt; i++) {
			int randomIndex = rand.nextInt(vehicleList.size());
			Vehicle randomVehicle = vehicleList.get(randomIndex);
			System.out.println("randomVehicle@@@@@@@@@@@@@@@@@::"+randomVehicle.getId());
			System.out.println("vehiclestatus@@@@@@@@@@@@@@::"+randomVehicle.getStatus());
			System.out.println("vehiclelastpulsetime@@@@@@@@@@@@@@::"+randomVehicle.getLastPulseTime());
			vehicleClient.pulse(randomVehicle.getId());
		}

	}
}
