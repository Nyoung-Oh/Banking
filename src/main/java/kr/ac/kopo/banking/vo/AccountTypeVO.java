package kr.ac.kopo.banking.vo;

public class AccountTypeVO {
	
	private String account_type;
	private String type_name;
	private long account_interest;
	
	public AccountTypeVO() {
	}

	public AccountTypeVO(String account_type, String type_name, long account_interest) {
		super();
		this.account_type = account_type;
		this.type_name = type_name;
		this.account_interest = account_interest;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public long getAccount_interest() {
		return account_interest;
	}

	public void setAccount_interest(long account_interest) {
		this.account_interest = account_interest;
	}

	@Override
	public String toString() {
		return "AccountTypeVO [account_type=" + account_type + ", type_name=" + type_name + ", account_interest="
				+ account_interest + "]";
	}

	
}
