# springboot-cas-shiro
![example workflow](https://github.com/willwu1984/springboot-cas-shiro/actions/workflows/maven.yml/badge.svg)

spring boot应用配置单点登录服务示例，使用shiro，使用文档：http://www.jianshu.com/p/600593b1f366

使用修改shiro配置即可
```
shiro.cas=https://cas.xxx.com #更改为CAS服务器的地址
shiro.server=http://127.0.0.1:8080 #应用地址
```
