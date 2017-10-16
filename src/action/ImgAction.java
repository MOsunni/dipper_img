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
	 * 查询所有图片分类
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
	 * 上传图片文件
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/imgFileup")
	public String add(@RequestParam MultipartFile item_pic,String img_name,String img_time,String img_type_name, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		Date currData = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String classPath=this.getClass().getClassLoader().getResource("").getPath(); 
		//上传图片
		if(item_pic != null){
			//存储图片的物理路径
			String realPath = request.getSession().getServletContext().getRealPath("img-system/photo/");
			
			String originalFilename = item_pic.getOriginalFilename();//图片原始名称
			
			//新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			//新图片
			File newFile = new File(realPath +"/"+ newFileName);
			
			System.out.println(newFile);
			//将内存中的数据写入磁盘
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
//        String filePath=projectPath+fload+"/"+sdf.format(currData);  //文件夹存放路径  
//        String relativePath="/"+projectName+fload+"/"+sdf.format(currData); //文件夹存放相对路径  
//        String fileAllPath=null;     //文件存放路径  
//        String relativeAllPath=null;   //文件存放相对路径  
        
        //存到相对路径img-system/photo/日期下
        String imgPath = "/dipper_img/img-system/photo/"+sdf.format(currData) + "/";
        
        System.out.println("文件存放的文件夹相对路径为----:"+imgPath);  
        
        if (!file.isEmpty()) {
        	
        	String type = file.getOriginalFilename().substring(
        	                file.getOriginalFilename().indexOf("."));// 取文件格式后缀名
        	String img_id = new Img().getUUID().toString();// 取UUID作为文件名
        	
//          String path = request.getSession().getServletContext()
//                           .getRealPath("/upload/" + filename);// 存放位置
        	
        	File destFile = new File(imgPath + img_id + type);
        	
        	try {
        		// FileUtils.copyInputStreamToFile()这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
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
//	// 1. 创建工厂对象
//	FileItemFactory factory = new DiskFileItemFactory();
//	// 2. 文件上传核心工具类
//	ServletFileUpload upload = new ServletFileUpload(factory);
//	// 设置大小限制参数
//	upload.setFileSizeMax(100*1024*1024);	// 单个文件大小限制
//	upload.setSizeMax(50*1024*1024);		// 总文件大小限制
//	upload.setHeaderEncoding("UTF-8");		// 对中文文件编码处理
//	
//	// 判断
//	if (upload.isMultipartContent(request)) {
//		// 3. 把请求数据转换为list集合
//		List<FileItem> list = upload.parseRequest(request);
//		
//		System.out.println(list);
//		
//		// 遍历
//		for (FileItem item : list){
//			// 判断：普通文本数据
//			if (item.isFormField()){
//				// 获取名称
//				String name = item.getFieldName();
//				// 获取值
//				String value = item.getString();
//				System.out.println(value);
//			} 
//			// 文件表单项
//			else {
//				/******** 文件上传 ***********/
//				// a. 获取文件名称
//				String name = item.getName();
//				// ----处理上传文件名重名问题----
//				// a1. 先得到唯一标记
//				String id = UUID.randomUUID().toString();
//				// a2. 拼接文件名
//				name = id + "#" + name;						
//				
//				// b. 得到上传目录
//				String basePath = "/dipper_img/img-system/photo/"+sdf.format(currData) + "/";
//				// c. 创建要上传的文件对象
//				File file = new File(basePath,name);
//				// d. 上传
//				item.write(file);
//				item.delete();  // 删除组件运行时产生的临时文件
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
