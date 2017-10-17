package cn.mldn.mldnspring.schedule.jdk;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

class MyTask extends TimerTask{
	@Override
	public void run() {
		System.out.println("当前的日期时间" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date()));
	}
}

public class TimerTaskDemo {
	public static void main(String[] args) {
		Timer timer = new Timer() ; 
		MyTask m = new MyTask() ; 
		timer.schedule(new MyTask(), 0,1000);
	}
}
