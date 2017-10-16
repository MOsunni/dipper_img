package action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import entity.Img;
import entity.Img_fileup;
import entity.Img_type;
import iservice.IAdminService;
import iservice.IImgService;

@Controller
@RequestMapping(value="/img")
public class ImgAction {
	@Resource
	private IImgService imgService;
	public void setImgService(IImgService imgService) {
		this.imgService = imgService;
	}
	
	/**
	 * ��ѯ����ͼƬ����
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/imgType")
	public String imgType(Model model) throws Exception{
		List<Img_type> img_typeList = imgService.selectAllImgType();
		model.addAttribute("img_typeList", img_typeList);
		return "/imgfile/add.jsp";
	}
	
	
	
	/**
	 * �ϴ�ͼƬ�ļ�
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/imgFileup")
	public String add(@RequestParam MultipartFile item_pic,String img_name,String img_time,String img_type_name, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		Date currData = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String classPath=this.getClass().getClassLoader().getResource("").getPath(); 
		//�ϴ�ͼƬ
		if(item_pic != null){
			//�洢ͼƬ������·��
			String realPath = request.getSession().getServletContext().getRealPath("img-system/photo/");
			
			String originalFilename = item_pic.getOriginalFilename();//ͼƬԭʼ����
			
			//�µ�ͼƬ����
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			//��ͼƬ
			File newFile = new File(realPath +"/"+ newFileName);
			
			System.out.println(newFile);
			//���ڴ��е�����д�����
			item_pic.transferTo(newFile);
			
			int admin_id = (int) session.getAttribute("admin_id");
			Date imgDate = sdf.parse( img_time );
			
			Img img = new Img();
			img.setImg_filename(newFileName);
			img.setImg_name(img_name);
			img.setImg_time(imgDate);
			img.setImg_fileup_id(UUID.randomUUID().toString());
			
			Img_fileup img_fileup = new Img_fileup();
			img_fileup.setImg_fileup_time(new Date());
			img_fileup.setAdmin_id(admin_id);
			
			imgService.insertImg(img, img_fileup, img_type_name);
			
		}
		return "/imgfile/fileupSuccess.jsp";
	}
	
	@RequestMapping(value="/imgFileupload")
	public String mvcFileUpload(CommonsMultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{  
        Date currData = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String classPath=this.getClass().getClassLoader().getResource("").getPath();  
//        String projectPath=classPath.substring(0, classPath.length()-"/WEB-INF/classes/".length());  
//        String projectName=projectPath.substring(projectPath.lastIndexOf("/")+1);  
//        String filePath=projectPath+fload+"/"+sdf.format(currData);  //�ļ��д��·��  
//        String relativePath="/"+projectName+fload+"/"+sdf.format(currData); //�ļ��д�����·��  
//        String fileAllPath=null;     //�ļ����·��  
//        String relativeAllPath=null;   //�ļ�������·��  
        
        //�浽���·��img-system/photo/������
        String imgPath = "/dipper_img/img-system/photo/"+sdf.format(currData) + "/";
        
        System.out.println("�ļ���ŵ��ļ������·��Ϊ----:"+imgPath);  
        
        if (!file.isEmpty()) {
        	
        	String type = file.getOriginalFilename().substring(
        	                file.getOriginalFilename().indexOf("."));// ȡ�ļ���ʽ��׺��
        	String img_id = new Img().getUUID().toString();// ȡUUID��Ϊ�ļ���
        	
//          String path = request.getSession().getServletContext()
//                           .getRealPath("/upload/" + filename);// ���λ��
        	
        	File destFile = new File(imgPath + img_id + type);
        	
        	try {
        		// FileUtils.copyInputStreamToFile()����������IO�������Զ�����������Ҫ�������ȥ�ر�IO��
        		FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
        	} catch (IOException e) {
        		e.printStackTrace();
        		return "/error.html";
        	}
        }
        return "/imgfile/imgList.jsp"; 
    }
	
	
	
//	Date currData = new Date();  
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    System.out.println(sdf.toString());
//try {
//	// 1. ������������
//	FileItemFactory factory = new DiskFileItemFactory();
//	// 2. �ļ��ϴ����Ĺ�����
//	ServletFileUpload upload = new ServletFileUpload(factory);
//	// ���ô�С���Ʋ���
//	upload.setFileSizeMax(100*1024*1024);	// �����ļ���С����
//	upload.setSizeMax(50*1024*1024);		// ���ļ���С����
//	upload.setHeaderEncoding("UTF-8");		// �������ļ����봦��
//	
//	// �ж�
//	if (upload.isMultipartContent(request)) {
//		// 3. ����������ת��Ϊlist����
//		List<FileItem> list = upload.parseRequest(request);
//		
//		System.out.println(list);
//		
//		// ����
//		for (FileItem item : list){
//			// �жϣ���ͨ�ı�����
//			if (item.isFormField()){
//				// ��ȡ����
//				String name = item.getFieldName();
//				// ��ȡֵ
//				String value = item.getString();
//				System.out.println(value);
//			} 
//			// �ļ�����
//			else {
//				/******** �ļ��ϴ� ***********/
//				// a. ��ȡ�ļ�����
//				String name = item.getName();
//				// ----�����ϴ��ļ�����������----
//				// a1. �ȵõ�Ψһ���
//				String id = UUID.randomUUID().toString();
//				// a2. ƴ���ļ���
//				name = id + "#" + name;						
//				
//				// b. �õ��ϴ�Ŀ¼
//				String basePath = "/dipper_img/img-system/photo/"+sdf.format(currData) + "/";
//				// c. ����Ҫ�ϴ����ļ�����
//				File file = new File(basePath,name);
//				// d. �ϴ�
//				item.write(file);
//				item.delete();  // ɾ���������ʱ��������ʱ�ļ�
//			}
//		}
//	}
//} catch (Exception e) {
//	e.printStackTrace();
//	return "/error.html";
//}
//
//return "/imgfile/imgList.jsp";

	
}
