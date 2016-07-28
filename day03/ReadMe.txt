MVC三层架构开发实例

一个MVC程序的过程如下：
1.搭建开放环境
	1.1导入相关的开发包
	dom4j包+jstl包+log4j包+beanUtils包
	
	1.2创建组织程序包
	cn.itcast.domain 		    放置整个网站的实体
	cn.incast.dao 				数据库相关（接口）
	cn.itcast.dao.impl   		数据库相关（接口的实现）
	cn.itcast.service	 		对数据进行处理（接口）
	cn.itcast.service.impl 		对数据进行处理（接口的实现）
	cn.itcast.web.controller 	处理请求的servlet
	cn.itcast.web.UI			为用户提供用户界面
	cn.itcast.utils				工具包
	junit.test					测试包
	
	1.3创建代表数据库的xml文件
	在类目录下创建一个代表数据库的users.xml文件
	
	功能补齐：
	1）添加图片验证功能
	2）添加mysql数据库
	3）给注册用户名添加ajax功能，使它在输入完之后异步查询数据库中是否已经存在该用户名，若存在则通知用户该用户名不可以注册，
	否则告诉用户，这是一个可以使用的用户名。
	4）使用filter过滤功能，使用户只能从首页登陆。
	
	
	工作流程：
	一个请求发送到action(作用：MVC中的C),action控制它发送到哪个biz处理,如果用到数据库，那么biz在连接dao，然后返回要的数据，
	最后action在返回响应的页面(比如jsp),因为是面向对象,所以实体domain在中间传递数据。以上为工作流程.
	
	各层意义：
	action为控制层，MVC中充当C角色,用来分配哪个业务来处理用户请求。
	biz业务层，存放好多处理业务的代码，现实中面向接口编程，一般这里定义都是业务接口，通常会有一个biz.impl这个包用来写实现类.当然针对架构意义实现类不用说。
	dao持久层,数据库相关，DB操作都写在这里
	ui 用户交互层,通常为页面,例如.jsp,aspx等页面
	util功能包，针对本项目工具类
	common通用工具包，一般一个公司会有固定的jar，好几个项目通用的，例如远程调用等
	domian存放实体,如果用ibatis框架,一般mapping创建在它下面,当然只针对架构mapping也是无意义.
	
	
	鼓励使用service domain dao 层分层设计概念。
	
	第一：dao层操作单表（不涉及复杂逻辑），主要是表的增删改查操作，完全根据domain的要求来查询数据。
	
	第二：domain层考虑业务逻辑，例如过滤条件，放行或者返回，以及数据的处理，为调用dao层做好准备，一个domain可以调用一个或者一组相关的dao层
	
	dao层与domain层之间的关系？
	
	第三：service层调用一个或者一组domain层，主要是展现需要开放出去的接口，其中domain层不是所有的接口都要在service层体现的，
	可能仅在service层开放几个接口出去，此外，主要接口需要对接受的参数要尽量的扩大化，也就是说可以容纳各种类型的参数的接入（Object），
	然后需要在service层做好转换，以备domain层使用。
	
	正确的设计应该是，一个领域活动会聚合对应一个或一组DAO ，来完成一个领域活动。而一个服务可能包含两个领域活动，比如一个转账的业务，
	对应两个领域活动。两个帐户的金额分别发生变化，需要操作一组领域活动，而每个活动需要操作很多表（调用多个DAO ）。
	
	
	使用 接口方式可以实现系统之间的松耦合：
	
	一般定义： IUserService  UserService  IUserDomain  UserDomain  IUserDao UserSqlDao   UserHbaseDao
	
	使用接口可以有不同的实现类 ,不需要改代码，可以通过配置更改不同的实现类
		