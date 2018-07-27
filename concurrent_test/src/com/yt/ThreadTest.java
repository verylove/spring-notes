package com.yt;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * All rights Reserved, Designed By www.75271.com
 * @Title:  ThreadTest.java   
 * @Package com.example.demo   
 * @Description:    4种不同线程池的使用
 * @author: 开心洋葱 
 * @mail:   431910788@qq.com 
 * @date:   2018年7月27日 下午4:15:22   
 * @version V1.0 
 * @Copyright: 2018 www.75271.com Inc. All rights reserved. 
 * 注意：本内容仅限于杨涛及其授权用户使用，禁止外泄以及用于其他的商业目
 */
public class ThreadTest {
	
	public static void main(String args[]) {
		
		/**
		 *  1. 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程
		 */
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
		    final int index = i;
		    try {
		        Thread.sleep(index * 1000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }

		    cachedThreadPool.execute(new Runnable() {

		        @Override
		        public void run() {
		        	try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		            System.out.println(index+":"+Thread.currentThread().getName());
		        }
		    });
		}
		
		/**
		 * 2. 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
		 */
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
		    final int index = i;
		    fixedThreadPool.execute(new Runnable() {

		        @Override
		        public void run() {
		            try {
		                System.out.println(index+":"+Thread.currentThread().getName());
		                Thread.sleep(2000);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }
		    });
		}
		
		
		/**
		 *  3.  创建一个定长线程池，支持定时及周期性任务执行
		 */
		
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {

		    @Override
		    public void run() {
		        System.out.println("delay 3 seconds");
		    }
		}, 3, TimeUnit.SECONDS);//表示延迟3秒执行
		
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			 @Override
				public void run() {
					System.out.println("delay 1 seconds, and excute every 3 seconds");
				}
			}, 1, 3, TimeUnit.SECONDS);//表示延迟1秒后每3秒执行一次
		
		
		/**
		 *  4.  创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
		 */
		
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
		    final int index = i;
		    singleThreadExecutor.execute(new Runnable() {

		        @Override
		        public void run() {
		            try {
		                System.out.println(index);
		                Thread.sleep(2000);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }
		    });
		}//结果依次输出，相当于顺序执行各个任务
		
	}
}
