package cn.mldn.mldnspring.schedule.quartz;

import java.text.SimpleDateFormat;




public class MyTask{
	protected void runTask(){
		System.out.println("当前的日期时间" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date()));
	}
}
