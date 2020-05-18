package helper;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Supplier;

public class SupplierHelper {
	
	private static String sql=null;
	private static ResultSet res=null;
	private static PreparedStatement ps=null;
	
	public SupplierHelper() {}
		
		public static boolean AddSupplier(Supplier supplier)throws SQLException, ClassNotFoundException{
			
			if(DBHelper.getInstance() !=null) {
				
				Connection con=DBHelper.getConnection();
				
				sql="INSERT INTO supplier_details(supplier_name,supplier_addrs,supplier_city,supplier_phone,supplier_email) VALUES (?,?,?,?,?)";
				
				ps=con.prepareStatement(sql);
				
				
				ps.setString(1, supplier.getSupplier_name());
				ps.setString(2, supplier.getSupplier_addr());
				ps.setString(3, supplier.getSupplier_city());
				ps.setInt(4, supplier.getSupplier_phone());
				ps.setString(5, supplier.getSupplier_email());
				
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
		
		public static boolean updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {

			if (DBHelper.getInstance() != null) {

				Connection con = DBHelper.getConnection();

				sql = "UPDATE supplier_details SET supplier_name=?, supplier_addrs=?, supplier_city=?, supplier_phone=?, supplier_email=?   WHERE supplier_id=?";
				ps = con.prepareStatement(sql);

				ps.setString(1,supplier.getSupplier_name());
				ps.setString(2, supplier.getSupplier_addr());
				ps.setString(3, supplier.getSupplier_city());
				ps.setInt(4, supplier.getSupplier_phone());
				ps.setString(5, supplier.getSupplier_email());
				ps.setInt(6, supplier.getSupplier_id());
				

				int query = ps.executeUpdate();
				
				
				
				if (query == 1) {
			
		
					
					return true;
				} else {
					return false;
				}
			}

			return false;
		}
		
		public static boolean deleteSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {

			if (DBHelper.getInstance() != null) {

				Connection con = DBHelper.getConnection();

				sql = "DELETE FROM supplier_details WHERE supplier_id= ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, supplier.getSupplier_id());

				int query = ps.executeUpdate();

				if (query == 1) {
					return true;
				} else {
					return false;
				}
			}

			return false;
		}
		
		public static ArrayList<Supplier> displayAllSuppliers() throws SQLException, ClassNotFoundException {

			
            if (DBHelper.getInstance()!=null) {
				
				Connection con = DBHelper.getConnection();

				sql = "SELECT supplier_id, supplier_name, supplier_addrs, supplier_city, supplier_phone, supplier_email FROM supplier_details";
				ps = con.prepareStatement(sql);
				res = ps.executeQuery();

				ArrayList<Supplier> SupplierArrayList = new ArrayList<Supplier>();

				

					
					
					while(res.next()) {

						Supplier supplier=new Supplier();
						
				    supplier.setSupplier_id(res.getInt("supplier_id"));
				    supplier.setSupplier_name(res.getString("supplier_name"));
				    supplier.setSupplier_addr(res.getString("supplier_addrs"));
				    supplier.setSupplier_city(res.getString("supplier_city"));
				    supplier.setSupplier_phone(res.getInt("supplier_phone"));
				    supplier.setSupplier_email(res.getString("supplier_email"));

				    SupplierArrayList.add(supplier);
				}

				return SupplierArrayList;

			}

			return null;
		}
		
		public static ArrayList<Supplier> displaySupplier(Supplier mObj) throws SQLException, ClassNotFoundException {

			if (DBHelper.getInstance() != null) {

				Connection con = DBHelper.getConnection();

				sql = "SELECT supplier_id,supplier_name,supplier_addrs,supplier_city,supplier_phone,supplier_email FROM supplier_details WHERE supplier_id = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, mObj.getSupplier_id());
				res = ps.executeQuery();

				ArrayList<Supplier> MemberArrayList = new ArrayList<Supplier>();

				while (res.next()) {

					Supplier supplier = new Supplier();

					supplier.setSupplier_id(res.getInt("supplier_id"));
					supplier.setSupplier_name(res.getString("supplier_name"));
					supplier.setSupplier_addr(res.getString("supplier_addrs"));
					supplier.setSupplier_city(res.getString("supplier_city"));
					supplier.setSupplier_phone(res.getInt("supplier_phone"));
					supplier.setSupplier_email(res.getString("supplier_email"));
					

					MemberArrayList.add(supplier);
					
				}

				return MemberArrayList;
			}

			return null;
		}
	
}
