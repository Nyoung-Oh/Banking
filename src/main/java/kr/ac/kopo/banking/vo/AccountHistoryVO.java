package kr.ac.kopo.banking.vo;

public class AccountHistoryVO {

	private int history_num;
	private String account_num;
	private String your_account_num;
	private long money;
	private String history_date;
	private String history_type;
	private AccountVO account;
	private String page;
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public AccountHistoryVO() {
	}
	
	public AccountHistoryVO(int history_num, String account_num, String your_account_num, long money,
			String history_date, String history_type) {
		super();
		this.history_num = history_num;
		this.account_num = account_num;
		this.your_account_num = your_account_num;
		this.money = money;
		this.history_date = history_date;
		this.history_type = history_type;
	}
	
	public AccountVO getAccount() {
		return account;
	}

	public void setAccount(AccountVO account) {
		this.account = account;
	}

	public int getHistory_num() {
		return history_num;
	}
	public void setHistory_num(int history_num) {
		this.history_num = history_num;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public String getYour_account_num() {
		return your_account_num;
	}
	public void setYour_account_num(String your_account_num) {
		this.your_account_num = your_account_num;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public String getHistory_date() {
		return history_date;
	}
	public void setHistory_date(String history_date) {
		this.history_date = history_date;
	}
	public String getHistory_type() {
		return history_type;
	}
	public void setHistory_type(String history_type) {
		this.history_type = history_type;
	}

	@Override
	public String toString() {
		return "AccountHistoryVO [history_num=" + history_num + ", account_num=" + account_num + ", your_account_num="
				+ your_account_num + ", money=" + money + ", history_date=" + history_date + ", history_type="
				+ history_type + ", account=" + account + ", page=" + page + "]";
	}
}