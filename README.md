# spring-cloud-practice
按照https://github.com/forezp/SpringCloudLearning

Q1.service-ribbon里，报错kotlin.UninitializedPropertyAccessException: lateinit property restTemplate has not been initialized
如果去掉@HystrixCommand(fallbackMethod = "hiError")就可以，待找到原因解决

Q2.config不起作用，读不到配置
Q3.第十篇: 高可用的服务注册中心(Finchley版本)，访问：localhost:8761，并没有发现peer2;访问localhost:8769没有peer1节点，也没有client的注册信息
