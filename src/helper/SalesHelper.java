package helper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import model.SalesTransaction;

public class SalesHelper {

	private static String sql = null;
	private static ResultSet res = null;
	private static PreparedStatement ps = null;
	

	public SalesHelper() {
	}

	// Adding new SingleSale Record
	public static boolean addSingleSale(SalesTransaction sales1) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "INSERT INTO salesaddprod (prodID, prodName, Price, Qty, Amt) VALUES (?,?,?,?,?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, sales1.getProdID());
			ps.setString(2, sales1.getProdName());
			ps.setDouble(3, sales1.getPrice());
			ps.setInt(4, sales1.getQty());
			ps.setDouble(5, sales1.getTotal());

			int query = ps.executeUpdate();

			if (query == 1) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	// Displaying all member records
	public static ArrayList<SalesTransaction> displayAllsales() throws SQLException, ClassNotFoundException {

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
	public static ArrayList<SalesTransaction> displayAlltransactions() throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();
			sql = "SELECT ID, NoofItems, GrossTotal, StaffID, PaymentMethod, Amount_Paid, Balance, cast(DateTime as time) FROM payment";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();

			ArrayList<SalesTransaction> salesArrayList = new ArrayList<SalesTransaction>();

			while (res.next()) {

				SalesTransaction sales = new SalesTransaction();

				sales.setSales_id(res.getInt("ID"));
				sales.setNoOfItems(res.getInt("NoofItems"));
				sales.setGrossTot(res.getDouble("GrossTotal"));
				sales.setStaffID(res.getString("StaffID"));
				sales.setPaymethod(res.getString("PaymentMethod"));
				sales.setAmountpayed(res.getDouble("Amount_Paid"));
				sales.setBalance(res.getDouble("Balance"));
				sales.setTime(res.getTime("cast(DateTime as time)"));

				salesArrayList.add(sales);
			}

			return salesArrayList;

		}

		return null;
	}

	public static ArrayList<SalesTransaction> displaySale(SalesTransaction stObj)
			throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT * FROM salesaddprod WHERE prodID = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, stObj.getProdID());
			res = ps.executeQuery();

			ArrayList<SalesTransaction> SalesArrayList = new ArrayList<SalesTransaction>();

			while (res.next()) {

				SalesTransaction sale = new SalesTransaction();

				sale.setProdID(res.getString(1));
				sale.setProdName(res.getString(2));
				sale.setPrice(res.getDouble(3));
				sale.setQty(res.getInt(4));

				SalesArrayList.add(sale);
			}

			return SalesArrayList;
		}

		return null;
	}

	public static double grossTotal(SalesTransaction sales) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT SUM(Amt) FROM salesaddprod;";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			res.next();
			double gross = res.getDouble("SUM(Amt)");

			return gross;
		}
		return 0;
	}
	public static double total(SalesTransaction sales) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT SUM(GrossTotal) FROM payment;";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			res.next();
			double gross = res.getDouble("SUM(GrossTotal)");

			return gross;
		}
		return 0;
	}
	public static double balance(SalesTransaction sales) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT Balance FROM payment ORDER BY ID DESC LIMIT 1";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			res.next();
			double gross = res.getDouble("Balance");

			return gross;
		}
		return 0;
	}

	public static int itemCount(SalesTransaction sales) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT COUNT(Amt) FROM salesaddprod;";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			res.next();
			int gross = res.getInt("COUNT(Amt)");

			return gross;
		}
		return 0;
	}
	
	public static int saleCount(SalesTransaction sales) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "SELECT COUNT(ID) FROM payment;";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			res.next();
			int gross = res.getInt("COUNT(ID)");

			return gross;
		}
		return 0;
	}

	public static double getTot(double gross) {
		return gross;
	}

	public static int getCount(int count) {
		return count;
	}

	public static boolean deleteSale(SalesTransaction sales) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "DELETE FROM salesaddprod";
			ps = con.prepareStatement(sql);
			int query = ps.executeUpdate();

			if (query == 1) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	public static boolean deleteRecord(SalesTransaction sales) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "DELETE FROM salesaddprod WHERE prodID = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, sales.getProdID());
			int query = ps.executeUpdate();

			if (query == 1) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	public static boolean updateMember(SalesTransaction sales) throws SQLException, ClassNotFoundException {

		if (DBHelper.getInstance() != null) {

			Connection con = DBHelper.getConnection();

			sql = "UPDATE salesaddprod SET Qty = ? WHERE prodID = ?";
			ps = con.prepareStatement(sql);

			ps.setInt(1, sales.getQty());
			int id = Integer.parseInt(sales.getProdID());
			ps.setInt(2, id);
			
			int query = ps.executeUpdate();

			if (query == 1) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	public static boolean addSale(SalesTransaction sales) throws ClassNotFoundException, SQLException {
		if (DBHelper.getInstance() != null) {
			

			Connection con = DBHelper.getConnection();

			sql = "INSERT INTO payment (NoofItems, GrossTotal, StaffID, PaymentMethod, Amount_Paid, Balance, CardType, CardNumber, Credit, CustomerID) VALUES (?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);

			ps.setInt(1, sales.getNoOfItems());
			ps.setDouble(2, sales.getGrossTot());
			ps.setString(3, sales.getStaffID());
			ps.setString(4, sales.getPaymethod());
			ps.setDouble(5, sales.getAmountpayed());
			ps.setDouble(6, sales.getBalance());
			ps.setString(7, sales.getCardtype());
			ps.setString(8, sales.getCardname());
			ps.setDouble(9, 0.0);
			ps.setString(10, sales.getCustID());

			int query = ps.executeUpdate();

			if (query == 1) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

}
