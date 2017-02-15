package BL;

import java.util.*;
import DL.*;
import objects.*;

public class ShopManager {
	
	// Shop fragments
	private static ArrayList<Product> inventory;
	private static ArrayList<Orders> orders;
	private static ArrayList<Supplier> suppliers;
	private static ArrayList<SingleOrder> prodOrders;
	private static queryManager qm;
	 
	public static void DataInit() {
		qm = new queryManager();
		
		if(inventory == null) {
			inventory = qm.getProducts();
		}
		
		if(orders == null) {
			orders = qm.getOrders();
		}
		
		if(suppliers == null) {
			suppliers = qm.getSuppliers();
		}
		
		if(prodOrders == null) {
			prodOrders = qm.singleOrders();
		}
	}
	
	// Getters

	/**
	 * @return the inventory
	 */
	public static ArrayList<Product> getInventory() {
		return inventory;
	}
	
	public static String getSome() {
		return "some";
	}

	/**
	 * @return the orders
	 */
	public static ArrayList<Orders> getOrders() {
		return orders;
	}

	/**
	 * @return the suppliers
	 */
	public static ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}

	/**
	 * @return the prodOrders
	 */
	public static ArrayList<SingleOrder> getProdOrders() {
		return prodOrders;
	}
	
	public void printInventory() {
		System.out.println("Name    SupplierName    Amount    Price");
		
		//Get the most updated inventory
		inventory = qm.getProducts();
		for (Product product : this.getInventory()) {
			product.Print();
		}
	}
	
	
}
