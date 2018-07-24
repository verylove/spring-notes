package com.yt.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class ExampleJob extends QuartzJobBean {

	private int timeout;

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "执行ExampleJob的定时任务");
	}
	

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	

}
