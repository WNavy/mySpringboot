springboot整合myBatis：
1、引入核心jar包：mybatis-spring-boot-starter.jar,mysql-connector-java.jar
2、在配置文件中设置数据连接属性和mybatis的xml路径
3、在启动类中添加自动扫描，使用注解@MapperScan