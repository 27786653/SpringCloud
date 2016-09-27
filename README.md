# SpringCloud
## 项目说明：
    1.registerServerCenter 服务注册中心
    2.ServerProvider       服务提供者
    3.ServerProvider2      服务提供者2(高可用冗余)
    4.ZuulServerWay        Api服务网关
    5.ServerConsumption    服务消费者
    6.ConfigServer         统一配置中心
    
## 启动顺序  
    1.registerServerCenter -> RegisterServerApplication 端口：10000
    1.ConfigServer -> Application 端口：10003
    1.ZuulServerWay -> Application 端口：10004
    1.ServerProvider -> ComputeServiceApplication 端口：10001
    1.ServerProvider2 -> ComputeServiceApplication 端口：10002
    1.ServerConsumption -> RibbonApplication 端口：10004

## 说明   
   服务提供方注册-api网关注册-被服务方注册   

## 访问  
服务注册中心：http://localhost:10000/   
服务提供方1：http://localhost:10001/add?a=10&b=20  
服务提供方2：http://localhost:10002/add?a=10&b=20    
被服务放访问：http://localhost:10004/add     
   (1.Ribbon对服务的负载均衡-访问的时候可以看服务端各自会有打印证明实现均衡  
    2.Hystrix熔断器-可停止提供服务之后调用fallbackMethod指定的方法)    
通过API网关访问：http://localhost:10004/api-a/add?a=1&b=2&accessToken=token     
   (无accessToken参数会报错401)      
