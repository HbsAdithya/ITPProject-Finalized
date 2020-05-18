package model;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

public class SalesTransaction {
	private int sales_id;
	private int noOfItems;
	private double total;
	private String prodID;
	private int qty;
	private double grossTot;
	private double amountpayed;
	private double balance;
	private String staffID;
	private String custID;
	private String paymethod;
	private double discount;
	private String cardname;
	private String cardtype;
	private String prodName;
	private double price;
	private Date date;
	private Time time;
	
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public SalesTransaction(int noOfItems, double grossTot) {
		super();
		this.noOfItems = noOfItems;
		this.grossTot = grossTot;
	}
	public SalesTransaction() {
		// TODO Auto-generated constructor stub
	}
	public double getGrossTot() {
		return grossTot;
	}
	public void setGrossTot(double grossTot) {
		this.grossTot = grossTot;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int parseInt) {
		this.qty = parseInt;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProdID() {
		return prodID;
	}
	public void setProdID(String prodID) {
		this.prodID = prodID;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public String getCustID() {
		return custID;
	}
	public void setCustID(String custID) {
		this.custID = custID;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getSales_id() {
		return sales_id;
	}
	public void setSales_id(int sales_id) {
		this.sales_id = sales_id;
	}
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total2) {
		this.total = total2;
	}
	public double getAmountpayed() {
		return amountpayed;
	}
	public void setAmountpayed(double amountpayed) {
		this.amountpayed = amountpayed;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public Date getDate(){
		return date;
	}
	public void setDate(Date date) {
		this.date = date;	
	}
	
	
}
