package com.java.ejb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CabDAO {
	

	Connection connection;
	PreparedStatement pst;
	
	
	public List<UserDetails> showUserDetails() throws ClassNotFoundException, SQLException{
		
		 List<UserDetails> userList = new ArrayList<UserDetails>();
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from UserDetails";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		UserDetails user =null;
		while(rs.next()){
			user = new UserDetails();
			user.setUserId(rs.getInt("userId"));
			user.setUserName(rs.getString("userName"));
			user.setFirstName(rs.getString("firstName"));
			user.setPassCode(rs.getString("passCode"));
			user.setCity(rs.getString("city"));
			user.setMobile(rs.getString("mobile"));
			user.setState(rs.getString("state"));
			user.seteMail(rs.getString("eMail"));
			userList.add(user);
			}
		return userList;
		}
	public UserDetails searchUserDetails(int userId) throws ClassNotFoundException, SQLException{
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from UserDetails where userId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, userId);
		ResultSet rs = pst.executeQuery();
		UserDetails user =null;
		if(rs.next()){
			
			user = new UserDetails();
			user.setUserId(rs.getInt("userId"));
			user.setUserName(rs.getString("userName"));
			user.setFirstName(rs.getString("firstName"));
			user.setPassCode(rs.getString("passCode"));
			user.setCity(rs.getString("city"));
			user.setMobile(rs.getString("mobile"));
			user.setState(rs.getString("state"));
			user.seteMail(rs.getString("eMail"));
			
			}
		return user;
			
		}
	public List<DriverDetails> showDriverDetails() throws ClassNotFoundException, SQLException{
		
		 List<DriverDetails> driverList = new ArrayList<DriverDetails>();
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from DriverDetails";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
	    DriverDetails driver =null;
		while(rs.next()){
			driver = new DriverDetails();
			driver.setDriverId(rs.getInt("driverId"));
			driver.setDriverUserName(rs.getString("driverUserName"));
			driver.setDriverFirstName(rs.getString("driverFirstName"));
			driver.setDriverLastName(rs.getString("driverLastName"));
			driver.setDriverPassword(rs.getString("driverPassword"));
			driver.setDriverCity(rs.getString("driverCity"));
			driver.setDriverMobile(rs.getString("driverMobile"));
			driver.setDriverState(rs.getString("driverState"));
			driver.setDriverEMail(rs.getString("drivereMail"));
			driver.setCabType(rs.getString("cabType"));
			driverList.add(driver);
			}
		return driverList;
}
//	
//	public Date convertDate(java.util.Date dt) {
//        java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
//        return sqlDate;
//    }
	
	public String addBooking(Booking book) 
			throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into Booking(bookingDate,driverId,userId,startingLocation,endingLocation,kilometers,bookingStatus,billAmount) "
				+ " values(?,?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setDate(1, book.getBookingDate());
		pst.setInt(2, book.getDriverId());
		pst.setInt(3, book.getUserId());
		pst.setString(4, book.getStartingLocation());
		pst.setString(5, book.getEndingLocation());
		pst.setDouble(6, book.getKilometers());
	    pst.setString(7, book.getBookingStatus().toString());
		pst.setDouble(8, book.getBillAmount());
	
		pst.executeUpdate();
		return "Booked...";
	}
}
