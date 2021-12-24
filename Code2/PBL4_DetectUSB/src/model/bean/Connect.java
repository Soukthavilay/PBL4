package model.bean;

import java.time.LocalDateTime;

public class Connect {
	private int idGate;
	private int idDevice;
	private LocalDateTime timeStart;
	private LocalDateTime timeEnd;

	
	public Connect() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Connect(int idGate, int idDevice, LocalDateTime timeStart, LocalDateTime timeEnd) {
		super();
		this.idGate = idGate;
		this.idDevice = idDevice;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	

	public Connect(String nameClient, int idGate, int idDevice, LocalDateTime timeStart) {
		super();
		this.idGate = idGate;
		this.idDevice = idDevice;
		this.timeStart = timeStart;

	}
	

	public Connect(String nameClient, int idDevice, LocalDateTime timeStart, LocalDateTime timeEnd) {
		super();
		this.idDevice = idDevice;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}


	public int getIdGate() {
		return idGate;
	}

	public void setIdGate(int idGate) {
		this.idGate = idGate;
	}

	public int getIdDevice() {
		return idDevice;
	}

	public void setIdDevice(int idDevice) {
		this.idDevice = idDevice;
	}

	public LocalDateTime getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(LocalDateTime timeStart) {
		this.timeStart = timeStart;
	}

	public LocalDateTime getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(LocalDateTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	@Override
	public String toString() {
		return   idGate + ", " + idDevice + ", " + timeStart + ", "
				+ timeEnd;
	}

}
