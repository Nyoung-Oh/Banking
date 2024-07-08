package kr.ac.kopo.banking.vo;

public class AccountVO {

	private String account_num;
	private String id;
	private String account_type;
	private String account_makedate;
	private String pwd;
	private long balance;
	private String account_expired;
	
	public AccountVO() {
	}
	
	public AccountVO(String account_num, String id, String account_type, String account_makedate, String pwd,
			long balance, String account_expired) {
		super();
		this.account_num = account_num;
		this.id = id;
		this.account_type = account_type;
		this.account_makedate = account_makedate;
		this.pwd = pwd;
		this.balance = balance;
		this.account_expired = account_expired;
	}
	
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getAccount_makedate() {
		return account_makedate;
	}
	public void setAccount_makedate(String account_makedate) {
		this.account_makedate = account_makedate;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getAccount_expired() {
		return account_expired;
	}
	public void setAccount_expired(String account_expired) {
		this.account_expired = account_expired;
	}
	
	@Override
	public String toString() {
		return "AccountVO [account_num=" + account_num + ", id=" + id + ", account_type=" + account_type
				+ ", account_makedate=" + account_makedate + ", pwd=" + pwd + ", balance=" + balance
				+ ", account_expired=" + account_expired + "]";
	}
	

	
	
}
