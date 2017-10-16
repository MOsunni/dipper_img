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
 * 关于管理员的CURD操作
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
	 * 查询所有管理员信息（包括管理员权限）
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
	 * 查询名字管理员
	 * @throws Exception
	 */
	public List<Admin_im> selectByName(String admin_name) throws Exception{
		return sqlSessionTemplate.selectList(this.getClass().getName() + ".selectByName",admin_name);
	}
	
	/**
	 * 后台管理员登陆验证
	 * @param username 用户名
	 * @param password 密码
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
	 * 查询所有的管理员权限
	 * @return
	 * @throws Exception
	 */
	public List<Admin_action> selectAllAction() throws Exception{
		
		return sqlSessionTemplate.selectList(this.getClass().getName() + ".selectAllAction");
	}
	
	/**
	 * 根据id查权限
	 * @return
	 * @throws Exception
	 */
	public Admin_action selectActionById(int admin_action_id) throws Exception{
		
		return sqlSessionTemplate.selectOne(this.getClass().getName() + ".selectActionById",admin_action_id);
	}
	
	/**
	 * insert Admin元素
	 * @param admin_im
	 * @throws Exception
	 */
	public void insert(Admin_im admin_im) throws Exception{
		
		sqlSessionTemplate.insert(this.getClass().getName() + ".insert",admin_im);
	}
	
	/**
	 * admin_im更新操作
	 * @param admin_im
	 * @throws Exception
	 */
	public void update(Admin_im admin_im) throws Exception{
		sqlSessionTemplate.update(this.getClass().getName() + ".update",admin_im);
	}
	
	/**
	 * admin_im删除操作
	 * @param admin_im的id
	 * @throws Exception
	 */
	public void delete(int id) throws Exception{
		sqlSessionTemplate.delete(this.getClass().getName() + ".delete",id);
	}
	
	/**
	 * 查询所有需要权限才能访问的uri
	 * @throws Exception
	 */
	public List<Authority_url> selectAllAuthority_url() throws Exception{
		return sqlSessionTemplate.selectList(this.getClass().getName() + ".selectAllAuthority_url");
	}
	
	/**
	 * 根据查询得到的action的id查找此id的所有对应表中的数据
	 * @throws Exception
	 */
	public List<Authority_admin> selectAuthority_adminByAdmin_action_id(int admin_action_id) throws Exception{
		return sqlSessionTemplate.selectList(this.getClass().getName() + ".selectAuthority_adminByAdmin_action_id",admin_action_id);
	}
	
	/**
	 * 根据查询得到的多个  对应表的id 查找此id的对应uri
	 * @throws Exception
	 */
	public Authority_url selectAuthority_url(int authority_url_id) throws Exception{
		return sqlSessionTemplate.selectOne(this.getClass().getName() + ".selectAuthority_url",authority_url_id);
	}
}
