package iservice;

import java.util.List;
import java.util.Map;

import entity.Img;
import entity.Img_filedown;
import entity.Img_fileup;
import entity.Img_type;

public interface IImgService {
	
	//�ϴ�ͼƬ��selectTypeByName + insertImg + insertFileup
	public void insertImg(Img img,Img_fileup img_fileup,String typename) throws Exception;
	
	//������ͼƬ��ͬʱ����ͼƬ��  ���ؼ�¼   insertFiledown
	public void ImgFiledown(Img_filedown img_filedown) throws Exception;
	
	//����ͼƬ���� selectTypeByName + updateImg
	public void updateImg(Img img) throws Exception;
	
	public List<Img> selectAllImgFY(Map<String,Object> map) throws Exception;
	
	//������ͼƬ�����
	public List<Img_type> selectAllImgType() throws Exception;
}
