package iservice;

import java.util.List;

import entity.Admin_action;
import entity.Admin_im;
import entity.Authority_admin;
import entity.Authority_url;

public interface IAdminService {
	//�鿴����admin
	public List<Admin_im> findAllAdmin() throws Exception;
	//��½��֤
	public Admin_im login(String username,String password) throws Exception;
	//����ID��admin
	public Admin_im selectAdminById(int admin_id) throws Exception;
	//�鿴����Ȩ��
	public List<Admin_action> selectAllAction() throws Exception;
	//����id��Ȩ��
	public Admin_action selectActionById(int admin_action_id) throws Exception;
	//��������Ա
	public void insert(Admin_im admin_im) throws Exception;
	//���¹���Ա
	public void update(Admin_im admin_im) throws Exception;
	//ɾ������Ա
	public void delete(int id) throws Exception;
	//��ѯ����uri
	public List<Authority_url> selectAllAuthority_url() throws Exception;
	//���ݲ�ѯ�õ���action��id���Ҵ�id�����ж�Ӧ���е�����
	public List<Authority_admin> selectAuthority_adminByAdmin_action_id(int admin_action_id) throws Exception;
	//���ݲ�ѯ�õ��Ķ��  ��Ӧ���id ���Ҵ�id�Ķ�Ӧuri
	public Authority_url selectAuthority_url(int authority_url_id) throws Exception;
	//���ݲ�ѯ�õ���action��id���Ҷ�Ӧuri
	//�������ļ���
	public List<String> selectAllUrlByAdmin_action(int admin_action_id) throws Exception;
	
	public List<Admin_im> selectByName(String admin_name) throws Exception;
}
