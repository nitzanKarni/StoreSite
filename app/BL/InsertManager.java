package BL;

import java.util.*;
import DL.*;
import objects.*;

public class InsertManager {
	private static DLLManager dm;
	private static queryManager qm;
	
	public int addSupplier( String name, String address, String phone ) {
		Supplier supplier = new Supplier(name, address,phone);
		if( dm == null )
			dm = new DLLManager();
		return dm.addSupplier(supplier);
	}
	
	public int addProduct( String name, String supplier, int amount, int price ) {
		if ( qm == null ) 
			qm = new queryManager();
		Supplier sup = qm.getSupplier(supplier);
		Product product = new Product(name, amount, price, sup);
		
		if( dm == null )
			dm = new DLLManager();
		
		return dm.addProduct(product);
	}
	
	public int addOrder(String orderNum, String supplier, Date date, int cost) {
		if ( qm == null ) 
			qm = new queryManager();
		Supplier sup = qm.getSupplier(supplier);
		
		Orders order = new Orders(orderNum, sup, date, cost);
		
		if( dm == null )
			dm = new DLLManager();
		
		return dm.addOrder(order);
		
	}
	
	public int addSingleOrder(String productName, int amount, String orderNum, int cost){
		if ( qm == null ) 
			qm = new queryManager();
		Orders order = qm.getOrder(orderNum);
		
		SingleOrder sngOrder = new SingleOrder(productName, amount, order, cost);
		
		if(dm == null) {
			dm = new DLLManager();
		}
		
		return dm.addOrder(sngOrder);
	}
	
	public int addProdFromOrder(SingleOrder sngOrder) {
		Product prod = new Product(sngOrder.getProductName(), 
								   sngOrder.getAmount(),
								   (int) Math.round(sngOrder.getCost() * Product.getMult()),
								   sngOrder.getOrder().getSupplier());
		if(dm == null) {
			dm = new DLLManager();
		}
		
		return dm.addProduct(prod);
	}
	
	

}
