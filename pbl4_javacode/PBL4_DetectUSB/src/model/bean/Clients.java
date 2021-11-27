package model.bean;

import java.time.LocalDateTime;

public class Clients {
	private int idClient;
	private String nameClient;
	private String mailManager;
	private int idArea;
	private LocalDateTime lastTimeOnline;
	private boolean status;
	
	public Clients() {
	}
	
	public Clients(int idClient, String nameClient, String mailManager, int idArea, LocalDateTime lastTimeOnline,boolean status) {
		super();
		this.idClient = idClient;
		this.nameClient = nameClient;
		this.mailManager = mailManager;
		this.idArea = idArea;
		this.lastTimeOnline = lastTimeOnline;
		this.status = status;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getMailManager() {
		return mailManager;
	}

	public void setMailManager(String mailManager) {
		this.mailManager = mailManager;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public LocalDateTime getLastTimeOnline() {
		return lastTimeOnline;
	}

	public void setLastTimeOnline(LocalDateTime lastTimeOnline) {
		this.lastTimeOnline = lastTimeOnline;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return idClient + ", " + nameClient + ", " + mailManager
				+ ", " + idArea + ", " + lastTimeOnline + ", " + status;
	}
	
	
	
	

}
