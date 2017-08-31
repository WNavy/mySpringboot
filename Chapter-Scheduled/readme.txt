1、springboot支持定时任务

    ①在springboot项目启动入口使用注解@EnableScheduling，作用是启动调度任务

    ②创建定时任务类，交由spring管理，在类方法上使用注解@Scheduled来者是定时

    @Scheduled注解有一下属性：
        1、initialDelay = 5000：表示在系统动之后延迟5s再执行定时任务
        2、fixedRate = 5000：上一次任务开始执行时间之后5s再执行
        3、fixedDelay = 5000：上次任务执行完成之后5s再执行
        还可以通过cron表达式定义规则
        一个cron表达式至少有6个有空格分隔的时间元素
        参考：http://blog.csdn.net/qq_33556185/article/details/51852537

        使用springboot实现多线程执行定时任务：
        实现SchedulingConfigurer接口，重写configureTasks()方法