package LLDProject.RideSharingApp;

import java.util.ArrayList;
import java.util.List;

public class RideMatchingSystem {

	private List<Driver> availableDrivers = new ArrayList<>();

	public void addDriver(Driver driver) {
		availableDrivers.add(driver);
	}

	public void requestRide(Passenger passanger, double distance, FareStrategy fareStrategy) {
		if (availableDrivers.isEmpty()) {

			// Mechanism to notify the passenger.
			passanger.notify("Driver is not available");
			return;
		}

		// find the nearest driver available
		Driver nearestDriver = findNearestDriver(passanger.getLocation());

		// Mediator
		availableDrivers.remove(nearestDriver);
		passanger.notify("Ride schedule successfully" + nearestDriver);

		// change the status of the ride?

		// change the status of the ride after ride is finished
		availableDrivers.add(nearestDriver);
	}

	private Driver findNearestDriver(Location passengerLocation) {

		Driver assignedDriver = null;
		double minDist = Double.MAX_VALUE;
		for (Driver driver : availableDrivers) {
			double distance = driver.getLocation().calcDistance(passengerLocation);
			if (distance < minDist) {
				minDist = distance;
				assignedDriver = driver;
			}
		}
		return assignedDriver;
	}
}
