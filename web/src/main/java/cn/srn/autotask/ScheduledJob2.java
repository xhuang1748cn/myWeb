package cn.srn.autotask;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * Created by SRn on 2016/9/12.
 */
public class ScheduledJob2 extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println(Thread.currentThread().getName() + " autoTask2:" + new Date().toString());
    }
}
