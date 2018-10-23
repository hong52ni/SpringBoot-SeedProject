# SpringBoot-SeedProject

## 项目简介
使用SpringBoot构建的种子项目，配置了通用Mapper、Service接口，以及使用FreeMarker模板引擎实现了代码生成器，可用于中小项目的快速开发

## 环境依赖
JDK1.8及以上

## 技术栈
* Spring Boot<br>
* Mybatis<br>
* tk.Mybatis<br>
* PageHelper<br>
* FastJson<br>
* Druid<br>
* FreeMarker<br>

## 使用方法
* git clone `https://github.com/hong52ni/SpringBoot-SeedProject`
* 修改application-dev.yml中的数据库配置环境
* 继承通用接口直接使用，或根据业务在基础代码上扩展
* 代码生成：在CodeGenerator的main方法中修改需要生成的表名，运行即可

## 代码结构
```bash
├── README.md
├── pom.xml
├── springboot-seedproject.iml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── pers
│   │   │       └── hong
│   │   │           └── project
│   │   │               ├── SpringbootSeedprojectApplication.java   启动类
│   │   │               ├── common                                    
│   │   │               │   ├── Constants.java                      常量
│   │   │               │   ├── Result.java                         结果集
│   │   │               │   ├── ResultGenerator.java                响应结果生成工具
│   │   │               │   └── ServiceException.java               业务异常
│   │   │               ├── config
│   │   │               │   ├── MybatisConfig.java                  Mybatis配置
│   │   │               │   └── WebMvcConfig.java                   MVC配置
│   │   │               ├── core
│   │   │               │   ├── AbstractService.java                service实现
│   │   │               │   ├── Mapper.java                         通用mapper
│   │   │               │   └── Service.java                        通用service
│   │   │               └── generator
│   │   │                   └── CodeGenerator.java                  代码生成器
│   │   └── resources
│   │       ├── application-dev.yml                                 开发环境
│   │       ├── application-pro.yml                                 生产环境
│   │       ├── application-test.yml                                测试环境
│   │       ├── application.yml                                     配置文件
│   │       ├── banner.txt                                          banner
│   │       ├── mapper
│   │       └── template                                            模板文件
│   │           ├── controller.ftl
│   │           ├── service-impl.ftl
│   │           └── service.ftl
│   └── test
│       └── java
│           └── pers
│               └── hong
│                   └── project
│                       └── SpringbootSeedprojectApplicationTests.java
|
