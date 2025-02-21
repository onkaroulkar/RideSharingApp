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

		Ride ride = new Ride(passanger, nearestDriver, distance, fareStrategy);

		// Calculate fare
		ride.calculateFare();

		// notify both passenger and driver
		passanger.notify("Ride scheduled with fare + Rs " + ride.getFare());
		nearestDriver.notify("You have a new ride request for " + ride.getFare());

		// change the status of the ride
		ride.updateStatus(RideStatus.ONGOING);

		// change the status of the ride after ride is finished
		ride.updateStatus(RideStatus.COMPLETED);
		availableDrivers.add(nearestDriver);
		return;
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
