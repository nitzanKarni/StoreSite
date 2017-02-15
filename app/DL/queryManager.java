package DL;

import objects.*;
import java.sql.*;
import java.util.*;

public class queryManager {
	
	// ---------- ArrayLists of Tables -------------
	
	// Gets and array list of all suppliers from the db
	public ArrayList<Supplier> getSuppliers() {
		ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
		String query = "SELECT * FROM suppliers";
		DBConn conn = DBConn.getDbCon();
		
		try {
			ResultSet rslt = conn.query(query);
			while(rslt.next()) {
				suppliers.add(new Supplier(rslt.getString("Name"),
										   rslt.getString("Adress"),
										   rslt.getString("Phone")));
			}
		} catch ( Exception e) {
			e.printStackTrace();
		}

		
		return suppliers;
	}
	
	// Gets and array list of all orders from the db
	public ArrayList<Orders> getOrders() {
		ArrayList<Orders> orders = new ArrayList<Orders>();
		String query = "SELECT * FROM orders";
		DBConn conn = DBConn.getDbCon();
		try {
			ResultSet rslt = conn.query(query);
			while(rslt.next()) {
				orders.add(new Orders(rslt.getString("OrderNum"),
									  this.getSupplier(rslt.getString("Supplier")),
									  rslt.getDate("Date"),
									  rslt.getInt("Cost")));
			}
		} catch ( Exception e) {
			e.printStackTrace();
		} 
			
		return orders;
	}
	
	// Gets and array list of all ordersDetails from the db
	public ArrayList<SingleOrder> singleOrders() {
		ArrayList<SingleOrder> orders = new ArrayList<SingleOrder>();
		String query = "SELECT * FROM orderdetails";
		DBConn conn = DBConn.getDbCon();
		try {
			ResultSet rslt = conn.query(query);
			while(rslt.next()) {
				orders.add( new SingleOrder(rslt.getString("ProductName"),
											rslt.getInt("Amount"),
											this.getOrder(rslt.getString("OrderNum")),
											rslt.getInt("Cost")));
			}
		} catch ( Exception e) {
			e.printStackTrace();
		} 
				
		return orders;
	}
	
	// Gets and array list of all products from the db
	public ArrayList<Product> getProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		String query = "SELECT * FROM products";
		DBConn conn = DBConn.getDbCon();
		try {
			ResultSet rslt = conn.query(query);
			while(rslt.next()) {
				products.add( new Product(rslt.getString("Name"),
										  rslt.getInt("Amount"),
										  rslt.getInt("Price"),
										  this.getSupplier(rslt.getString("Supplier"))));
			}
		} catch ( Exception e) {
			e.printStackTrace();
		} 
				
		return products;
	}
	
	
	
	
	
	//------------------ Gets certain objects from db ---------------
	
	// Get certain supplier by his name
	// !! Make More Secure !!
	public Supplier getSupplier( String Name ) {
		String query = "SELECT * FROM suppliers WHERE Name = ?";
		Supplier supplier = null;
		
		// Execute the query
		DBConn conn = DBConn.getDbCon();
		try {
			PreparedStatement prpStmt = conn.conn.prepareStatement(query);
			prpStmt.setString(1, Name);
			ResultSet rslt = prpStmt.executeQuery();
			rslt.next();
			supplier = new Supplier(rslt.getString("Name"),
					   				rslt.getString("Adress"),
					   				rslt.getString("Phone"));
		} catch ( Exception e) {
			e.printStackTrace();
		}
		return supplier;
		
	}
	
	// Get certain order by his name
	// !! Make More Secure !!
	public Orders getOrder( String OrderName ) {
		String query = "SELECT * FROM orders WHERE ordernum = ?";
		Orders order = null;
			
		// Execute the query
		DBConn conn = DBConn.getDbCon();
		try {
			PreparedStatement prpStmt = conn.conn.prepareStatement(query);
			prpStmt.setString(1, OrderName);
			ResultSet rslt = prpStmt.executeQuery();
			rslt.next();
			order = new Orders(rslt.getString("OrderNum"),
					  		   this.getSupplier(rslt.getString("Supplier")),
					  		   rslt.getDate("Date"),
					  		   rslt.getInt("Cost"));
		} catch ( Exception e) {
			e.printStackTrace();
		} 
		return order;
	}
}
