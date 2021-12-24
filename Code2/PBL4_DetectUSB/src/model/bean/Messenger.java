package model.bean;

import java.time.LocalDateTime;

public class Messenger {
	private int idMess;
	private int idLimit;
	private String nameClient;
	private int idServer;
	private LocalDateTime timeSend;
	private int idRequest;
	
	public Messenger() {
		// TODO Auto-generated constructor stub
	}

	public Messenger(int idMess, int idLimit, String nameClient, int idServer, LocalDateTime timeSend) {
		super();
		this.idMess = idMess;
		this.idLimit = idLimit;
		this.nameClient = nameClient;
		this.idServer = idServer;
		this.timeSend = timeSend;
	}
	
	
	
	public Messenger(int idMess, String nameClient, int idServer, LocalDateTime timeSend, int idRequest) {
		super();
		this.idMess = idMess;
		this.nameClient = nameClient;
		this.idServer = idServer;
		this.timeSend = timeSend;
		this.idRequest = idRequest;
	}

	public int getIdMess() {
		return idMess;
	}

	public void setIdMess(int idMess) {
		this.idMess = idMess;
	}

	public int getIdLimit() {
		return idLimit;
	}

	public void setIdLimit(int idLimit) {
		this.idLimit = idLimit;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public int getIdServer() {
		return idServer;
	}

	public void setIdServer(int idServer) {
		this.idServer = idServer;
	}

	public LocalDateTime getTimeSend() {
		return timeSend;
	}

	public void setTimeSend(LocalDateTime timeSend) {
		this.timeSend = timeSend;
	}

	public int getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}

	@Override
	public String toString() {
		return idMess + ", " + idLimit + ", " + nameClient + ", "
				+ idServer + ", " + timeSend + ", " + idRequest;
	}
	
}
