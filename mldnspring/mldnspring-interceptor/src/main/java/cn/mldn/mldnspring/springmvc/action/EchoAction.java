package cn.mldn.mldnspring.springmvc.action;

import java.util.Arrays;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller  //所有需要被Spring管理的程序类一定要进行配置
@RequestMapping("/pages/message/*")
public class EchoAction { //定义一个自己的处理程序类
	private Logger log = LoggerFactory.getLogger(EchoAction.class) ; 
	
	@Resource
	private MessageSource messageSource ; 
	
	@RequestMapping("echo_pre")
	public String echoPro() {
		//System.out.println("【echo.input.page】" + this.messageSource.getMessage("echo.input.page", null, null));
		//System.out.println("【welcome.info】" + this.messageSource.getMessage("welcome.info", new Object [] {"dingding"}, null));
		//System.out.println("【nothing】" + this.messageSource.getMessage("nothing", null, null));
		System.out.println("A、*********{EchoAction}echoPre()");
		return "message/message_input" ; 
	}
	
	@RequestMapping("/echo")  //以后的访问路径就是“echo.action”
	public ModelAndView echo(String msg ,String tags[]) {//该参数会根据参数名称自动进行匹配
		this.log.info("**** EchoAction接收到请求参数，msg = " + msg + "、标签：" + Arrays.toString(tags));
		//ModelAndView主要功能是设置跳转路径及进行request属性的保存
		ModelAndView mav = new ModelAndView("message/message_show") ; 
		mav.addObject("echoMessage","【ECHO】msg=" + msg) ; //设置request的属性范围
		mav.addObject("echoTags",Arrays.toString(tags)) ; //设置request的属性范围
		System.out.println("B、*********{EchoAction}echo()");
		return mav ; 
	}
}
