package com.java.ejb;

import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class UpdateEmployMain {
	
	public static void main(String[] args) throws NamingException, ClassNotFoundException, SQLException {
		
		
		Employ employ = new Employ();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ No   ");
		employ.setEmpno(sc.nextInt());
		System.out.println("Enter Employ Name  ");
		employ.setName(sc.next());
		System.out.println("Enter Department  ");
		employ.setDept(sc.next());
		System.out.println("Enter Designation  ");
		employ.setDesig(sc.next());
		System.out.println("Enter Basic   ");
		employ.setBasic(sc.nextInt());
		
		 EmployCrudBeanRemote service = null;
		    service = (EmployCrudBeanRemote)
		    		new InitialContext().lookup("EmployCrudBean/remote");
		    System.out.println(service.updateEmployBean(employ));
	}

}
