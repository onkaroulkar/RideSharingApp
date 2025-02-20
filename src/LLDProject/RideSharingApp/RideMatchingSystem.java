package LLDProject.RideSharingApp;

import java.util.ArrayList;
import java.util.List;

public class RideMatchingSystem {

	private List<Driver> availableDrivers = new ArrayList<>();

	public void addDriver(Driver driver) {
		availableDrivers.add(driver);
	}
	
	
	
	public void requestRide(Passenger passanger,double distance,FareStrategy fareStrategy) {
		if(availableDrivers.isEmpty()) {
			passanger.notify("Driver is not available");
		}
	}
}
