package model.bean;

public class Vendor {
	private int idVendor;
	private String nameVendor;
	
	public int getIdVendor() {
		return idVendor;
	}

	public void setIdVendor(int idVendor) {
		this.idVendor = idVendor;
	}

	public String getNameVendor() {
		return nameVendor;
	}

	public void setNameVendor(String nameVendor) {
		this.nameVendor = nameVendor;
	}

	public Vendor() {
		// TODO Auto-generated constructor stub
	}

	public Vendor(int idVendor, String nameVendor) {
		super();
		this.idVendor = idVendor;
		this.nameVendor = nameVendor;
	}

	@Override
	public String toString() {
		return "Vendor [idVendor=" + idVendor + ", nameVendor=" + nameVendor + "]";
	}
	
	
}
