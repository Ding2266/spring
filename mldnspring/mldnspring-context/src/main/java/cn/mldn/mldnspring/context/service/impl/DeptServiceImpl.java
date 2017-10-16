package cn.mldn.mldnspring.context.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.mldnspring.context.dao.IDeptDAO;
import cn.mldn.mldnspring.context.service.IDeptService;
import cn.mldn.mldnspring.context.vo.Dept;
// <bean id="deptService" class="cn.mldn.mldnspring.context.service.impl.DeptServiceImpl"/>
@Service
public class DeptServiceImpl implements IDeptService {
	@Resource	// <property name="deptDAO" ref="deptDAO"/>
	private IDeptDAO deptDAO;
	public void setDeptDAO(IDeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}
	@Override
	public boolean add(Dept dept) {
		System.out.println("******** Dept业务层调用 *********");
		return this.deptDAO.doCreate(dept);
	}

}
