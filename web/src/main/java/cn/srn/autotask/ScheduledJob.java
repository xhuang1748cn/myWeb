package cn.srn.autotask;

import cn.srn.services.UserService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * Created by SRn on 2016/9/12.
 */
public class ScheduledJob extends QuartzJobBean {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println(Thread.currentThread().getName() + " autoTask1:" + new Date().toString() + ", userService :" + userService.toString());
    }
}
