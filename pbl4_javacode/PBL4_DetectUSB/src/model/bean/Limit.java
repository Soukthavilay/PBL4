package model.bean;

public class Limit {
	private int idLimit;
	private int descript;
	
	
	public Limit() {
		// TODO Auto-generated constructor stub
	}


	public Limit(int idLimit, int descript) {
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


	public int getDescript() {
		return descript;
	}


	public void setDescript(int descript) {
		this.descript = descript;
	}


	@Override
	public String toString() {
		return "Limit [idLimit=" + idLimit + ", descript=" + descript + "]";
	}
	

}
