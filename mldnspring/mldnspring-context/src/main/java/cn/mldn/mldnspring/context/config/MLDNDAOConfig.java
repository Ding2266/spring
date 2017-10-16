package cn.mldn.mldnspring.context.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.mldn.mldnspring.context.dao.IDeptDAO;
import cn.mldn.mldnspring.context.dao.impl.DeptDAOImpl;
@Configuration
public class MLDNDAOConfig {
	@Bean(name="deptDAOImpl")
	public IDeptDAO getDeptDAOInstance() {
		return new DeptDAOImpl() ; 
	}
}
