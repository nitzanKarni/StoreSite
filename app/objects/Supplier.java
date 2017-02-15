package objects;

public class Supplier {
	
	// Data Members
	private String Name;
	private String Address;
	private String phone;
	
	
	// Generate new instance of supplier
	public Supplier(String name, String address, String phone) {
		this.setName(name);
		this.setAddress(address);
		this.setPhone(phone);
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void Print(){
		System.out.println(this.getName()+ "    " +this.getAddress()+ "    " +this.getPhone());
	}
}
