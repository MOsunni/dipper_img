package entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * ͼƬ����Ҫ���Ե�ӳ��
 * @author 46098
 */
public class Img {
	//��UUID���ɵ�����룬Ҳ����Ϊ�ļ������洢�ļ�
	private String img_id;
	//ͼƬ����Ŀ
	private String img_name;
	//ͼƬ���ϴ�ʱ���ļ�����Ҳ���������ļ�ʱ���¸����ļ�
	private String img_filename;
	//�ļ��Ĵ�С����λkb��
	private int img_sizekb;
	//�û��Լ��༭������ʱ��
	private Date img_time;
	//����type��Ƚ�С�������ڲ�ѯͼƬ��ʱ����ж��β�ѯ����ѯͼƬ������
	private int img_type_id;
	//������ͼƬ�ϴ���״̬,Ҳ�ö��β�ѯ��ԭ��ͬ��
	private String img_fileup_id;
	
	/**
	 * �����ļ��������д洢�ļ��Լ���ֵ��img_id
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
