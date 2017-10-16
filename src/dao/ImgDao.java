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
 * ����ͼƬ��CURD����
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
	 * insert IMGԪ��
	 * @param img
	 * @throws Exception
	 */
	public void insertImg(Img img) throws Exception{
		sqlSessionTemplate.insert("dao.AdminDao.insertImg",img);
	}
	
	/**
	 * select img_typeԪ��
	 * @param typename  ǰ̨�ڴ洢ͼƬʱ��ѯѡ�е����Ȼ��洢��ͼƬ������
	 * @throws Exception
	 */
	public Img_type selectTypeByName(String typename) throws Exception{
		return sqlSessionTemplate.selectOne("dao.AdminDao.selectTypeByName",typename);
	}
	
	/**
	 * select ����ͼƬ�� img_typeԪ��
	 * @throws Exception
	 */
	public List<Img_type> selectAllImgType() throws Exception{
		return sqlSessionTemplate.selectList("dao.AdminDao.selectAllImgType");
	}
	
	/**
	 * insert �ϴ���¼
	 * @param img_fileup
	 * @throws Exception
	 */
	//���ϴ�ͼƬ��ͬʱ����ͼƬ��  �ϴ���¼
	public void insertFileup(Img_fileup img_fileup) throws Exception{
		sqlSessionTemplate.insert("dao.AdminDao.insertFileup",img_fileup);
	}
	
	public List<Img> selectAllImgFY(Map<String,Object> map) throws Exception{
		return sqlSessionTemplate.selectList("dao.AdminDao.selectAllImgFY", map);
	}
	
}
