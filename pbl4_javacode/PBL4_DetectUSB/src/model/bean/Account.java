package model.bean;

public class Account {
	private String userName;
	private String passWord;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
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
