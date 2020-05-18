package model;

public class Product {


	private int product_id;
	private String product_name;
	private String product_description;
	private String product_image;
	private int product_quantity;
	private String product_category;
	private String product_expiredate;
	private String product_generic;
	private String product_code;
	private Double product_cost;
	private Double product_retailprice;
	private String supplier_name;

	
	// Default constructor
	public Product() {}
	
	// Overloading default constructor
	
	public Product(String product_name, String product_description, String product_image,
			int product_quantity, String product_category, String product_expiredate, String product_generic, String product_code, Double product_cost, Double product_retailprice, String supplier_name) {
		
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_image = product_image;
		this.product_quantity = product_quantity;
		this.product_category = product_category;
		this.product_expiredate = product_expiredate;
		this.product_generic = product_generic;
		this.product_code = product_code;
		this.product_cost = product_cost;
		this.product_retailprice = product_retailprice;
		this.supplier_name = supplier_name;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	
	public String getProduct_expiredate() {
		return product_expiredate;
	}

	public void setProduct_expiredate(String product_expiredate) {
		this.product_expiredate = product_expiredate;
	}
	
	public String getProduct_generic() {
		return product_generic;
	}

	public void setProduct_generic(String product_generic) {
		this.product_generic = product_generic;
	}
	
	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public Double getProduct_cost() {
		return product_cost;
	}

	public void setProduct_cost(Double product_cost) {
		this.product_cost = product_cost;
	}
	
	public Double getProduct_retailprice() {
		return product_retailprice;
	}

	public void setProduct_retailprice(Double product_retailprice) {
		this.product_retailprice = product_retailprice;
	}
	
	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}



	


}
