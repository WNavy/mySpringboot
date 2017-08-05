1、使用springBoot搭建基础运行环境

步骤：
	①、引入核心依赖包spring-boot-starter-web.jar
	②、创建一个启动入口类，启动类要放在所有的被@RestController注解的类的根路径的包下
	④、入口类使用注解@SpringBootApplication
	④、Controller类使用注解@RestController(表示直接返回调用方法中返回的字符串)
	
2、使用spring的MockMvc测试
	
步骤：
	①、引入核心依赖包spring-boot-starter-test.jar，junit.jar
	②、测试类使用注解
		@RunWith(SpringJUnit4ClassRunner.class)
		@SpringBootTest(classes = Application.class)
		@AutoConfigureMockMvc
	③自动注入MockMvc类
	④使用方法
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)).andReturn();
		mvcResult.getResponse().getContentAsString() --获得响应数据