package helper;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.SalesTransaction;
import model.SupplierOrder;

public class SupplierOrderHelper {
	
	private static String sql=null;
	private static ResultSet res=null;
	private static PreparedStatement ps=null;
	
	public SupplierOrderHelper() {}
		
		public static boolean AddSupplierOrder(SupplierOrder supplierOrder)throws SQLException, ClassNotFoundException{
			
			if(DBHelper.getInstance() !=null) {
				
				Connection con=DBHelper.getConnection();
				
				sql="INSERT INTO supplier_products(supOrd_id,sup_name,pro_name,pro_quantity,pro_category,date_supplied,pro_cost,credit_limit) VALUES (?,?,?,?,?,?,?,?)";
				
				ps=con.prepareStatement(sql);
				
				ps.setInt(1, supplierOrder.getSupOrd_id());
				ps.setString(2, supplierOrder.getSupplier_name());
				ps.setString(3, supplierOrder.getProduct_name());
				ps.setInt(4, supplierOrder.getPro_quantity());
				ps.setString(5, supplierOrder.getPro_category());
				ps.setString(6, supplierOrder.getDate_supplied());
				ps.setInt(7, supplierOrder.getPro_cost());
				ps.setInt(8, supplierOrder.getCredit_limit());
				
				int querry=ps.executeUpdate();
				
				if(querry==1) {
					return true;
				}
				else {
					return false;
				}
			}
			return false;
		}
		
		public static boolean updateSupplierOrder(SupplierOrder supplierOrder) throws SQLException, ClassNotFoundException {

			if (DBHelper.getInstance() != null) {

				Connection con = DBHelper.getConnection();

				sql = "UPDATE supplier_products SET sup_name=?, pro_name=?, pro_quantity=?, pro_category=?, date_supplied=?, pro_cost=?, credit_limit=?   WHERE supOrd_id=?";
				ps = con.prepareStatement(sql);

				ps.setString(1, supplierOrder.getSupplier_name());
				ps.setString(2, supplierOrder.getProduct_name());
				ps.setInt(3, supplierOrder.getPro_quantity());
				ps.setString(4, supplierOrder.getPro_category());
				ps.setString(5, supplierOrder.getDate_supplied());
				ps.setInt(6, supplierOrder.getPro_cost());
				ps.setInt(7, supplierOrder.getCredit_limit());
				
				ps.setInt(8, supplierOrder.getSupOrd_id());
				

				int query = ps.executeUpdate();
				
				
				
				if (query == 1) {
			
		
					
					return true;
				} else {
					return false;
				}
			}

			return false;
		}
		
		public static boolean deleteSupplierOrder(SupplierOrder supplierOrder) throws SQLException, ClassNotFoundException {

			if (DBHelper.getInstance() != null) {

				Connection con = DBHelper.getConnection();

				sql = "DELETE FROM supplier_products WHERE supOrd_id= ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, supplierOrder.getSupOrd_id());

				int query = ps.executeUpdate();

				if (query == 1) {
					return true;
				} else {
					return false;
				}
			}

			return false;
		}
		
		public static ArrayList<SupplierOrder> displayAllSupplierOrder() throws SQLException, ClassNotFoundException {

			
            if (DBHelper.getInstance()!=null) {
				
				Connection con = DBHelper.getConnection();

				sql = "SELECT supOrd_id, sup_name, pro_name, pro_quantity, pro_category, date_supplied, pro_cost, credit_limit FROM supplier_products";
				ps = con.prepareStatement(sql);
				res = ps.executeQuery();

				ArrayList<SupplierOrder> SupplierOrderArrayList = new ArrayList<SupplierOrder>();

				

					
					
					while(res.next()) {

						SupplierOrder supplierOrder=new SupplierOrder();
						
						supplierOrder.setSupOrd_id(res.getInt("supOrd_id"));
						supplierOrder.setSupplier_name(res.getString("sup_name"));
						supplierOrder.setProduct_name(res.getString("pro_name"));
						supplierOrder.setPro_quantity(res.getInt("pro_quantity"));
						supplierOrder.setPro_category(res.getString("pro_category"));
						supplierOrder.setDate_supplied(res.getString("date_supplied"));
						
						supplierOrder.setPro_cost(res.getInt("pro_cost"));
						supplierOrder.setCredit_limit(res.getInt("credit_limit"));
						

				    SupplierOrderArrayList.add(supplierOrder);
				}

				return SupplierOrderArrayList;

			}

			return null;
		}
		
		public static ArrayList<SupplierOrder> displaySupplierOrder(SupplierOrder mObj) throws SQLException, ClassNotFoundException {

			if (DBHelper.getInstance() != null) {

				Connection con = DBHelper.getConnection();

				sql = "SELECT supOrd_id, sup_name, pro_name, pro_quantity, pro_category, date_supplied, pro_cost, credit_limit FROM supplier_products WHERE supOrd_id = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, mObj.getSupOrd_id());
				res = ps.executeQuery();

				ArrayList<SupplierOrder> SupOrderArrayList = new ArrayList<SupplierOrder>();

				while (res.next()) {

					SupplierOrder supplierOrder = new SupplierOrder();

					supplierOrder.setSupOrd_id(res.getInt("supOrd_id"));
					supplierOrder.setSupplier_name(res.getString("sup_name"));
					supplierOrder.setProduct_name(res.getString("pro_name"));
					supplierOrder.setPro_quantity(res.getInt("pro_quantity"));
					supplierOrder.setPro_category(res.getString("pro_category"));
					supplierOrder.setDate_supplied(res.getString("date_supplied"));
					supplierOrder.setPro_cost(res.getInt("pro_cost"));
					supplierOrder.setCredit_limit(res.getInt("credit_limit"));
					

					SupOrderArrayList.add(supplierOrder);
					
				}

				return SupOrderArrayList;
			}

			return null;
		}
	
}
