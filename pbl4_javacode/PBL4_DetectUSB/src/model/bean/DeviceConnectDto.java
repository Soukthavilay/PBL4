package model.bean;

public class DeviceConnectDto {
	private int idDevice;
	private String nameDevice;
	private String nameVendor;
	private String typeDevice;
	private String typeGate;
	
	public DeviceConnectDto() {
		// TODO Auto-generated constructor stub
	}

	public DeviceConnectDto(int idDevice, String nameDevice, String nameVendor, String typeDevice, String typeGate) {
		super();
		this.idDevice = idDevice;
		this.nameDevice = nameDevice;
		this.nameVendor = nameVendor;
		this.typeDevice = typeDevice;
		this.typeGate = typeGate;
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

	public String getNameVendor() {
		return nameVendor;
	}

	public void setNameVendor(String nameVendor) {
		this.nameVendor = nameVendor;
	}

	public String getTypeDevice() {
		return typeDevice;
	}

	public void setTypeDevice(String typeDevice) {
		this.typeDevice = typeDevice;
	}

	public String getTypeGate() {
		return typeGate;
	}

	public void setTypeGate(String typeGate) {
		this.typeGate = typeGate;
	}

	@Override
	public String toString() {
		return idDevice + ", " + nameDevice + ", " + nameVendor + ", "
				+ typeDevice + ", " + typeGate;
	}
	
}
