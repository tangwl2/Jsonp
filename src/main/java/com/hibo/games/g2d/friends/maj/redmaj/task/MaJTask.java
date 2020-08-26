package com.hibo.games.g2d.friends.maj.redmaj.task;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MaJTask implements IGameTask{

	
	//核心线程数量，即初始化线程池的启动线程数量   
    private static final int corePoolSize = 10;   
    //最大线程数量   
    private static final int maximumPoolSize = 20;   
    //线程的存活时间，即完成任务后多久可再使用   
    private static final int keepAliveTime = 300;   
    //等待队列的长度   
    private static final int workQueueSize = 30;   
    private static ThreadPoolExecutor exec = null;
	
	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		// 参数：1、任务体 2、首次执行的延时时间
//		      3、任务执行间隔 4、间隔时间单位
		service.scheduleAtFixedRate(new Runnable() {
		    @Override
		    public void run() {
		        System.out.println("定时任务"+new Date());
		    }
		},0,3,TimeUnit.SECONDS);
	}
	@SuppressWarnings({ "rawtypes", "unchecked"})
	@Override
	public void init() {
		if(exec == null) {
			exec = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
					new LinkedBlockingQueue(workQueueSize), new ThreadPoolExceptionHandler());
		}
//		 if (exec == null) {   
//	            //ThreadPoolExceptionHandler表示当线程池处理不了规定任务时的异常处理方式。   
//	        exec = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,   
//	                    new LinkedBlockingQueue(workQueueSize), new ThreadPoolExceptionHandler());   
//	    } 
	}

	@Override
	public void start(int time) {
		
	}

	@Override
	public void resetTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopAction() {
		// TODO Auto-generated method stub
		
	}
}
