package model.bean;

public class Account {
	private String userName;
	private String passWord;
	private boolean decen;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(String userName, String passWord, boolean decen) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.decen = decen;
	}

	public Account(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	public boolean isDecen() {
		return decen;
	}

	public void setDecen(boolean decen) {
		this.decen = decen;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return userName + ", " + passWord;
	}  
	
	
}
