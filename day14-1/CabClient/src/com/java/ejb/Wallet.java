package com.java.ejb;

import java.io.Serializable;

public class Wallet implements Serializable{
	
	private int walletId;
	private Type walletType;
	private int userId;
	private double walletAmount;
	
	public int getWalletId() {
		return walletId;
	}
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}
	public Type getWalletType() {
		return walletType;
	}
	public void setWalletType(Type walletType) {
		this.walletType = walletType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	public double getWalletAmount() {
		return walletAmount;
	}
	public void setWalletAmount(double walletAmount) {
		this.walletAmount = walletAmount;
	}
	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", walletType=" + walletType + ", userId=" + userId + ", walletAmount="
				+ walletAmount + "]";
	}
	public Wallet(int walletId, Type walletType, int userId, int walletAmount) {
	
		this.walletId = walletId;
		this.walletType = walletType;
		this.userId = userId;
		this.walletAmount = walletAmount;
	}
	public Wallet() {
	
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
