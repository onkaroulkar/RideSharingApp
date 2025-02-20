package LLDProject.RideSharingApp;

public interface FareStrategy {
	double calcFare(Vehicle vehicle,double distance);
}

class StandardFareStrategy implements FareStrategy{ 

	@Override
	public double calcFare(Vehicle vehicle, double distance) {
		return vehicle.getFarePerKm()*distance;
	}
}

class SharedFareStrategy implements FareStrategy{

	@Override
	public double calcFare(Vehicle vehicle, double distance) {
		return vehicle.getFarePerKm()*distance*0.50;
	}
}

class LuxuryStrategy implements FareStrategy{

	@Override 
	public double calcFare(Vehicle vehicle, double distance) {
		return vehicle.getFarePerKm()*distance*1.5;
	}
}