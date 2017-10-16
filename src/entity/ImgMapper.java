package entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface ImgMapper {
	
	/**
	 * 图片的相关方法	IMG
	 */
	//上传图片
	public void insertImg(Img img) throws Exception;
	//在上传图片的同时增加图片的  上传记录
	public void insertFileup(Img_fileup img_fileup) throws Exception;
	//在上下载图片的同时增加图片的  下载记录
	public void insertFiledown(Img_filedown img_filedown) throws Exception;
	//更改图片属性
	public void updateImg(Img img) throws Exception;
	
	
	/**
	 * 查询IMG的方法
	 * @return IMG对象
	 * @throws Exception
	 */
	//查询图片
//	public List<Img> selectAllImg() throws Exception;
	//根据  上传时间  排序查询
//	public List<Img> selectAllImgGroupbyDate() throws Exception;
	//根据  下载量  排序查询
//	public List<Img> selectAllImgGroupbyFiledown() throws Exception;
	//查询  下载量最多  的图片(应该先查询最大值，然后在根据最大值查询，防止并列)
	public List<Img> selectImgByMaxFiledown() throws Exception;
	//根据  图片标题  查询IMG (可能有多个图片标题是相同的,,,而且此处要使用模糊查询)
	public List<Img> selectImgByName(String img_name) throws Exception;
	//根据 分类  查询图片
//	public List<Img> selectImgByType(int img_type_id) throws Exception;
	//根据  拍摄时间(day) 查询Img
	public List<Img> selectImgByDate(Date date) throws Exception;
	//根据ID查询IMG
	public Img selectImgById(String img_id) throws Exception;
	
	//分页查询   1.所有 ；2.根据时间排序； 3.根据类型;4.下载量       (动态查询)
	public List<Img> selectAllImgFY( Map<String,Integer> map ) throws Exception;
	public List<Img> selectAllImgGroupbyDateFY(Date date,int start,int size) throws Exception;
	public List<Img> selectImgByTypeFY(int img_type_id,int start,int size) throws Exception;
	public List<Img> selectAllImgGroupbyFiledownFY(int start,int size) throws Exception;
	
	
	/**
	 * 查询TYPE图片分类
	 * @return 图片分类
	 * @throws Exception
	 */
	//查询所有分类
	public List<Img_type> selectAllType(int start,int size) throws Exception;
	//查询  某一级别  的分类(图片、设计、网页，图片下的分类)
	public List<Img_type> selectAllFirstType(int img_type_level,int start,int size) throws Exception;
	//根据分类名字查询
	public Img_type selectTypeByName(String img_type_name,int start,int size) throws Exception;
	//根据id名字查询分类
	public Img_type selectTypeById(int img_type_id,int start,int size) throws Exception;
	
	
	/**
	 * 查询上传记录
	 */
	//查询所有的上传记录
//	public List<Img_fileup> selectAllFileup() throws Exception;
	//分页查询
	public List<Img_fileup> selectAllFileupFY(int start,int size) throws Exception;
	
	
	/**
	 * 查询下载记录
	 */
	//查询所有的下载记录
//	public List<Img_filedown> selectAllFiledown() throws Exception;
	//时间分页
	public List<Img_filedown> selcetFiledownByDateFY(Date date) throws Exception;
	//分页查询
	public List<Img_filedown> selectAllFiledownFY(int start,int size) throws Exception;
	
	/**
	 * 删除操作
	 */
	//删除图片
	public void deleteImg(int img_id) throws Exception;
	//清空上传记录（暂无需求，后续上线）
	//清空下载记录（暂无需求，后续上线）
	
}
