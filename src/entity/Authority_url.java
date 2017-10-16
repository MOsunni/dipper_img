package entity;

/**
 * 权限uri
 * 主要是对应此管理员没有权限访问的uri
 * @author 46098
 */
public class Authority_url {
	private int authority_url_id;
	//uri地址
	private String authority_url;
	//备注
	private String authority_note;
	
	public Authority_url() {}

	public int getAuthority_url_id() {
		return authority_url_id;
	}

	public void setAuthority_url_id(int authority_url_id) {
		this.authority_url_id = authority_url_id;
	}

	public String getAuthority_url() {
		return authority_url;
	}

	public void setAuthority_url(String authority_url) {
		this.authority_url = authority_url;
	}

	public String getAuthority_note() {
		return authority_note;
	}

	public void setAuthority_note(String authority_note) {
		this.authority_note = authority_note;
	}
}
