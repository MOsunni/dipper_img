package service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.ImgDao;
import entity.Img;
import entity.Img_filedown;
import entity.Img_fileup;
import entity.Img_type;
import iservice.IImgService;

@Service
public class ImgService implements IImgService {
	
	@Resource
	private ImgDao imgDao;
	public void setImgDao(ImgDao imgDao) {
		this.imgDao = imgDao;
	}
	
	/**
	 * �ϴ�ͼƬ
	 * 1. selectTypeByName
	 * 2. insertImg
	 * 3. insertFileup
	 */
	@Override
	public void insertImg(Img img,Img_fileup img_fileup,String typename) throws Exception {
		//��ѯtype
		Img_type img_type = imgDao.selectTypeByName(typename);
		
		//���ϴ���¼��uuidֵ
		String fileup_uuid = img_fileup.getUUID();
		img_fileup.setImg_fileup_id(fileup_uuid);
		imgDao.insertFileup(img_fileup);
		
		//��ͼƬ��uuid��fileup idֵ
		String img_uuid = img.getUUID();
		img.setImg_id(img_uuid);
		img.setImg_fileup_id(fileup_uuid);
		img.setImg_type_id(img_type.getImg_type_id());
		
		//����ͼƬ��Ϣ
		imgDao.insertImg(img);
	}
	
	public List<Img_type> selectAllImgType() throws Exception{
		return imgDao.selectAllImgType();
	}

	@Override
	public void ImgFiledown(Img_filedown img_filedown) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateImg(Img img) throws Exception {
		// TODO Auto-generated method stub

	}
	
	public List<Img> selectAllImgFY(Map<String,Object> map) throws Exception{
		return imgDao.selectAllImgFY(map);
	}

}
