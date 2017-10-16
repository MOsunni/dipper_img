package junit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Img;
import entity.Img_fileup;
import iservice.IImgService;
import service.ImgService;

public class Junit_img {
	
	/**
	 * 测试查询所有admin元素
	 * @return list
	 * @throws Exception
	 */
	@Test
	public void Insert() throws Exception{
		
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
		IImgService imgService = (ImgService) applicationContext.getBean("imgService");
		
		String typename = "景色";
		Date img_time = new Date();
		
		Img img = new Img();
		String img_uuid = img.getUUID();
		img.setImg_id(img_uuid);
		img.setImg_name("另一个她");
		img.setImg_filename("");
		img.setImg_sizekb(10000);
		img.setImg_time(img_time);
		
		Img_fileup img_fileup = new Img_fileup();
		img_fileup.setImg_fileup_time(img_time);
		img_fileup.setAdmin_id(1);
		
		imgService.insertImg(img, img_fileup, typename);
	}
	
	@Test
	public void test() throws Exception{
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
		IImgService imgService = (ImgService) applicationContext.getBean("imgService");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", 0);
		map.put("size", 1);
		List<Img> imgList = imgService.selectAllImgFY(map);
		for(Img img:imgList){
			System.out.println(img.getImg_name());
		}
	}
	
	@Test
	public void test22() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String img_time = "2017-08-08";
		Date imgDate = sdf.parse( img_time );
		System.out.println(imgDate.toString());
	}
	
}
