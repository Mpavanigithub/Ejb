package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CabBeanRemote {

	
	List<UserDetails> showUserDetailsBean() throws ClassNotFoundException, SQLException;
	List<DriverDetails> showDriverDetailsBean() throws ClassNotFoundException, SQLException;
	UserDetails searchUserDetailsBean(int userId) throws ClassNotFoundException, SQLException;
	String addBookingBean(Booking booking) throws ClassNotFoundException, SQLException;
	
	

}
