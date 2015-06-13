package developpements.lariviere.android_tipcalc.model;
import java.util.ArrayList;
import java.util.Observable;

//import view.AbstractPanel;

public class TipSystem extends Observable {

ArrayList<Integer> percentageList = new ArrayList<Integer>();
Tip currentTip;
int percentage;
double newTotal;
static private TipSystem ts;

	/***    DEFALT CONSTRUCTOR   ***/
	private TipSystem(){
		if (checkExistingPreferences()) {
			// First connect to database
			// Get preferences
			// Import preferences from DB to List
		}
		else {
			defaultPercentage();
		}
	}
	
	static public TipSystem getInstance(){
		if(ts == null){
			ts = new TipSystem();
		}
		return ts;
	}
	
	/***    PUBLIC METHODS   ***/
	public void createTip(double price, double tipTax, double govtTax){
		currentTip = new Tip(price, govtTax ,tipTax);
		System.out.println("TipSystem:: Tip has been created.");
		//newTotal = calculateTip(currentTip);
		this.setChanged();
		notifyObservers(newTotal);
		System.out.println("TipSystem:: Tip has been notified.");
		// Subscribe Tip to the observer(notify)
	}
	public double calculateTip(Tip currentTip){
		System.out.println("TipSystem:: Tip has been calculated.");
		return (currentTip.getPrice()*currentTip.getTipPercent());
	}
	public double calculateGovtTax(Tip currentTip) {
		System.out.println("TipSystem:: Governement tax has been calculated.");
		return (currentTip.getPrice()*currentTip.getGovTax());
	}
	public double calculateTotal(Tip currentTip){
		System.out.println("TipSystem:: Tip total has been calculated.");
		return (calculateTip(currentTip) + calculateGovtTax(currentTip) + currentTip.getPrice());
	}
	public double calculateGovtTax(){
		System.out.println("TipSystem:: Governement tax has been calculated.");
		return (getCurrentTip().getPrice()*getCurrentTip().getGovTax());
	}
	public double calculateTip(){
		System.out.println("TipSystem:: Tip has been calculated.");
		return (getCurrentTip().getPrice()*getCurrentTip().getTipPercent());
	}
	public double calculateTotal(){
		System.out.println("TipSystem:: Tip total has been calculated.");
		return (calculateGovtTax()+calculateTip()+getCurrentTip().getPrice());
	}
	
	public double getNewTotal(){
		return newTotal;
	}
	/*public void setSubscription(AbstractPanel ap) {
		addObserver(ap);
		System.out.println("TipSystem:: Subscription has been set.");
	}*/
	/***    PRIVATE METHODS   ***/
	private Tip getCurrentTip(){
		return this.currentTip;
	}
	private void defaultPercentage(){
		this.percentageList.add(5);
		this.percentageList.add(10);
		this.percentageList.add(15);
		this.percentageList.add(20);
	}
	private boolean checkExistingPreferences(){
		return true;
	}
	
	// Get the tips information and send it to the client's email.
	public void sendMail() {
		
	}
}
