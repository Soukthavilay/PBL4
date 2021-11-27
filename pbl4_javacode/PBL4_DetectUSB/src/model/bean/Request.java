package model.bean;

public class Request {
	private int idrequest;
	private String descript;
	
	public Request() {
		// TODO Auto-generated constructor stub
	}

	public Request(int idrequest, String descript) {
		super();
		this.idrequest = idrequest;
		this.descript = descript;
	}

	public int getIdrequest() {
		return idrequest;
	}

	public void setIdrequest(int idrequest) {
		this.idrequest = idrequest;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	@Override
	public String toString() {
		return "Request [idrequest=" + idrequest + ", descript=" + descript + "]";
	}
	
	
}
