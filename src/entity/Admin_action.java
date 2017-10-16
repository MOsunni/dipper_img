package entity;

/**
 * 管理员权限实体类
 * @author 46098
 */
public class Admin_action {
	private int admin_action_id;
	//权限名称
	private String admin_action_name;
	//权限备注
	private String admin_action_note;
	public Admin_action(){}
	public Admin_action(int admin_action_id,String admin_action_name,String admin_action_note){
		this.admin_action_id = admin_action_id;
		this.admin_action_name = admin_action_name;
		this.admin_action_note = admin_action_note;
	}
	public int getAdmin_action_id() {
		return admin_action_id;
	}
	public void setAdmin_action_id(int admin_action_id) {
		this.admin_action_id = admin_action_id;
	}
	public String getAdmin_action_name() {
		return admin_action_name;
	}
	public void setAdmin_action_name(String admin_action_name) {
		this.admin_action_name = admin_action_name;
	}
	public String getAdmin_action_note() {
		return admin_action_note;
	}
	public void setAdmin_action_note(String admin_action_note) {
		this.admin_action_note = admin_action_note;
	}
}
