# cloud2020
尚硅谷2020SpringCloud的教程学习记录


## 学习技术的架包和软件版本选择
cloud           Hoxton.SR1
boot            2.2.2RELEASE
cloud alibab    2.1.0RELEASE
java            8 
Maven           3.5及以上
Mysql           5.7及以上


## Eureka 集群搭建需要更改本地hosts文件

## Eureka自我保护

某个时刻微服务不可用，Eureka不会立即清理，依旧会对微服务的信息进行保存（列如网络卡顿）

属于CAP中的AP分支