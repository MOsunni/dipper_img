package iservice;

import java.util.List;
import java.util.Map;

import entity.Img;
import entity.Img_filedown;
import entity.Img_fileup;
import entity.Img_type;

public interface IImgService {
	
	//上传图片：selectTypeByName + insertImg + insertFileup
	public void insertImg(Img img,Img_fileup img_fileup,String typename) throws Exception;
	
	//在下载图片的同时增加图片的  下载记录   insertFiledown
	public void ImgFiledown(Img_filedown img_filedown) throws Exception;
	
	//更改图片属性 selectTypeByName + updateImg
	public void updateImg(Img img) throws Exception;
	
	public List<Img> selectAllImgFY(Map<String,Object> map) throws Exception;
	
	//查所有图片的类别
	public List<Img_type> selectAllImgType() throws Exception;
}
