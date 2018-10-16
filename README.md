# spring-cloud-practice
按照https://github.com/forezp/SpringCloudLearning

Q1.service-ribbon里，报错kotlin.UninitializedPropertyAccessException: lateinit property restTemplate has not been initialized
如果去掉@HystrixCommand(fallbackMethod = "hiError")就可以，待找到原因解决

Q2.config不起作用，读不到配置
