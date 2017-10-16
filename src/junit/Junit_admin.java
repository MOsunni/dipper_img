package junit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Admin_action;
import entity.Admin_im;
import entity.Authority_admin;
import entity.Authority_url;
import entity.Img_type;
import iservice.IAdminService;
import iservice.IImgService;
import service.AdminService;
import service.ImgService;

public class Junit_admin {
	
	/**
	 * 测试查询所有admin元素
	 * @return list
	 * @throws Exception
	 */
	@Test
	public void selectAllAdmin() throws Exception{
		
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
		IAdminService adminDao =(AdminService) applicationContext.getBean("adminService");
		
		List<Admin_im> adminList = adminDao.findAllAdmin();
		for(Admin_im admin_im:adminList){
			System.out.println(admin_im.getAdmin_username()+":"+admin_im.getAdmin_action().getAdmin_action_name());
		}
	}
	
	@Test
	public void selectAdminByName() throws Exception{
		
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
		IAdminService adminDao =(AdminService) applicationContext.getBean("adminService");
		
		List<Admin_im> adminList = adminDao.selectByName("d");
		for(Admin_im admin_im:adminList){
			System.out.println(admin_im.getAdmin_username()+":"+admin_im.getAdmin_action().getAdmin_action_name());
		}
	}
	
	/**
	 * 测试验证后台登陆管理员
	 * @throws Exception
	 */
	@Test
	public void selectByNamePassword() throws Exception{
		
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
		IAdminService adminDao =(AdminService) applicationContext.getBean("adminService");
		
		Admin_im admin_im = adminDao.login("root", "root");
		System.out.println(admin_im.getAdmin_id());
	}
	
	/**
	 * 测试查询所有 权限 admin_action元素
	 * @throws Exception
	 */
	@Test
	public void selectAllAction() throws Exception{
		
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
		IAdminService adminDao =(AdminService) applicationContext.getBean("adminService");
		
		List<Admin_action> admin_actionList = adminDao.selectAllAction();
		for(Admin_action admin_action : admin_actionList){
			System.out.println(admin_action.getAdmin_action_name() + ":" + admin_action.getAdmin_action_note());
		}
	}
	
	/**
	 * 测试新增admin元素
	 * @return list
	 * @throws Exception
	 */
	@Test
	public void insertAdmin() throws Exception{
		
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
		IAdminService adminDao =(AdminService) applicationContext.getBean("adminService");
		
		Admin_action admin_action = new Admin_action();
		admin_action.setAdmin_action_id(1);
		Admin_im admin_im = new Admin_im();
		admin_im.setAdmin_username("root1");
		admin_im.setAdmin_password("root1");
		admin_im.setAdmin_name("jack");
		admin_im.setAdmin_phone("13845724779");
		admin_im.setAdmin_email("111111@163.com");
		admin_im.setAdmin_action(new Admin_action(2,"admin","admin"));
		adminDao.insert(admin_im);
	}
	
	/**
	 * 测试更新admin元素
	 * @throws Exception
	 */
	@Test
	public void updateAdmin() throws Exception{
		
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
		IAdminService adminDao =(AdminService) applicationContext.getBean("adminService");
		
		Admin_action admin_action = new Admin_action();
		admin_action.setAdmin_action_id(1);
		Admin_im admin_im = new Admin_im();
		admin_im.setAdmin_id(3);
		admin_im.setAdmin_username("root3");
		admin_im.setAdmin_password("root2");
		admin_im.setAdmin_name("jack");
		admin_im.setAdmin_phone("13845724779");
		admin_im.setAdmin_email("111111@163.com");
		admin_im.setAdmin_action(new Admin_action(2,"admin","admin"));
		adminDao.update(admin_im);
	}
	
	/**
	 * 测试删除admin元素
	 * @throws Exception
	 */
	@Test
	public void deleteAdmin() throws Exception{
		
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
		IAdminService adminDao =(AdminService) applicationContext.getBean("adminService");
		
		adminDao.delete(3);
	}
	
	/**
	 * 测试查询所有uri
	 * @throws Exception
	 */
	@Test
	public void selectAllAuthority_url() throws Exception{
		
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
		IAdminService adminDao =(AdminService) applicationContext.getBean("adminService");
		
		List<Authority_url> allAuthority_urlList = adminDao.selectAllAuthority_url();
		for(Authority_url allAuthority_url:allAuthority_urlList){
			System.out.println(allAuthority_url.getAuthority_url());
		}
	}
	
	/**
	 * 测试根据action_id查询匹配的对应表
	 * @throws Exception
	 */
	@Test
	public void selectAuthority_adminByAdmin_action_id() throws Exception{
		
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
		IAdminService adminDao =(AdminService) applicationContext.getBean("adminService");
		int admin_action_id = 2;
		List<Authority_admin> authority_adminList = adminDao.selectAuthority_adminByAdmin_action_id(admin_action_id);
		for(Authority_admin authority_admin:authority_adminList){
			System.out.println(authority_admin.getAuthority_admin_id()+":"+authority_admin.getAuthority_url().getAuthority_url());
		}
	}
	
	/**
	 * 测试根据action_id查询匹配的对应表
	 * @throws Exception
	 */
	@Test
	public void selectAuthority_url() throws Exception{
		
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
		IAdminService adminDao =(AdminService) applicationContext.getBean("adminService");
		int authority_url_id = 2;
		Authority_url authority_url = adminDao.selectAuthority_url(authority_url_id);
		System.out.println(authority_url.getAuthority_url());
	}
	
	/**
	 * 测试直接返回url
	 * @throws Exception
	 */
	@Test
	public void selectAllUrlByAdmin_action() throws Exception{
		
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
		IAdminService adminDao =(AdminService) applicationContext.getBean("adminService");
//		List<String> urlList = adminDao.selectAllUrlByAdmin_action(2);
		
		Admin_im admin_im = adminDao.login("root", "root");
		int admin_action_id = admin_im.getAdmin_action().getAdmin_action_id();
		System.out.println(admin_action_id);
		List<String> urlList = adminDao.selectAllUrlByAdmin_action(admin_action_id);
		System.out.println(urlList);
	}
	
	@Test
	public void selectTypeImg() throws Exception{
		
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
		IImgService imgService =(ImgService) applicationContext.getBean("imgService");
		
		List<Img_type> imgTypeList = imgService.selectAllImgType();
		for(Img_type type:imgTypeList){
			System.out.println(type.getImg_type_name());
		}
	}
	
	@Test
	public void test11(){
		Date currData = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String classPath=this.getClass().getClassLoader().getResource("").getPath();  //绝对路径
        System.out.println("classpath:"+classPath);
        String projectPath=classPath.substring(0, classPath.length()-"/WEB-INF/classes/".length()); //项目路径截取 
        System.out.println("projectPath:"+projectPath);
        String projectName=projectPath.substring(projectPath.lastIndexOf("/")+1);  //项目名截取
        System.out.println("projectName:"+projectName);
        String filePath=projectPath+"/"+sdf.format(currData);  //文件夹存放路径  
        String relativePath="/"+projectName+"/"+sdf.format(currData); //文件夹存放相对路径  
        String fileAllPath=null;     //文件存放路径  
        String relativeAllPath=null;   //文件存放相对路径  
          
        System.out.println("文件存放的文件夹为----:"+filePath);  
        System.out.println("文件存放的文件夹相对路径为----:"+relativePath);
	}
}
