package com.hibo.games.g2d.friends.maj.redmaj.task;

/**
 * 游戏定时任务
 * @author oz
 *
 */
public interface IGameTask {

	/** 初始化 线程池 */
	public void init();
	
	/** 开始计时
	 * 1、传入时间（开始/取线程）
	 * 2、每秒倒计，调用doAction，（比如传入10，调用doAction 10次，时间结束就停止）
	 * 3、时间结束，调用stopAction，（停止/回收线程）
	 *  */
	public void start(int time);
	
	/** 重置当前计时 */
	public void resetTime();
	
	/** 停止 */
	public void stop();
	
	
	/** 执行方法（每秒执行） */
	public void doAction();
	
	/** 执行方法（停止执行） */
	public void stopAction();
}
