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
