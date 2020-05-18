package model;

public class SupplierOrder {
	
	private int grossTotal;
	private int countSup;
	
	private int supOrd_id;
	private String product_name;
	private String supplier_name;
	
	private int pro_quantity;
	private String pro_category;
	private String date_supplied;
	private int pro_cost;
	private int credit_limit;
	
	
	
	public SupplierOrder() {}
	
	public SupplierOrder(int grossTotal, int countSup,int supOrd_id,String product_name, String supplier_name,  int pro_quantity,
			String pro_category, String date_supplied, int pro_cost, int credit_limit) {
		super();
		this.grossTotal = grossTotal;
		this.countSup = countSup;
		this.supOrd_id=supOrd_id;
		this.product_name = product_name;
		this.supplier_name = supplier_name;
		
		this.pro_quantity = pro_quantity;
		this.pro_category = pro_category;
		this.date_supplied = date_supplied;
		this.pro_cost = pro_cost;
		this.credit_limit = credit_limit;
	}

	public int getGrossTotal() {
		return grossTotal;
	}

	public void setGrossTotal(int grossTotal) {
		this.grossTotal = grossTotal;
	}

	public int getCountSup() {
		return countSup;
	}

	public void setCountSup(int countSup) {
		this.countSup = countSup;
	}
	
	public int getSupOrd_id() {
		return supOrd_id;
	}

	public void setSupOrd_id(int supOrd_id) {
		this.supOrd_id = supOrd_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public int getPro_quantity() {
		return pro_quantity;
	}

	public void setPro_quantity(int pro_quantity) {
		this.pro_quantity = pro_quantity;
	}

	public String getPro_category() {
		return pro_category;
	}

	public void setPro_category(String pro_category) {
		this.pro_category = pro_category;
	}

	public String getDate_supplied() {
		return date_supplied;
	}

	public void setDate_supplied(String date_supplied) {
		this.date_supplied = date_supplied;
	}

	public int getPro_cost() {
		return pro_cost;
	}

	public void setPro_cost(int pro_cost) {
		this.pro_cost = pro_cost;
	}

	public int getCredit_limit() {
		return credit_limit;
	}

	public void setCredit_limit(int credit_limit) {
		this.credit_limit = credit_limit;
	}

	
	
	
	
	
	
		

}

