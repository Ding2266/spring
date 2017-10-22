package cn.mldn.mldnspring.springmvc.util.action;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class AbstractAction {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ; 
		//在WEB数据绑定之中注册一个自定义的规则绑定器，该操作主要对java.util.Date类型处理，允许为空
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
	}
}
