package cn.mldn.mldnspring.schedule.task;

import java.text.SimpleDateFormat;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component  //必须明确的告诉Spring，现在的MyTask是一个Spring容器管理的bean
public class MyTask{
	@Scheduled(cron="* * * * * ?")
	public void runJobTask(){
		System.out.println("当前的日期时间" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date()));
	}
}
