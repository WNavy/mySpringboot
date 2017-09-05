1、logBack是log4j框架的作者开发的新一代日志框架，效率更高，能够适应诸多环境，同时天然支持slf4j
   默认情况下，spring boot 会用logback来记录日志

2、依赖的jar包
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-logging</artifactId>
    </dependency>
    但是在实际开发中我们发现，该jar包并不用我们主动引入，spring-boot-starter中已经包含了
    spring-boot-starter-logging

3、根据不同的日推荐志系统，可以按照一下规则命名配置文件名，系统就会默认加载

    Logback ： logback-spring.xml,logback-spring.groovy,logback.xml，logback.groovy
    Log4j：log4j-spring.properties,log4j-spring.xml,log4j.properties,log4j.xml
    log4j2：log4j2-spring.xml,log4j2.xml
    JDK：logging.properties

    springboot优先推荐使用带有-spring的文件名作为日志配置文件；
    当然也可以不按照上面饿规则来命名，可以自定义命名，但是在application.properties配置文件中
    需要显示指定配置文件的路径,比如：
    eg:logging.config=classpath:logging-config.xml

4、添加logback-spring.xml，其中的编码解释：

   %d{yyyy-MM-dd HH:mm:ss.SSS} ： 日志输出时间
   %thread ： 输出日志的进程名字
   %-5level ： 日志级别，并且使用5个字符靠左对齐
   %logger{36} : 日志输出者的名字
   %msg ： 日志消息
   %n : 平台的换行符

5、根节点<configuration>包含的属性

   scan : 默认为true,表示配置文件如果发生变化，就重新加载
   scanPeriod：设置监测配置文件是否有修改的时间间隔，当scan为true时，此属性生效，默认时间间隔为1分钟
   debug：当此属性为true时，将打印出logback内部日志信息，可实时查看logback运行状态

   子节点：

        1、<contextName> 设置上下文，用于区分不同应用程序的记录，设置后可以通过%contextName来打印日志上下文

        2、<property> 定义变量的标签，有两个属性：name和value，通过标签设置的值会被插入到logger上下文中，定义
           变量之后，使用${}来使用变量

        3、<appender> 用来格式化日志输出节点，有两个属性，name和class，class用来指定使用的输出策略，常用的就会
           控制台输出和文件输出

        4、<root> 这是必选节点，用来指定最基础的日志输出级别，只有一个level属性
           level级别(从低到高大小写无关)：trace,debug，info,warn,error
           一个<root>可以包含零个或多个<apender-ref>，标识这个apender就会添加到这个loger
           如果引入的<appender>没有设置日志级别，后日志级别比root节点设置的级别低，
           则按照root节点设置的日志级别打印，如果比root设置的日志界别高，则按照appender本身的日志级别打印

        5、<loger> 用来设置某一个包或者具体的某一个类的日志打印级别，以及指定<apender>。
           <loger>仅有一个name属性，一个可选的level和一个可选的addtivity
           name:用来指定受此loger约束的某一个包或者具体的一个类
           level:设置打印级别，如果没有设置该属性，那么当前loger将会继承上级的级别
           addtivity:是否向上级loger传递打印信息，默认true

6、日志输出策略：

    控制台输出：ch.qos.logback.core.ConsoleAppender
    文件输出：ch.qos.logback.core.rolling.RollingFileAppender

    还可以指定拦截器，用来指定要输出的日志级别：ch.qos.logback.classic.filter.ThresholdFilter
    eg：
        <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
            <level>ERROR</level>
        </filter>
      表示过滤掉低于error级别的日志


