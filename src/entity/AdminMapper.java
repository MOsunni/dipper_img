package entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
	//用户验证
	@Select("select admin_id,admin_username,admin_password from admin_im where admin_username=#{username} and admin_password=#{password}")
	public Admin_im selectByNamePassword(Map<String,Object> map);
	//查找所有管理员账户
	public List<Admin_im> selectAllAdmin();
	//查找所有管理员级别
	public List<Admin_action> selectAllAction();
	//插入管理员账户
	public void insert(Admin_im admin_im);
	//更新管理员账户
	public void update(Admin_im admin_im);
	//删除管理员账户
	public void delete(int id);
	
	//查询所有权限与管理员级别 对应表
	//用以得到所有权限uri
	public List<Authority_url> selectAllAuthority_url();
	
	//根据查询得到的action的id查找此id的所有对应表中的数据
	public List<Authority_admin> selectAuthority_adminByAdmin_action_id(int admin_action_id);
	
	//根据查询到的对应表中的id查找对应的url
	public Authority_url selectAuthority_url(int authority_admin_id);
	
	
}
