package action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.SessionScope;

import entity.Admin_action;
import entity.Admin_im;
import iservice.IAdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminAction{
	
	@Resource
	private IAdminService adminService;
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	
	/**
	 * ��½login��֤
	 * @param username	�û���
	 * @param password	����
	 * @param session	�洢��½״̬
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login")
	public String add(String username,
			String password,
			HttpSession session) 
					throws Exception{
		Admin_im admin_im = adminService.login(username, password);
		if(admin_im == null){
			return "/noname.html";
		}else{
			List<String> urlList = adminService.selectAllUrlByAdmin_action(admin_im.getAdmin_action().getAdmin_action_id());
			System.out.println(urlList);
			int admin_id = admin_im.getAdmin_id();
			session.setAttribute("admin_id", admin_id);
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("urlList", urlList);
			
			//��Ӧ�ý��û����ڵ�Ȩ�޼��洢��session�У������ַ������Ǻܰ�ȫ��
			//session.setAttribute("authority", authority_url);
			return "/success.jsp";
		}
		
	}
	
	@RequestMapping(value="/findAllAdmin")
	public String find(Model model) throws Exception{
		List<Admin_im> Admin_imList = adminService.findAllAdmin();
		model.addAttribute("adminList", Admin_imList);
		return "/Admin/index.jsp";
	}
	
	/**
	 * ��������Ա����
	 * @param ����Ա����
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAdminByName")
	public String findByName(String username,Model model) throws Exception{
		List<Admin_im> Admin_imList = adminService.selectByName(username);
		model.addAttribute("adminList", Admin_imList);
		return "/Admin/index.jsp";
	}
	
	@RequestMapping(value="/addAdmin")
	public String addAdmin(Admin_im admin_im,int admin_action_id,Model model) throws Exception{
		Admin_action admin_action = adminService.selectActionById(admin_action_id);
		admin_im.setAdmin_action(admin_action);
		adminService.insert(admin_im);
		List<Admin_im> Admin_imList = adminService.findAllAdmin();
		model.addAttribute("adminList", Admin_imList);
		return "/Admin/index.jsp";
	}
	
	@RequestMapping(value="/selectAdminById")
	public String selectAdminById(int admin_id,Model model) throws Exception{
		Admin_im admin_im = adminService.selectAdminById(admin_id);
		model.addAttribute("admin", admin_im);
		return "/Admin/edit.jsp";
	}
	
	@RequestMapping(value="/updateAdmin")
	public String updateAdmin(Admin_im admin_im,int admin_action_id,Model model) throws Exception{
		Admin_action admin_action = adminService.selectActionById(admin_action_id);
		admin_im.setAdmin_action(admin_action);
		adminService.update(admin_im);
		List<Admin_im> Admin_imList = adminService.findAllAdmin();
		model.addAttribute("adminList", Admin_imList);
		model.addAttribute("action_id",admin_im.getAdmin_action().getAdmin_action_id());
		return "/Admin/index.jsp";
	}
}