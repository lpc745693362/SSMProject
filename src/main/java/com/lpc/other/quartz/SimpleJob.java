package com.lpc.other.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 一个简单作业
 */
public class SimpleJob implements Job {

    public void execute(JobExecutionContext jobContext) throws JobExecutionException {
        System.out.println(jobContext.getJobDetail().getJobDataMap().get("name") + " say hello to you. time is " + new Date());
    }

}
