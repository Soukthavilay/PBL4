package model.bean;

public class Limit {
	private int idLimit;
	private String descript;
	
	
	public Limit() {
		// TODO Auto-generated constructor stub
	}


	public Limit(int idLimit, String descript) {
		super();
		this.idLimit = idLimit;
		this.descript = descript;
	}


	public int getIdLimit() {
		return idLimit;
	}


	public void setIdLimit(int idLimit) {
		this.idLimit = idLimit;
	}


	public String getDescript() {
		return descript;
	}


	public void setDescript(String descript) {
		this.descript = descript;
	}


	@Override
	public String toString() {
		return "Limit [idLimit=" + idLimit + ", descript=" + descript + "]";
	}
	

}
