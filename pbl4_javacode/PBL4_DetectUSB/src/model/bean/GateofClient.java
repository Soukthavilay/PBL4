package model.bean;

public class GateofClient {
	
	private int idClient;
	private int idGate;
	
	public GateofClient() {
		// TODO Auto-generated constructor stub
	}

	public GateofClient(int idClient, int idGate) {
		super();
		this.idClient = idClient;
		this.idGate = idGate;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdGate() {
		return idGate;
	}

	public void setIdGate(int idGate) {
		this.idGate = idGate;
	}

	@Override
	public String toString() {
		return "GateofClient [idClient=" + idClient + ", idGate=" + idGate + "]";
	}
	
}
