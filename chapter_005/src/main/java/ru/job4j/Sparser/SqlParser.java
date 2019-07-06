package ru.job4j.Sparser;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.dailyAtHourAndMinute;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class SqlParser implements Job {
    private Scheduler scheduler;
    private CronTrigger trigger;
public SqlParser(){
    this.init();
}
    public void init() {

        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDetail job = newJob(SqlParser.class)
                    .withIdentity("myJob", "group1")
                    .build();
            trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .withSchedule(dailyAtHourAndMinute(12, 30))
                    .forJob("myJob")
                    .build();
            scheduler.scheduleJob(job, trigger);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Dbinput dbinput = new Dbinput();
        PasingVacancy pasingVacancy = new PasingVacancy();
        dbinput.input(pasingVacancy.parse(dbinput.getLastDate()));
    }
}
