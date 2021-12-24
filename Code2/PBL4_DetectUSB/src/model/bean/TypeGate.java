package model.bean;

public class TypeGate {
	
	private int idType;
	private String nameType;
	private String descript;
	
	public TypeGate() {
		// TODO Auto-generated constructor stub
	}

	public TypeGate(int idType, String nameType, String descript) {
		super();
		this.idType = idType;
		this.nameType = nameType;
		this.descript = descript;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	@Override
	public String toString() {
		return "TypeGate [idType=" + idType + ", nameType=" + nameType + ", descript=" + descript + "]";
	}
	
	
}
