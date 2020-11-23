# cloud2020
尚硅谷2020SpringCloud的教程学习记录


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




# 问题
1. 为什么ribbon的rule不能跟springboot启动类放在同一个目录下
2. CAS 自旋锁
