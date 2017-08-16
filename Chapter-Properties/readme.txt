读取自定义的配置文件：

1、引入核心依赖包：spring-boot-configuration-processor.jar

2、定义自定义配置文件，spring默认的配置文件名为application.properties,
   如果配置文件名以application-开头，则也会被当成spring的配置文件

3、在application.properties配置文件中可以通过spring.profiles.active来激活相应的自定义配置文件
   ps:如果定义了application-dev.properties和application-product.properties两个配置文件，可以
   通过spring.profiles.active=dev或者spring.profiles.active=product来激活使用哪个配置文件

4、使用使用@Value("${}")来注入配置文件中的值，该种方式不用为变量提供set方法

5、或者通过使用注解@ConfigurationProperties(prefix="xxx",locations="classpath:xxx"),使用这种方式
   需要为个属性提供set方法

6、如果是自定的配置文件：可以使用注解@PropertySource(value = "")
   eg:@PropertySource(value = "classpath:test.properties")
