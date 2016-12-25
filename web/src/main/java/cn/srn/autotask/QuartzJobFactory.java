package cn.srn.autotask;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SRn on 2016/9/12.
 */
public class QuartzJobFactory implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("任务成功运行");
        ScheduleJob scheduleJob = (ScheduleJob)context.getMergedJobDataMap().get("scheduleJob");
        System.out.println("任务名称 = [" + scheduleJob.getJobName() + "], Thread : " + Thread.currentThread().getName());

    }

//    /** 计划任务map */
//    private static Map<String, ScheduleJob> jobMap = new HashMap<String, ScheduleJob>();
//    static {
//        for (int i = 0; i < 5; i++) {
//            ScheduleJob job = new ScheduleJob();
//            job.setJobId("10001" + i);
//            job.setJobName("data_import" + i);
//            job.setJobGroup("dataWork");
//            job.setJobStatus("1");
//            job.setCronExpression("0/5 * * * * ?");
//            job.setDesc("数据导入任务");
//            addJob(job);
//        }
//    }
//    /**
//     * 添加任务
//     * @param scheduleJob
//     */
//    public static void addJob(ScheduleJob scheduleJob) {
//        jobMap.put(scheduleJob.getJobGroup() + "_" + scheduleJob.getJobName(), scheduleJob);
//    }


}
