package cn.srn.controllers;

import cn.srn.autotask.QuartzJobFactory;
import cn.srn.autotask.ScheduleJob;
import cn.srn.respson.ResponseInfo;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by SRn on 2016/9/12.
 */
@Controller
public class AutoTask {

    AtomicInteger tskId = new AtomicInteger(0);

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @ResponseBody
    @RequestMapping(value = "/autoTask")
    public ResponseInfo task() throws SchedulerException {
        //schedulerFactoryBean 由spring创建注入
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        //这里获取任务信息数据
        List<ScheduleJob> jobList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int tskId = this.tskId.getAndAdd(1);
            ScheduleJob job = new ScheduleJob();
            job.setJobId("10001" + tskId);
            job.setJobName("JobName_" + tskId);
            job.setJobGroup("dataWork");
            job.setJobStatus("1");
            job.setCronExpression("0/5 * * * * ?");
            job.setDesc("数据导入任务");
            jobList.add(job);
        }

        scheduler.clear();

        for (ScheduleJob job : jobList) {
            TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
            //获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            //不存在，创建一个
            if (null == trigger) {
                JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
                        .withIdentity(job.getJobName(), job.getJobGroup()).build();
                jobDetail.getJobDataMap().put("scheduleJob", job);
                //表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
                        .getCronExpression());
                //按新的cronExpression表达式构建一个新的trigger
                trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
            } else {
                // Trigger已存在，那么更新相应的定时设置
                //表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
                        .getCronExpression());
                //按新的cronExpression表达式重新构建trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
                        .withSchedule(scheduleBuilder).build();
                //按新的trigger重新设置job执行
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        }

        return new ResponseInfo(0, "成功");
    }
}
