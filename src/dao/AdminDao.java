package dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import entity.Admin_action;
import entity.Admin_im;
import entity.Authority_admin;
import entity.Authority_url;

/**
 * ���ڹ���Ա��CURD����
 * @author 46098
 */
@Repository
public class AdminDao{
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	/**
	 * ��ѯ���й���Ա��Ϣ����������ԱȨ�ޣ�
	 * @return
	 * @throws Exception
	 */
	public List<Admin_im> findAllAdmin() throws Exception{
		return sqlSessionTemplate.selectList(this.getClass().getName() + ".selectAllAdmin");
	}
	
	public Admin_im selectAdminById(int admin_id) throws Exception{
		return sqlSessionTemplate.selectOne(this.getClass().getName() + ".selectAdminById", admin_id);
	}
	
	/**
	 * ��ѯ���ֹ���Ա
	 * @throws Exception
	 */
	public List<Admin_im> selectByName(String admin_name) throws Exception{
		return sqlSessionTemplate.selectList(this.getClass().getName() + ".selectByName",admin_name);
	}
	
	/**
	 * ��̨����Ա��½��֤
	 * @param username �û���
	 * @param password ����
	 * @return
	 * @throws Exception
	 */
	public Admin_im selectByNamePassword(String username,String password) throws Exception{
			Map<String,Object> map = new LinkedHashMap<String,Object>();
			map.put("username", username);
			map.put("password", password);
			return sqlSessionTemplate.selectOne(this.getClass().getName() + ".selectByNamePassword",map);
	}
	
	/**
	 * ��ѯ���еĹ���ԱȨ��
	 * @return
	 * @throws Exception
	 */
	public List<Admin_action> selectAllAction() throws Exception{
		
		return sqlSessionTemplate.selectList(this.getClass().getName() + ".selectAllAction");
	}
	
	/**
	 * ����id��Ȩ��
	 * @return
	 * @throws Exception
	 */
	public Admin_action selectActionById(int admin_action_id) throws Exception{
		
		return sqlSessionTemplate.selectOne(this.getClass().getName() + ".selectActionById",admin_action_id);
	}
	
	/**
	 * insert AdminԪ��
	 * @param admin_im
	 * @throws Exception
	 */
	public void insert(Admin_im admin_im) throws Exception{
		
		sqlSessionTemplate.insert(this.getClass().getName() + ".insert",admin_im);
	}
	
	/**
	 * admin_im���²���
	 * @param admin_im
	 * @throws Exception
	 */
	public void update(Admin_im admin_im) throws Exception{
		sqlSessionTemplate.update(this.getClass().getName() + ".update",admin_im);
	}
	
	/**
	 * admin_imɾ������
	 * @param admin_im��id
	 * @throws Exception
	 */
	public void delete(int id) throws Exception{
		sqlSessionTemplate.delete(this.getClass().getName() + ".delete",id);
	}
	
	/**
	 * ��ѯ������ҪȨ�޲��ܷ��ʵ�uri
	 * @throws Exception
	 */
	public List<Authority_url> selectAllAuthority_url() throws Exception{
		return sqlSessionTemplate.selectList(this.getClass().getName() + ".selectAllAuthority_url");
	}
	
	/**
	 * ���ݲ�ѯ�õ���action��id���Ҵ�id�����ж�Ӧ���е�����
	 * @throws Exception
	 */
	public List<Authority_admin> selectAuthority_adminByAdmin_action_id(int admin_action_id) throws Exception{
		return sqlSessionTemplate.selectList(this.getClass().getName() + ".selectAuthority_adminByAdmin_action_id",admin_action_id);
	}
	
	/**
	 * ���ݲ�ѯ�õ��Ķ��  ��Ӧ���id ���Ҵ�id�Ķ�Ӧuri
	 * @throws Exception
	 */
	public Authority_url selectAuthority_url(int authority_url_id) throws Exception{
		return sqlSessionTemplate.selectOne(this.getClass().getName() + ".selectAuthority_url",authority_url_id);
	}
}
