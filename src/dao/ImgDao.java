package dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import entity.Img;
import entity.Img_fileup;
import entity.Img_type;

/**
 * 关于图片的CURD操作
 * @author 46098
 */
@Repository
public class ImgDao{
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	/**
	 * insert IMG元素
	 * @param img
	 * @throws Exception
	 */
	public void insertImg(Img img) throws Exception{
		sqlSessionTemplate.insert("dao.AdminDao.insertImg",img);
	}
	
	/**
	 * select img_type元素
	 * @param typename  前台在存储图片时查询选中的类别，然后存储到图片属性中
	 * @throws Exception
	 */
	public Img_type selectTypeByName(String typename) throws Exception{
		return sqlSessionTemplate.selectOne("dao.AdminDao.selectTypeByName",typename);
	}
	
	/**
	 * select 所有图片的 img_type元素
	 * @throws Exception
	 */
	public List<Img_type> selectAllImgType() throws Exception{
		return sqlSessionTemplate.selectList("dao.AdminDao.selectAllImgType");
	}
	
	/**
	 * insert 上传记录
	 * @param img_fileup
	 * @throws Exception
	 */
	//在上传图片的同时增加图片的  上传记录
	public void insertFileup(Img_fileup img_fileup) throws Exception{
		sqlSessionTemplate.insert("dao.AdminDao.insertFileup",img_fileup);
	}
	
	public List<Img> selectAllImgFY(Map<String,Object> map) throws Exception{
		return sqlSessionTemplate.selectList("dao.AdminDao.selectAllImgFY", map);
	}
	
}
