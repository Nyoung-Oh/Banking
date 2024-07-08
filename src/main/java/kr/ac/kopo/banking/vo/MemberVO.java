package kr.ac.kopo.banking.vo;

public class MemberVO {

	private String id;
	private String pwd;
	private String name;
	private String personal_num;
	private String join_date;
	private String hp;
	
	public MemberVO() {
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", personal_num=" + personal_num
				+ ", join_date=" + join_date + ", hp=" + hp + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonal_num() {
		return personal_num;
	}
	public void setPersonal_num(String personal_num) {
		this.personal_num = personal_num;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	
	public MemberVO(String id, String pwd, String name, String personal_num, String join_date, String hp) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.personal_num = personal_num;
		this.join_date = join_date;
		this.hp = hp;
	}
}
