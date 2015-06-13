package developpements.lariviere.android_tipcalc.model;

public class Tip {
	private double priceOfObject;
	private double govTax;
	private double tipPercent;
	
	
	/***    DEFALT CONSTRUCTOR   ***/
	public Tip (){
		this.priceOfObject = 20;
		this.govTax = 0.05;
		this.tipPercent = 0.15;
	}
	public Tip(double price, double govTax, double tip){
		this.priceOfObject = price;
		this.govTax = govTax;
		this.tipPercent = tip;
	}
	
	/***    PUBLIC METHODS   ***/
	public double getPrice(){
		return this.priceOfObject;
	}
	public void setPrice(double newPrice){
		this.priceOfObject = newPrice;
	}
	public void setTipPercent(double newTip){
		this.tipPercent = newTip;
	}
	public double getTipPercent(){
		return this.tipPercent;
	}
	public double getGovTax(){
		return this.govTax;
	}
	public void setGovTax(double newPercentage){
		this.govTax = newPercentage;
	}
	/***    PRIVATE METHODS   ***/
}
