package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;

public class ProductHelper {

	private static String sql = null;
	private static ResultSet res = null;
	private static PreparedStatement ps = null;

	public ProductHelper() {}

	// Adding new product record
	public static boolean addProduct(Product product) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "INSERT INTO product(product_name, product_description, product_image, product_quantity, product_category, product_expiredate, product_generic, product_code, product_cost, product_retailprice, supplier_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, product.getProduct_name());
			ps.setString(2, product.getProduct_description());
			ps.setString(3, product.getProduct_image());
			ps.setInt(4, product.getProduct_quantity());
			ps.setString(5, product.getProduct_category());
			ps.setString(6, product.getProduct_expiredate());
			ps.setString(7, product.getProduct_generic());
			ps.setString(8, product.getProduct_code());
			ps.setDouble(9, product.getProduct_cost());
			ps.setDouble(10, product.getProduct_retailprice());
			ps.setString(11, product.getSupplier_name());
			
			int query = ps.executeUpdate();

			if (query == 1) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	// Updating existing product record
	public static boolean updateProduct(Product product) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "UPDATE product SET product_name=?, product_description=?, product_image=?, product_quantity=?, product_category=?, product_expiredate=?, product_generic=?, product_code=?, product_cost=?, product_retailprice=?, supplier_name=?  WHERE product_id=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, product.getProduct_name());
			ps.setString(2, product.getProduct_description());
			ps.setString(3, product.getProduct_image());
			ps.setInt(4, product.getProduct_quantity());
			ps.setString(5, product.getProduct_category());
			ps.setString(6, product.getProduct_expiredate());
			ps.setString(7, product.getProduct_generic());
			ps.setString(8, product.getProduct_code());
			ps.setDouble(9, product.getProduct_cost());
			ps.setDouble(10, product.getProduct_retailprice());
			ps.setString(11, product.getSupplier_name());
			ps.setInt(12, product.getProduct_id());
			
			int query = ps.executeUpdate();

			if (query == 1) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	// Deleting existing product record
	public static boolean deleteProduct(Product product) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "DELETE FROM product WHERE product_id=?";
			ps = con.prepareStatement(sql);

			ps.setInt(1, product.getProduct_id());

			int query = ps.executeUpdate();

			if (query == 1) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	// Displaying all product records
	public static ArrayList<Product> displayProducts() throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT * FROM product";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();

			ArrayList<Product> productArrayList = new ArrayList<Product>();

			while (res.next()) {

				Product product = new Product();

				product.setProduct_id(res.getInt("product_id"));
				product.setProduct_name(res.getString("product_name"));
				
				product.setProduct_description(res.getString("product_description"));
				
				product.setProduct_image(res.getString("product_image"));
				product.setProduct_quantity(res.getInt("product_quantity"));
				
				product.setProduct_category(res.getString("product_category"));
				product.setProduct_expiredate(res.getString("product_expiredate"));
				product.setProduct_generic(res.getString("product_generic"));
				product.setProduct_code(res.getString("product_code"));
				product.setProduct_cost(res.getDouble("product_cost"));
				product.setProduct_retailprice(res.getDouble("product_retailprice"));
				product.setSupplier_name(res.getString("supplier_name"));
				
				

				productArrayList.add(product);
			}

			return productArrayList;

		}

		return null;
	}
	
	// Displaying all Expired product records
	public static ArrayList<Product> displayProductsE() throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT * FROM product WHERE product_expiredate < NOW()\r\n" + 
					"ORDER BY product_expiredate ASC \r\n" + 
					"LIMIT 0,30";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();

			ArrayList<Product> productArrayList = new ArrayList<Product>();

			while (res.next()) {

				Product product = new Product();

				product.setProduct_id(res.getInt("product_id"));
				product.setProduct_name(res.getString("product_name"));
				
				product.setProduct_description(res.getString("product_description"));
				
				product.setProduct_image(res.getString("product_image"));
				product.setProduct_quantity(res.getInt("product_quantity"));
				
				product.setProduct_category(res.getString("product_category"));
				product.setProduct_expiredate(res.getString("product_expiredate"));
				product.setProduct_generic(res.getString("product_generic"));
				product.setProduct_code(res.getString("product_code"));
				product.setProduct_cost(res.getDouble("product_cost"));
				product.setProduct_retailprice(res.getDouble("product_retailprice"));
				product.setSupplier_name(res.getString("supplier_name"));
				
				productArrayList.add(product);
			}

			return productArrayList;

		}

		return null;
	}
	
	// Displaying all Nearing for Expire product records
	public static ArrayList<Product> displayProductsNearE() throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT * FROM product WHERE\r\n" + 
					"    product_expiredate > DATE(now())\r\n" + 
					"AND\r\n" + 
					"    product_expiredate <= DATE_ADD(DATE(now()), INTERVAL 8 DAY)\r\n" + 
					"ORDER BY product_expiredate ASC \r\n" + 
					"LIMIT 0,30";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();

			ArrayList<Product> productArrayList = new ArrayList<Product>();

			while (res.next()) {

				Product product = new Product();

				product.setProduct_id(res.getInt("product_id"));
				product.setProduct_name(res.getString("product_name"));
				
				product.setProduct_description(res.getString("product_description"));
				
				product.setProduct_image(res.getString("product_image"));
				product.setProduct_quantity(res.getInt("product_quantity"));
				
				product.setProduct_category(res.getString("product_category"));
				product.setProduct_expiredate(res.getString("product_expiredate"));
				product.setProduct_generic(res.getString("product_generic"));
				product.setProduct_code(res.getString("product_code"));
				product.setProduct_cost(res.getDouble("product_cost"));
				product.setProduct_retailprice(res.getDouble("product_retailprice"));
				product.setSupplier_name(res.getString("supplier_name"));
				
				productArrayList.add(product);
			}

			return productArrayList;

		}

		return null;
	}
	
	// Displaying single product record
	public static ArrayList<Product> displayProduct(Product product) throws ClassNotFoundException, SQLException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT * FROM product WHERE product_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, product.getProduct_id());
			res = ps.executeQuery();

			ArrayList<Product> productArrayList = new ArrayList<Product>();

			while (res.next()) {

				Product p = new Product();

				p.setProduct_id(res.getInt("product_id"));
				p.setProduct_name(res.getString("product_name"));
			
				p.setProduct_description(res.getString("product_description"));
				
				p.setProduct_image(res.getString("product_image"));
				p.setProduct_quantity(res.getInt("product_quantity"));
				
				p.setProduct_category(res.getString("product_category"));
				p.setProduct_expiredate(res.getString("product_expiredate"));
				p.setProduct_generic(res.getString("product_generic"));
				p.setProduct_code(res.getString("product_code"));
				p.setProduct_cost(res.getDouble("product_cost"));
				p.setProduct_retailprice(res.getDouble("product_retailprice"));
				p.setSupplier_name(res.getString("supplier_name"));
			
				

				productArrayList.add(p);
			}

			return productArrayList;
		}

		return null;
	}

}
