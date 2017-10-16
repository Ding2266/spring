package cn.mldn.mldnspring.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.mldnspring.context.service.IDeptService;
import cn.mldn.mldnspring.context.vo.Dept;

@Configuration	// 表示当前的类是一个专门用于配置的实现类
public class TestDeptService {
	public static void main(String args[]) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml",
				"spring/spring-service.xml") ;  //加载所有的配置文件
		IDeptService deptService = ctx.getBean("deptService",IDeptService.class) ;
		Dept dept = new Dept() ; 
		dept.setDeptno(10L);
		dept.setDname("财务部");
		System.out.println(deptService.add(dept));
	}
}
