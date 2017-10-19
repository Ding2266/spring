package cn.mldn.mldnspring.transaction.service.impl;

import javax.annotation.Resource;

import org.omg.CORBA.TRANSACTION_REQUIRED;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import cn.mldn.mldnspring.stransaction.vo.News;
import cn.mldn.mldnspring.transaction.dao.INewsDAO;
import cn.mldn.mldnspring.transaction.service.INewsService;
@Service
public class NewsServiceImpl implements INewsService {
	@Resource  //可以注入的知识一个接口的实例化对象，但是这些对象还需要配置隔离级别、传播属性
	private PlatformTransactionManager transactionManaget ; 
	@Resource
	private INewsDAO newsDAO ; 
	@Override
	public boolean add(News vo) {
		boolean flag = false ; 
		//TransactionDefinition通过此类设置传播属性、隔离级别、是否为只读、超时访问
		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition() ; 
		//设置传播属性，表示必须有一个事务启动
		transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED) ;
		//隔离级别一定要使用默认的隔离级别进行控制
		transactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
		//获取事务的提交状态
		TransactionStatus transactionStatus = this.transactionManaget.getTransaction(transactionDefinition) ; 
		try {
			flag = this.newsDAO.doCreate(vo) ; 
			this.transactionManaget.commit(transactionStatus); //提交事务
		}catch(Exception e) {
			this.transactionManaget.rollback(transactionStatus);  //出现问题回滚到指定的提交点
		}
		return flag;
	}

	@Override
	public News get(long nid) {
		 News vo = null  ;
		//TransactionDefinition通过此类设置传播属性、隔离级别、是否为只读、超时访问
		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition() ; 
		//设置传播属性，表示必须有一个事务启动
		transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED) ;
		//隔离级别一定要使用默认的隔离级别进行控制
		transactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
		transactionDefinition.setReadOnly(true); //设置只读操作
		//获取事务的提交状态
		TransactionStatus transactionStatus = this.transactionManaget.getTransaction(transactionDefinition) ; 
		try {
			vo = this.newsDAO.findById(nid) ; 
			this.transactionManaget.commit(transactionStatus); //提交事务
		}catch(Exception e) {
			this.transactionManaget.rollback(transactionStatus);  //出现问题回滚到指定的提交点
		}  
		return vo;
	}

}
