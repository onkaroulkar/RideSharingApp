package LLDProject.RideSharingApp;

public class Client {

	public static void main(String[] args) {

		Location loc1 = new Location(12.34, 24.45);
		Location loc2 = new Location(23.554, 12.3435);
		Location loc3 = new Location(34.54, 55.35);

		Vehicle car = new Car("ADFFJHB");
		Vehicle bike = new Bike("SAGDHA");

		Driver driver1 = new Driver("Onkar", "onkaroulkar@gmail.com", loc1, bike);
		Driver driver2 = new Driver("Subha", "subhaoulkar@gmail.com", loc2, car);

		Passenger passenger1 = new Passenger("John", "johnpatil@gmail.com", loc3);

		RideMatchingSystem rideMatchingSystem = new RideMatchingSystem();
		rideMatchingSystem.addDriver(driver1);
		rideMatchingSystem.addDriver(driver2);
		rideMatchingSystem.requestRide(passenger1, 10, new SharedFareStrategy());
	}
}
