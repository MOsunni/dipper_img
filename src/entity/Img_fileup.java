package entity;

import java.util.Date;
import java.util.UUID;

/**
 * ͼƬ�ϴ�ʱ�䡢����
 * @author 46098
 */
public class Img_fileup {
	
	private String img_fileup_id;
	//�ϴ�ʱ��
	private Date img_fileup_time;
	//�ϴ��Ĺ���Ա
	private int admin_id;
	
	public Img_fileup(){}

	public String getImg_fileup_id() {
		return img_fileup_id;
	}

	public void setImg_fileup_id(String img_fileup_id) {
		this.img_fileup_id = img_fileup_id;
	}

	public Date getImg_fileup_time() {
		return img_fileup_time;
	}

	public void setImg_fileup_time(Date img_fileup_time) {
		this.img_fileup_time = img_fileup_time;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	};
	
	//��ȡһ��UUID��Ϊ�ϴ���id
	public String getUUID(){
		return UUID.randomUUID().toString();
	}
}
