package model.bean;

public class Area {
	private int idArea;
	private String nameArea;
	private String descript;
	
	public Area() {
		// TODO Auto-generated constructor stub
	}

	public Area(int idArea, String nameArea, String descript) {
		super();
		this.idArea = idArea;
		this.nameArea = nameArea;
		this.descript = descript;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getNameArea() {
		return nameArea;
	}

	public void setNameArea(String nameArea) {
		this.nameArea = nameArea;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	@Override
	public String toString() {
		return "Area [idArea=" + idArea + ", nameArea=" + nameArea + ", descript=" + descript + "]";
	}
	
}
