package DL;

import objects.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DLLManager {
	
	/**
	 * Adds supplier to the database
	 * 
	 * @param supplier
	 * @return success key 1- success 0 - failed
	 */
	public int addSupplier(Supplier supplier) {
		int successKey = 0;
		
		String query = "INSERT INTO suppliers SET Name = ?, Adress = ?, Phone = ?";
		DBConn conn = DBConn.getDbCon();
		
		try {
			PreparedStatement prpStmt = conn.conn.prepareStatement(query);
			prpStmt.setString(1, supplier.getName());
			prpStmt.setString(2, supplier.getAddress());
			prpStmt.setString(3, supplier.getPhone());
			successKey = prpStmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return successKey;
	}
	
	
	/**
	 * Adds product to the database
	 * 
	 * @param supplier
	 * @return success key 1- success 0 - failed
	 */
	public int addProduct(Product product) {
		int successKey = 0;
		
		String query = "INSERT INTO products SET Name = ?, Price = ?, Amount = ?, Supplier = ?";
		DBConn conn = DBConn.getDbCon();
		
		try {
			PreparedStatement prpStmt = conn.conn.prepareStatement(query);
			prpStmt.setString(1, product.getName());
			prpStmt.setInt(2, product.getPrice());
			prpStmt.setInt(3, product.getAmount());
			prpStmt.setString(4, product.getSupplier().getName());
			successKey = prpStmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return successKey;
	}
	
	/**
	 * Adds order to the database
	 * 
	 * @param supplier
	 * @return success key 1- success 0 - failed
	 */
	public int addOrder(Orders order) {
		int successKey = 0;
		
		String query = "INSERT INTO products SET Supplier = ?, Date = ?, Cost = ?, OrderNum = ?";
		DBConn conn = DBConn.getDbCon();
		
		try {
			PreparedStatement prpStmt = conn.conn.prepareStatement(query);
			prpStmt.setString(1, order.getSupplier().getName());
			prpStmt.setDate(2, (Date) order.getDate());
			prpStmt.setInt(3, order.getCost());
			prpStmt.setString(4, order.getOrderNum());
			successKey = prpStmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return successKey;
	}
	
	/**
	 * Adds single order to the database
	 * 
	 * @param supplier
	 * @return success key 1- success 0 - failed
	 */
	public int addOrder(SingleOrder order) {
		int successKey = 0;
		
		String query = "INSERT INTO products SET ProductName = ?, Amount = ?, Cost = ?, OrderNum = ?";
		DBConn conn = DBConn.getDbCon();
		
		try {
			PreparedStatement prpStmt = conn.conn.prepareStatement(query);
			prpStmt.setString(1, order.getProductName());
			prpStmt.setInt(2, order.getAmount());
			prpStmt.setInt(3, order.getCost());
			prpStmt.setString(4, order.getOrder().getOrderNum());
			successKey = prpStmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return successKey;
	}
	
	public int deleteProduct( String prodName ) {
		int successKey = 0;
		
		String query = "DELETE from products where name = ?";
		DBConn conn = DBConn.getDbCon();
		
		try {
			PreparedStatement prpStmt = conn.conn.prepareStatement(query);
			prpStmt.setString(1, prodName);
			successKey = prpStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return successKey;
	}
	
	public int deleteSupplier( String supName ) {
		int successKey = 0;
		
		String query = "DELETE from suppliers where name = ?";
		DBConn conn = DBConn.getDbCon();
		
		try {
			PreparedStatement prpStmt = conn.conn.prepareStatement(query);
			prpStmt.setString(1, supName);
			successKey = prpStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return successKey;
	}
	
	

}
