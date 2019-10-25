package entity;

public class WechatAccout {

	private int id;
	private String account;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "WechatAccout [id=" + id + ", account=" + account + ", status=" + status + "]";
	}
	
	
	
}
