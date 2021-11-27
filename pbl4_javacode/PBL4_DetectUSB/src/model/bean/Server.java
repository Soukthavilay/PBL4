package model.bean;

public class Server {
	private int idServer;
	private String nameServer;
	private String mailServer;
	private boolean status;
	
	public Server() {
		// TODO Auto-generated constructor stub
	}

	public int getIdServer() {
		return idServer;
	}

	public void setIdServer(int idServer) {
		this.idServer = idServer;
	}

	public String getNameServer() {
		return nameServer;
	}

	public void setNameServer(String nameServer) {
		this.nameServer = nameServer;
	}

	public String getMailServer() {
		return mailServer;
	}

	public void setMailServer(String mailServer) {
		this.mailServer = mailServer;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Server(int idServer, String nameServer, String mailServer, boolean status) {
		super();
		this.idServer = idServer;
		this.nameServer = nameServer;
		this.mailServer = mailServer;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Server [idServer=" + idServer + ", nameServer=" + nameServer + ", mailServer=" + mailServer
				+ ", status=" + status + "]";
	}
	
	
	
}
