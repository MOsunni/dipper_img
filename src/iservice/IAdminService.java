package iservice;

import java.util.List;

import entity.Admin_action;
import entity.Admin_im;
import entity.Authority_admin;
import entity.Authority_url;

public interface IAdminService {
	//查看所有admin
	public List<Admin_im> findAllAdmin() throws Exception;
	//登陆验证
	public Admin_im login(String username,String password) throws Exception;
	//根据ID查admin
	public Admin_im selectAdminById(int admin_id) throws Exception;
	//查看所有权限
	public List<Admin_action> selectAllAction() throws Exception;
	//根据id查权限
	public Admin_action selectActionById(int admin_action_id) throws Exception;
	//新增管理员
	public void insert(Admin_im admin_im) throws Exception;
	//更新管理员
	public void update(Admin_im admin_im) throws Exception;
	//删除管理员
	public void delete(int id) throws Exception;
	//查询所有uri
	public List<Authority_url> selectAllAuthority_url() throws Exception;
	//根据查询得到的action的id查找此id的所有对应表中的数据
	public List<Authority_admin> selectAuthority_adminByAdmin_action_id(int admin_action_id) throws Exception;
	//根据查询得到的多个  对应表的id 查找此id的对应uri
	public Authority_url selectAuthority_url(int authority_url_id) throws Exception;
	//根据查询得到的action的id查找对应uri
	//上两步的集合
	public List<String> selectAllUrlByAdmin_action(int admin_action_id) throws Exception;
	
	public List<Admin_im> selectByName(String admin_name) throws Exception;
}
