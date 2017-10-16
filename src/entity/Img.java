package entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 图片的主要属性的映射
 * @author 46098
 */
public class Img {
	//由UUID生成的随机码，也将作为文件名来存储文件
	private String img_id;
	//图片的题目
	private String img_name;
	//图片的上传时的文件名，也将在下载文件时重新赋给文件
	private String img_filename;
	//文件的大小（单位kb）
	private int img_sizekb;
	//用户自己编辑的拍摄时间
	private Date img_time;
	//由于type表比较小，所以在查询图片的时候进行二次查询来查询图片的类型
	private int img_type_id;
	//关联到图片上传的状态,也用二次查询，原因同上
	private String img_fileup_id;
	
	/**
	 * 返回文件名，进行存储文件以及赋值给img_id
	 * @return UUID
	 */
	public String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	public Img(){}

	public String getImg_id() {
		return img_id;
	}

	public void setImg_id(String img_id) {
		this.img_id = img_id;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public String getImg_filename() {
		return img_filename;
	}

	public void setImg_filename(String img_filename) {
		this.img_filename = img_filename;
	}

	public int getImg_sizekb() {
		return img_sizekb;
	}

	public void setImg_sizekb(int img_sizekb) {
		this.img_sizekb = img_sizekb;
	}

	public Date getImg_time() {
		return img_time;
	}

	public void setImg_time(Date img_time) {
		this.img_time = img_time;
	}

	public int getImg_type_id() {
		return img_type_id;
	}

	public void setImg_type_id(int img_type_id) {
		this.img_type_id = img_type_id;
	}

	public String getImg_fileup_id() {
		return img_fileup_id;
	}

	public void setImg_fileup_id(String img_fileup_id) {
		this.img_fileup_id = img_fileup_id;
	}

}
