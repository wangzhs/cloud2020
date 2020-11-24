# cloud2020
尚硅谷2020SpringCloud的教程学习记录

## 服务列表
|服务ID|服务名称|端口号|服务解释|关联服务|
|:---:|:---:|:---:|:---:|:---:|
|1|cloud-consumer-order80|80|客户端消费|2，3|
|2|cloud-eureka-service7001|7001|Eureka注册网关集群|3|
|3|cloud-eureka-service7002|7002|Eureka注册网关集群|2|
|4|cloud-provider-payment8001|8001|支付服务端集群|2，3|
|5|cloud-provider-payment8002|8002|支付服务端集群|2，3|
|6|cloud-consumerzk-order80|80|Zookeeper注册中心，客户端消费|7|
|7|cloud-provider-zookeeper-payment8004|8004|Zookeeper注册中心，服务端|6|
|8|cloud-consumerconsul-order80|80|Consul注册中心，客户端消费|9|
|9|cloud-provider-consul-payment8006|8006|Zookeeper注册中心，服务端|9|
|10|cloud-consumer-openfeign-order80|80|Eureka注册中心，客户端 ，提供openfeign注解式调用|2，3，4，5|


## 学习技术的架包和软件版本选择
|软件|版本|
|:---:|:---:|
|cloud |          Hoxton.SR1|
|boot   |         2.2.2RELEASE|
|cloud alibab |   2.1.0RELEASE|
|java   |         8 |
|Maven  |         3.5及以上|
|Mysql   |        5.7及以上|
|Zookeeper   |    |
|Consul||
|JMeter||

## Eureka 集群搭建需要更改本地hosts文件

## Eureka自我保护

某个时刻微服务不可用，Eureka不会立即清理，依旧会对微服务的信息进行保存（列如网络卡顿）

属于CAP中的AP分支


## Eureka、Zookeeper、Consul区别
|组件名|语言|CAP|服务健康检********查|对外暴露接口|是否集成spring cloud|
|:---:|:---:|:---:|:---:|:---:|:---:|
|Eureka|Java|AP|可配置支持|HTTP|是|
|Consul|go|CP|支持|HTTP/DNS|是|
|Zookeeper|Java|CP|支持|客户端|是|

### CAP简介
* C:Consistency（强一致性）
* A:Availability（可用性）
* P:Partition tolerance (分区容错性)

#### CAP支持
* CA: 单点集群，满足一致性和可用性
* CP: 满足一致性和分区容错性。为了保证一致性，如果服务出错，必须拒绝服务
* AP: 满足可用性和分区容错性。保证服务的高可用性


## Ribbon和Nginx的区别
nginx 是客户端所有请求统一交给nginx，有nginx来实现负载均衡，属于服务器负载均衡。

ribbon 是从eureka注册中心服务器端上获取服务注册中心，缓存在本地，然后在本地实现负载均衡策略

### Ribbon负载均衡算法
1. 轮询算法：接口请求次数 % 服务集群数 = 下标。利用下标取server 


## Hystrix 

### Hystrix的重要概念
1. 服务熔断（break）：服务器达到最大的服务访问量，直接拒绝访问，并给出友好提示
2. 服务降级（fallback）：服务器忙，不让客户端等待，并给出友好提示
    * 程序运行异常
    * 超时
    * 服务熔断触发服务降级
    * 线程池/信号量打满 服务降级
3. 服务限流（flowlimit）： 秒杀高并发等操作，严谨一窝蜂过来拥挤排队，有序进行



# 问题
1. 为什么ribbon的rule不能跟springboot启动类放在同一个目录下
2. CAS 自旋锁
3. openfeign注解的实现