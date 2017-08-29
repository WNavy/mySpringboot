springboot连接数据库的几种方式：

1、直接使用spring提供的jdbcTemplate

   ①引入核心jar包：
       <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-jdbc</artifactId>
       </dependency>

   ②JdbcTemplate主要提供五类方法：

    1.execute方法，可以执行任何语句，一般用于执行DDL语句；
    2.update方法和batchUpdate方法：update用于执行新增、更新、删除语句；batchUpdate用于执行批处理语句；
    3.call方法，用于执行存储过程、函数等相关语句
    4.query方法和queryForXXX方法，用于执行查询相关语句；

      queryForList()方法返回的是map形式的集合，每个map代表一行记录
      queryForObject（)方法如果没有查到数据会抛出EmptyResultDataAccessException异常


2、使用jpa

    ①引入核心依赖的jar包
        <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

    ②在实体类上使用注解@Entity,通过@Table注解可以指定生成的表的名字
      @GeneratedValue一般跟主键注解@Id配合使用，用来指定主键的生成策略
      可以通过strategy属性指定，有三种可供选择的策略：
      --identity：自增，适用mysql
      --auto：jap自动选择合适策略，默认
      --sequence：序列产生主键，适用oracle

    ③配置文件中添加hibernate的配置属性spring.jpa.properties.hibernate.hbm2ddl.auto
     配置之后在系统启动时就会根据Model自动创建表

    ④jpa除了已经提供的CRUD方法之外，还可以自定义简单查询，自定义规则是通过关键字来连接属性，
    eg:findXXByXX，readXXByXX,countXXByXX，getXXByXX.
    多属性的可以使用关键字连接:eg:findByXXAndXX

    ⑤分页查询，jap已经提供了分页功能，使用Pageable，有多个参数时，建议Pageable作为最后一个参数传入
    eg:
        Sort sort = new Sort(Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,size，sort)

    ⑥自定义查询
      在查询方法上使用注解@Query，如果涉及删除和修改需要再加上@Modifying
      如果需要添加对事务的支持，使用注解@Transactional

      正常情况系，实体类加上@Entity之后，就会让实体类和表相关联，如果某个属性不需要跟表相关联，
      可以使用注解@Transient即可

      可以参考：http://www.cnblogs.com/ityouknow/p/5891443.html


3、使用mongo

    springboot自动配置了支持mongodb,如果引入了mongo的核心包，在启动springboot的时候就会自动
    实例化一个mongo实例

    ①引入mongo核心jar包
        <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>

    ②application.properties添加配置文件

    ③实体类使用@Docment注解修饰，表示为mongodb支持类型

    ④mongo的用法类似jpa，直接创建接口继承MongoRepository,或者使用MongoTemplate

4、使用redis

   ①引入redis的核心jar
        <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>

   ②直接引入StringRedisTemplate或者RedisTemplate

5、使用mybatis

    ①引入mybatis的核心依赖jar
        <dependency>
          <groupId>org.mybatis.spring.boot</groupId>
          <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>

    springboot整合mybatis两种方式：
    1、全注解，无配置文件版

        ①application.properties中添加配置：mybatis.type-aliases-package=com.whj.entity
        数据层的包路径

        ②在springboot的启动类添加注解@MapperScan("com.whj.mapper") 或者在Mapper类上使用注解@Mapper

        ③开发mapper

            1、使用注解@Select，@Insert，@Update，@Delete，返回结果使用注解

                @Results({
                    @Result（property=“”，column=“”），
                    @Result（property=“”，column=“”）
                })

    2、使用传统xml的版本

        ①application.properties中增加配置：
            mybatis.config-locations=classpath:mybatis/mybatis-config.xml()
            mybatis.mapper-locations=classpath:mybatis/mapper/*.xml

        ②开发mapper,仅有接口方法就行，会根据接口方法名找到xml文件中同名的sql

