package model.bean;

public class Device {
	private int idDevice;
	private String nameDevice;
	private String typeDevice;
	private int idtypeGate;
	private int idvendor;
	
	public Device() {
		// TODO Auto-generated constructor stub
	}

	public Device(int idDevice, String nameDevice, String typeDevice, int idtypeGate, int idvendor) {
		super();
		this.idDevice = idDevice;
		this.nameDevice = nameDevice;
		this.typeDevice = typeDevice;
		this.idtypeGate = idtypeGate;
		this.idvendor = idvendor;
	}
	
	
	public Device(int idDevice, int idvendor) {
		super();
		this.idDevice = idDevice;
		this.idvendor = idvendor;
	}

	public int getIdDevice() {
		return idDevice;
	}

	public void setIdDevice(int idDevice) {
		this.idDevice = idDevice;
	}

	public String getNameDevice() {
		return nameDevice;
	}

	public void setNameDevice(String nameDevice) {
		this.nameDevice = nameDevice;
	}

	public String getTypeDevice() {
		return typeDevice;
	}

	public void setTypeDevice(String typeDevice) {
		this.typeDevice = typeDevice;
	}

	public int getIdtypeGate() {
		return idtypeGate;
	}

	public void setIdtypeGate(int idtypeGate) {
		this.idtypeGate = idtypeGate;
	}
	
	public int getIdvendor() {
		return idvendor;
	}
	
	public void setIdvendor(int idvendor) {
		this.idvendor = idvendor;
	}

	@Override
	public String toString() {
		return idDevice + ", " + nameDevice + ", " + typeDevice+ ", " + idtypeGate + ", " + idvendor;
	}
	
	

}
