package app;

public class Wallet {
	
	private double amount;

	public Wallet() {
		
	}

	public double getAmount() {
		return amount;
	}
	
	public void addCash(double cash) {
		amount+=cash;
	}
	
	public void subtractionCash(double cash) {
		amount-=cash;
	}
}
