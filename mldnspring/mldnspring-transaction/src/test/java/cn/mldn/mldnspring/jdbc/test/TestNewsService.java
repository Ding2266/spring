package cn.mldn.mldnspring.jdbc.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.mldnspring.stransaction.vo.News;
import cn.mldn.mldnspring.transaction.service.INewsService;
import junit.framework.TestCase;

@ContextConfiguration(locations= {"classpath:spring/spring-*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestNewsService extends TestCase {
	@Resource
	private INewsService newsService ; 
	@Test
	public void testAdd() {
		News vo = new News() ; 
		vo.setTitle("中国");
		vo.setNote("中国梦");
		vo.setPubdate(new Date());
		vo.setPrice(999.99);
		vo.setReadcount(900);
		TestCase.assertTrue(this.newsService.add(vo));
	}
	@Test
	public void get(long nid) {
		News vo = newsService.get(nid) ; 
		System.err.println(vo);
		TestCase.assertNotNull(vo);
	}
}
