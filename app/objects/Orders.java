package objects;
import java.util.*;

// Order object
public class Orders {
	
	// Data members
	private String orderNum;
	private Supplier Supplier;
	private Date date;
	private int cost;
	
	
	// Constructor
	public Orders(String orderNum, Supplier supplier, Date date, int cost) {
		this.setCost(cost);
		this.setDate(date);
		this.setOrderNum(orderNum);
		this.setSupplier(supplier);
		
	}
	
	// Getters and setters
	
	/**
	 * @return the orderNum
	 */
	public String getOrderNum() {
		return orderNum;
	}
	/**
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
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
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}	
	
	// Print method
	public void Print() {
		System.out.println(this.getOrderNum() + "    " +this.getSupplier().getName()+ "    " +this.getDate().toString()+ "    " +this.getCost() );
	}
}
