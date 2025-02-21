package LLDProject.RideSharingApp;

enum RideStatus {
	PENDING, ONGOING, COMPLETED;
}

public class Ride {

	private Passenger passenger;
	private Driver driver;
	private double distance;
	private FareStrategy fareStrategy;
	private double fare;
	private RideStatus status;
}
