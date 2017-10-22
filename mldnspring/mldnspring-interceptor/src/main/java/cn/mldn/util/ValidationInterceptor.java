package cn.mldn.util;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import cn.mldn.util.validate.ActionValidationUtil;

//由于所有的抽象方法都是用了default关键字，那么此时不会再默认实现若干个抽象方法
public class ValidationInterceptor implements HandlerInterceptor {	
	private Logger logger = LoggerFactory.getLogger(ValidationInterceptor.class) ; 
	@Resource
	private MessageSource messageSource ; 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod)handler ;
			//本次的设计是没有考虑到重名类定义情况，因为实际的开发之中，如果要处理某一个信息有可能是由后台或前台。
			String validationRuleKey = handlerMethod.getBeanType().getSimpleName() + "." + handlerMethod.getMethod().getName() ; 
			String validationRule = null ; //保存要读取指定的资源key对应的验证规则
			try { //如果指定的key不存在，表示现在不需要进行验证
				validationRule = this.messageSource.getMessage(validationRuleKey, null , null) ; 
			}catch(Exception e) {}
			if(validationRule != null) { //此时有验证处理操作，则需要进行验证处理
				this.logger.info("【验证规则 -{"+request.getRequestURI()+"} 】" + validationRule);
				ActionValidationUtil avu = new ActionValidationUtil(validationRule, request, messageSource) ; 
				if(avu.getErrors().size() > 0) { //现在有错误信息
					System.out.println(avu.getErrors());
					return false ; 
				}
			}
		}
		return true ; //返回true表示放行，而如果返回了false表示不执行后续的Action或拦截器
	}
	
	
}
