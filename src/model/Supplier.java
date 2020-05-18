package model;

public class Supplier {
	
	private int supplier_id;
	private String supplier_name;
	private String supplier_addr;
	private String supplier_city;
	private String supplier_email;
	private int supplier_phone;
	
	public Supplier() {}
	
	public Supplier(int supplier_id, String supplier_name, String supplier_addr, String supplier_city,
			String supplier_email, int supplier_phone) {
		super();
		
		this.supplier_name = supplier_name;
		this.supplier_addr = supplier_addr;
		this.supplier_city = supplier_city;
		this.supplier_email = supplier_email;
		this.supplier_phone = supplier_phone;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getSupplier_addr() {
		return supplier_addr;
	}

	public void setSupplier_addr(String supplier_addr) {
		this.supplier_addr = supplier_addr;
	}

	public String getSupplier_city() {
		return supplier_city;
	}

	public void setSupplier_city(String supplier_city) {
		this.supplier_city = supplier_city;
	}

	public String getSupplier_email() {
		return supplier_email;
	}

	public void setSupplier_email(String supplier_email) {
		this.supplier_email = supplier_email;
	}

	public int getSupplier_phone(){
		return supplier_phone;
	}

	public void setSupplier_phone(int supplier_phone) {
		this.supplier_phone = supplier_phone;
	}
	
	
	
	
	
	
	

}
