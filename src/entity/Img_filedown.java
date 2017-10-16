package entity;

import java.util.Date;
import java.util.UUID;

/**
 * 图片上传时间、作者
 * @author 46098
 */
public class Img_filedown {
	
	private String img_filedown_id;
	//下载时间
	private Date img_filedown_time;
	//下载的管理员
	private int user_id;
	//
	private String img_id;
	
	public String getImg_id() {
		return img_id;
	}

	public void setImg_id(String img_id) {
		this.img_id = img_id;
	}

	public Img_filedown(){}


	public String getImg_filedown_id() {
		return img_filedown_id;
	}

	public void setImg_filedown_id(String img_filedown_id) {
		this.img_filedown_id = img_filedown_id;
	}

	public Date getImg_filedown_time() {
		return img_filedown_time;
	}

	public void setImg_filedown_time(Date img_filedown_time) {
		this.img_filedown_time = img_filedown_time;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	//获取一个UUID作为上传的id
	public String getUUID(){
		return UUID.randomUUID().toString();
	}
}
