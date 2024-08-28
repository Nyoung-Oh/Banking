package kr.ac.kopo.vo;

public class AccountHistoryVO {

	private int history_num;
	private String account_num;
	private String your_account_num;
	private long money;
	private String history_date;
	private String history_type;
	private long balance;
	private String page;
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
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "AccountHistoryVO [history_num=" + history_num + ", account_num=" + account_num + ", your_account_num="
				+ your_account_num + ", money=" + money + ", history_date=" + history_date + ", history_type="
				+ history_type + ", balance=" + balance + ", page=" + page + "]";
	}
	
	
	
	
}