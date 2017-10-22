package cn.mldn.mldnspring.springmvc.action;



import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller  //所有需要被Spring管理的程序类一定要进行配置
@RequestMapping("/pages/photo/*")
public class UploadAction { //定义一个自己的处理程序类
	private Logger log = LoggerFactory.getLogger(UploadAction.class) ; 
	
	@RequestMapping("upload_pre")
	public String uploadPre() {
		return "photo/photo_input" ; 
	}
	
	@RequestMapping("/upload")  //以后的访问路径就是“echo.action”
	public ModelAndView echo(String msg ,MultipartFile photo) throws Exception{//photo你的表单名称
		this.log.info("**** EchoAction接收到请求参数，msg = " + msg);
		//ModelAndView主要功能是设置跳转路径及进行request属性的保存
		if(photo == null || photo.isEmpty()) {
			System.out.println("没有上传文件的信息");
		}else { //现在有上传文件
			System.out.println("【上传文件大小】" + photo.getSize());
			System.out.println("【上传文件MIME】" + photo.getContentType());
			System.out.println("【原始文件名称】" + photo.getOriginalFilename());
			String fileExt = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".")) ; 
			String filePath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/upload/") + 
					UUID.randomUUID() + fileExt ; 
			System.out.println(fileExt);
			System.out.println(filePath);
			photo.transferTo(new File(filePath));
		}
		return null ; 
	}
}
