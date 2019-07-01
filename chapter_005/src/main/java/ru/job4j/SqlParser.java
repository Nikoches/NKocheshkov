package ru.job4j;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import static org.quartz.CronScheduleBuilder.dailyAtHourAndMinute;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class SqlParser implements Job {
    private Connection connection;
    private Scheduler scheduler;
    private CronTrigger trigger;

    public SqlParser() {
        this.init();
    }

    public static void main(String[] args) {
        SqlParser ss = new SqlParser();
        ss.getvancy();
    }

    public boolean init() {

        try (InputStream in = SqlParser.class.getClassLoader().getResourceAsStream("sql_parser/app.properties")) {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            Statement st = connection.createStatement();
            st.execute(" create table if not exists vacancy(id serial primary key,name text,description text,link text,created text);");
            st.close();
            JobDetail job = newJob(SqlParser.class)
                    .withIdentity("myJob", "group1")
                    .build();
            trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .withSchedule(dailyAtHourAndMinute(10, 42))
                    .forJob("myJob")
                    .build();
            scheduler.scheduleJob(job, trigger);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    public boolean getvancy() {
        Set<Vacancy> list = new HashSet<>();
        String sqlc = ("insert into vacancy(name,description,link,created) values(?,?,?,?)");
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlc)) {
            Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers").get();//получает html-код страницы
            Element table = doc.select("table").get(2); //находим первую таблицу в документе
            //если надо вторую, третью или т.д. используем .get(номер)
            Elements rows = table.select("tr");// разбиваем нашу таблицу на строки по тегу
            for (int i = 1; i < rows.size(); i++) {
                Element row = rows.get(i); //по номеру индекса получает строку
                Elements cols = row.select("td");// разбиваем полученную строку по тегу  на столбы
                if (cols.get(1).text().contains("Java") && !cols.get(1).text().contains("JavaScript")) {
                    Document docdesc = Jsoup.connect(cols.get(1).select("a").attr("href")).get();
                    System.out.print(cols.get(1).text());// название
                    System.out.println(cols.get(5).text()); //дата
                    //ссылка
                    System.out.print(cols.get(1).select("a").attr("href")+"  \n ");
                    //описание
                    System.out.println(docdesc.select("table").get(1).select("tr").get(1).select("td").get(1).text());
                    list.add(new Vacancy(cols.get(1).text(),
                            docdesc.select("table").get(1).select("tr").get(1).select("td").get(1).text(),
                            cols.get(5).text(),
                            cols.get(1).select("a").attr("href")));
                }
            }
            for(Vacancy i:list){
                preparedStatement.setString(1, i.getName());
                preparedStatement.setString(2, i.getDescription());
                preparedStatement.setString(3, i.getUrl());
                preparedStatement.setString(4, i.getDate());
                preparedStatement.execute();
            }
            scheduler.shutdown();
        } catch (Exception x) {
            x.printStackTrace();
        }
        return true;
    }

    /**
     * <p>
     * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code>
     * fires that is associated with the <code>Job</code>.
     * </p>
     *
     * <p>
     * The implementation may wish to set a
     * {@link JobExecutionContext#setResult(Object) result} object on the
     * {@link JobExecutionContext} before this method exits.  The result itself
     * is meaningless to Quartz, but may be informative to
     * <code>{@link JobListener}s</code> or
     * <code>{@link TriggerListener}s</code> that are watching the job's
     * execution.
     * </p>
     *
     * @param context
     * @throws JobExecutionException if there is an exception while executing the job.
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SqlParser ss = new SqlParser();
        ss.getvancy();
    }
}
