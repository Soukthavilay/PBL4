package model.bean;

public class Gate {
	private int idGate;
	private String nameGate;
	private int idTypeGate;
	private boolean status;
	
	
	public Gate() {
		// TODO Auto-generated constructor stub
	}


	public Gate(int idGate, String nameGate, int idTypeGate, boolean status) {
		super();
		this.idGate = idGate;
		this.nameGate = nameGate;
		this.idTypeGate = idTypeGate;
		this.status = status;
	}


	public int getIdGate() {
		return idGate;
	}


	public void setIdGate(int idGate) {
		this.idGate = idGate;
	}


	public String getNameGate() {
		return nameGate;
	}


	public void setNameGate(String nameGate) {
		this.nameGate = nameGate;
	}


	public int getIdTypeGate() {
		return idTypeGate;
	}


	public void setIdTypeGate(int idTypeGate) {
		this.idTypeGate = idTypeGate;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Gate [idGate=" + idGate + ", nameGate=" + nameGate + ", idTypeGate=" + idTypeGate + ", status=" + status
				+ "]";
	}
	
}
