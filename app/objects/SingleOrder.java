package objects;
import java.util.*;

public class SingleOrder {
	
	// Data members
	private String productName;
	private int amount;
	private Orders order;
	private int cost;
	
	
	/**
	 * @param productName
	 * @param amount
	 * @param order
	 * 
	 * Constructor
	 */
	public SingleOrder(String productName, int amount, Orders order, int cost) {
		this.setProductName(productName);
		this.setAmount(amount);
		this.setOrder(order);
		this.setCost(cost);
	}

	// Getters and setters
	
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the order
	 */
	public Orders getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Orders order) {
		this.order = order;
	}

	/**
	 * @return the price
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param price the price to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void Print(){
		System.out.println(this.getOrder().getOrderNum()+ "    " +this.getProductName()+ "    " +this.getAmount()+ "    " +this.getCost());
	}
	
	
	
	
	
		
}

