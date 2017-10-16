package entity;

/**
 * 权限集与authority_action对应的
 * 权限与管理员级别的对应
 * @author 46098
 */
public class Authority_admin {
	private int authority_admin_id;
	
	//admin_action_id管理员级别
	private int admin_action_id;
	
	//authority_url_id不能访问的uri
	private Authority_url authority_url;
	
	private String authority_note;
	public Authority_admin(){}
	public int getAuthority_admin_id() {
		return authority_admin_id;
	}
	public void setAuthority_admin_id(int authority_admin_id) {
		this.authority_admin_id = authority_admin_id;
	}
	public Authority_url getAuthority_url() {
		return authority_url;
	}
	public void setAuthority_url(Authority_url authority_url) {
		this.authority_url = authority_url;
	}
	public String getAuthority_note() {
		return authority_note;
	}
	public void setAuthority_note(String authority_note) {
		this.authority_note = authority_note;
	}
	public int getAdmin_action_id() {
		return admin_action_id;
	}
	public void setAdmin_action_id(int admin_action_id) {
		this.admin_action_id = admin_action_id;
	}
	
}
