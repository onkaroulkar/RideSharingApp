package LLDProject.RideSharingApp;

abstract class Vehicle {

	protected String numberPlate;

	public Vehicle(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	
	public abstract double getFarePerKm();
}
