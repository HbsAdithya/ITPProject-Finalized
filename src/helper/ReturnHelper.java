package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ReturnTransaction;

public class ReturnHelper {

	private static String sql = null;
	private static ResultSet res = null;
	private static PreparedStatement ps = null;

	public ReturnHelper() {
	}

	// Adding new SingleSale Record
	public static boolean addSingleReturn(ReturnTransaction return1) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "INSERT INTO returnproduct (id, customer_name, product, quantity, amount,total) VALUES (?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);

			ps.setInt(1, return1.getReturn_id());
			ps.setString(2, return1.getName());
			ps.setString(3, return1.getProduct());
			ps.setInt(4, return1.getQuantity());
			ps.setDouble(5, return1.getAmount());
			double tot = return1.getQuantity() * return1.getAmount();
			ps.setDouble(6, tot);

			int query = ps.executeUpdate();

			if (query == 1) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}
	public static ArrayList<ReturnTransaction> displayAllreturns() throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT product, quantity, amount FROM returnproduct";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();

			ArrayList<ReturnTransaction> retArrayList = new ArrayList<ReturnTransaction>();

			while (res.next()) {

				ReturnTransaction ret = new ReturnTransaction();

				ret.setProduct(res.getString("product"));
				ret.setQuantity(res.getInt("quantity"));
				ret.setAmount(res.getDouble("amount"));

				retArrayList.add(ret);
			}

			return retArrayList;

		}

		return null;
	}
	public static double grossTotal(ReturnTransaction sales) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT SUM(total) FROM returnproduct;";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			res.first();
			double gross = res.getDouble("SUM(total)");

			return gross;
		}
		return 0;
	}

	public static int itemcount(ReturnTransaction sales) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT COUNT(id) FROM returnproduct;";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			res.first();
			int count = res.getInt("Count(id)");

			return count;
		}
		return 0;
	}
	/*
	 * // Updating existing member record public static boolean
	 * updateMember(SalesTransaction sales) throws SQLException,
	 * ClassNotFoundException {
	 * 
	 * if (DBHelper.getInstance() != null) {
	 * 
	 * Connection con = DBHelper.getConnection();
	 * 
	 * sql =
	 * "UPDATE delivery_saless SET NIC = ?,FName = ?, LName = ?, Email = ?, Phone = ?, Reg = ?, Ins = ?, Qualifications = ?, Choice = ?, Area = ? WHERE NIC = ?"
	 * ; ps = con.prepareStatement(sql);
	 * 
	 * ps.setString(1, sales.getsales_nic()); ps.setString(2,
	 * sales.getsales_first_name()); ps.setString(3, sales.getsales_last_name());
	 * ps.setString(4, sales.getsales_email()); ps.setString(5,
	 * sales.getPhone_number()); ps.setString(6, sales.getsales_vehicleRegNumber());
	 * ps.setString(7, sales.getsales_vehicleInsNumber()); ps.setString(8,
	 * sales.getsales_qualification()); ps.setString(9, sales.getsales_choice());
	 * ps.setString(10, sales.getsales_area()); ps.setString(11,
	 * sales.getsales_nic());
	 * 
	 * int query = ps.executeUpdate();
	 * 
	 * if (query == 1) { return true; } else { return false; } }
	 * 
	 * return false; }
	 * 
	 * // Deleting existing member record public static boolean
	 * deleteMember(SalesTransaction sales) throws SQLException,
	 * ClassNotFoundException {
	 * 
	 * if (DBHelper.getInstance() != null) {
	 * 
	 * Connection con = DBHelper.getConnection();
	 * 
	 * sql = "DELETE FROM delivery_saless WHERE NIC= ?"; ps =
	 * con.prepareStatement(sql); ps.setString(1, sales.getsales_nic()); int query =
	 * ps.executeUpdate();
	 * 
	 * if (query == 1) { return true; } else { return false; } }
	 * 
	 * return false; }
	 */

	// Displaying all member records
	/*public static ArrayList<SalesTransaction> displayAllsales() throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT prodID, prodName, Qty, Price, Amt FROM salesaddprod";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();

			ArrayList<SalesTransaction> salesArrayList = new ArrayList<SalesTransaction>();

			while (res.next()) {

				SalesTransaction sales = new SalesTransaction();

				sales.setProdID(res.getString("prodID"));
				sales.setProdName(res.getString("prodName"));
				sales.setQty(res.getInt("Qty"));
				sales.setPrice(res.getDouble("Price"));
				sales.setTotal(res.getDouble("Amt"));

				salesArrayList.add(sales);
			}

			return salesArrayList;

		}

		return null;
	}

	public static double grossTotal(SalesTransaction sales) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT SUM(Amt) FROM salesaddprod;";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();

			double gross = res.getDouble("SUM(Amt)");

			return gross;
		}
		return 0;
	}/*

	// Displaying single member record
	public static ArrayList<SalesTransaction> displaysales(SalesTransaction daObj) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT * FROM delivery_saless WHERE NIC = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, daObj.getsales_nic());
			res = ps.executeQuery();

			ArrayList<SalesTransaction> salesArrayList = new ArrayList<SalesTransaction>();

			while (res.next()) {

				SalesTransaction sales = new SalesTransaction();

				sales.setsales_nic(res.getString("NIC"));
				sales.setsales_first_name(res.getString("FName"));
				sales.setsales_last_name(res.getString("LName"));
				sales.setsales_email(res.getString("Email"));
				sales.setPhone_number(res.getString("Phone"));
				sales.setsales_vehicleRegNumber(res.getString("Reg"));
				sales.setsales_vehicleInsNumber(res.getString("Ins"));
				sales.setsales_qualification(res.getString("Qualifications"));
				sales.setsales_choice(res.getString("Choice"));
				sales.setsales_area(res.getString("Area"));

				salesArrayList.add(sales);
			}

			return salesArrayList;
		}

		return null;
	}*/
}
