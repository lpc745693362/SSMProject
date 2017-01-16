package com.lpc.other.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by liupengcheng1 on 2017/1/16.
 */
public class SimpleTriggerRunner {

    public static void main(String[] args) {
        try {

            JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("job1", "group1")
                    .usingJobData("name", "liupc")
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(3) // 时间间隔
                            .withRepeatCount(10)) // 重复次数
                    .build();

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
