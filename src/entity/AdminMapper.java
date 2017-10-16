package entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
	//�û���֤
	@Select("select admin_id,admin_username,admin_password from admin_im where admin_username=#{username} and admin_password=#{password}")
	public Admin_im selectByNamePassword(Map<String,Object> map);
	//�������й���Ա�˻�
	public List<Admin_im> selectAllAdmin();
	//�������й���Ա����
	public List<Admin_action> selectAllAction();
	//�������Ա�˻�
	public void insert(Admin_im admin_im);
	//���¹���Ա�˻�
	public void update(Admin_im admin_im);
	//ɾ������Ա�˻�
	public void delete(int id);
	
	//��ѯ����Ȩ�������Ա���� ��Ӧ��
	//���Եõ�����Ȩ��uri
	public List<Authority_url> selectAllAuthority_url();
	
	//���ݲ�ѯ�õ���action��id���Ҵ�id�����ж�Ӧ���е�����
	public List<Authority_admin> selectAuthority_adminByAdmin_action_id(int admin_action_id);
	
	//���ݲ�ѯ���Ķ�Ӧ���е�id���Ҷ�Ӧ��url
	public Authority_url selectAuthority_url(int authority_admin_id);
	
	
}
