# springboot_rabbitmq
消息发送和接收，见到实现Topic Echange和Fanout Exchange消息发送队列
## 一、参考学习链接
学习查看顺序我是如下的：

Spring Boot(八):RabbitMQ详解：https://www.cnblogs.com/ityouknow/p/6120544.html  
springboot+rabbitmq整合示例程：https://www.cnblogs.com/boshen-hzb/p/6841982.html  
RabbitMQ笔记十三：使用@RabbitListener注解消费消息: https://www.jianshu.com/p/382d6f609697  
RabbitMQ：RabbitAdmin 与 RabbitTemplate 使用：https://www.jianshu.com/p/e647758a7c50

## 二、开始开发
###（一）简单说明
首先还是保持之前的两个应用项目，一个是接收方，一个是发送方，注意二者保持同样的一个常量类RabbitMQConstants，其中包含了exchange、queue的固定名称；
在接收方中通过@RabbitListener注解来监听发送的消息并进行处理；

###（二）发送方应用相关代码编写
1. 常量类RabbitMQConstants  
2. 如果想要针对发送端进行一些配置，可创建一个@Configuration注解的类，其中针对RabbitMQ进行配置(eg:ConnectionFactory, TemplateFactory等等),我是直接在上一篇中通过application.yml中配置了rabbitmq的信息，所以就不配了，大体可以借鉴一下此文章
使用RabbitListener注解进行消息消费  
3. 进行消息发送的测试类RabbitMqHelloTest

###（三）接收方应用相关代码编写
1. 和发送方一样的常量类RabbitMQConstants  
2. 因为我这里报了ObjectMapper类不存在的问题，所以就在pom.xml中maven引入了jackson-databind  
3. 监听类，这里定义了三个来测试  
（1）OrderReceiveListener.java  
（2）OrganizationReceiveListener.java  
（3）TestFanoutReceiveListener.java  
###（四）测试消息发送和接收
1. 首先接收方应用先启动起来；  
2. 然后发送方，进行测试类中方法的逐个执行；  
3. 最后查看接收方控制台的输出情况，差不多如下；  
4. 细看代码，发现fanout不指定queue去发送的话，绑定的每个queue是都能正常接收的；  
5. 如果exchange已经创建了，再更改其模式类型就不行了，这时候就要去进行删除然后再重新生成来更改。关于exchange、queues的控制删除等管理，可以登陆：http://rabbitmq所在ip:端口号 来进行操作。
