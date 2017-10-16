package cn.mldn.mldnspring.context;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.mldnspring.context.service.IDeptService;
import cn.mldn.mldnspring.context.vo.Dept;
import junit.framework.TestCase;
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"}) //进行资源文件定位
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDeptService extends TestCase{
	@Resource(name="deptServiceNew")
	private IDeptService deptService ; 
	@Test
	public void testAdd() {
		Dept dept = new Dept() ; 
		dept.setDeptno(10L);
		dept.setDname("财务部");
		TestCase.assertTrue(deptService.add(dept));
	}
}
