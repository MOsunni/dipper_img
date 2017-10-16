package entity;

/**
 * 图片的类别
 * @author 46098
 */
public class Img_type {
	
	private int img_type_id;
	
	private String img_type_name;
	
	/**
	 * level主要是分类是图片还是设计还是网页
	 * img-图片 1
	 * design-设计 1
	 * web-网页页面 1
	 * img-有人像、景色等八个分类 11
	 */
	private int img_type_levle;
	
	private String img_type_note;
	
	public Img_type(){}

	public int getImg_type_id() {
		return img_type_id;
	}

	public void setImg_type_id(int img_type_id) {
		this.img_type_id = img_type_id;
	}

	public String getImg_type_name() {
		return img_type_name;
	}

	public void setImg_type_name(String img_type_name) {
		this.img_type_name = img_type_name;
	}

	public int getImg_type_levle() {
		return img_type_levle;
	}

	public void setImg_type_levle(int img_type_levle) {
		this.img_type_levle = img_type_levle;
	}

	public String getImg_type_note() {
		return img_type_note;
	}

	public void setImg_type_note(String img_type_note) {
		this.img_type_note = img_type_note;
	};
	
}
