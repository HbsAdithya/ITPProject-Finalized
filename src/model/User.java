/**
 * 
 */
package model;


public class User {
	protected int id;
	

	protected String name;
	protected String address;
	protected String prescription;
	public User(int id, String name, String address, String prescription) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.prescription = prescription;
	
		
	
	}

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPrescription() {
		return prescription;
	}



	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}


	
	
}