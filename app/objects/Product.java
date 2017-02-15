package objects;
import java.util.*;

public class Product {
	
	// Data Members
	private String Name;
	private int Amount;
	private int Price;
	private Supplier Supplier;
	private static final double MULTIPLIER = 2.3;
	
	/**
	 * @param name
	 * @param amount
	 * @param price
	 * @param supplier
	 * 
	 * Constructor
	 */
	public Product(String name, int amount, int price, Supplier supplier) {
		this.setAmount(amount);
		this.setName(name);
		this.setPrice(price);
		this.setSupplier(supplier);
		
	}
	
	/**
	 * @param order of a product
	 * 
	 * Constructs a product object using order object
	 */
	public Product( SingleOrder order ) {
		this.setName(order.getProductName());
		this.setSupplier(order.getOrder().getSupplier());
		this.setAmount(order.getAmount());
		this.setPrice((int)Math.round(order.getCost() * MULTIPLIER)); 
	}

	// Getters and setters
	
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return Amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		Amount = amount;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return Price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		Price = price;
	}
	/**
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return Supplier;
	}
	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		Supplier = supplier;
	}
	
	public static double getMult() {
		return MULTIPLIER;
	}
	
	public void Print() {
		System.out.println(this.getName()+ "    " +this.getSupplier().getName()+ "    " +this.getPrice()+ "    " +this.getAmount());
	}
}
