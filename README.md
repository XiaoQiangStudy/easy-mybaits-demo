# easy-mybaits-demo
可快速上手的简单 SpringBoot + Mybatis 示例

(基于 SpringBoot + Gradle，JAVA 11)

# 快速开始
1. 使用 IDEA 打开

2. 修改数据库配置

    打开 application.properties，将以下配置修改成自己的数据库配置：
    ```properties
    spring.datasource.url=改成自己的
    spring.datasource.username=改成自己的
    spring.datasource.password=改成自己的
    ```

3. 运行主程序，或者运行测试

    （注：每次重新运行，都会重新恢复数据表中的数据）

# 从 0 开始的步骤

如果想自己从 0 开始创建同样的项目，可参考下面的步骤：

### 一、准备
#### 1. 创建 SpringBoot 项目
* 使用 IDEA 创建：File > New > Project... > Spring Initializr

  依赖选择 Spring Web、MySQL Driver、MyBatis Framework。

* 或者 [在线创建](https://start.spring.io/)，选择同样的依赖，点 “Generate” 下载，然后用 IDEA 打开。

#### 2. 创建数据库
创建自己的数据库。

如果想让脚本随项目启动而自动执行，可参考以下配置：
```properties
spring.sql.init.schema-locations=classpath:sql/scheme.sql
spring.sql.init.data-locations=classpath:sql/data.sql
spring.sql.init.continue-on-error=true
spring.sql.init.mode=always
```

#### 3. 配置 datasource
在 application.properties 中添加以下配置
```properties
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/easy_mybatis_demo
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

### 二、mybatis 正式开发
#### 1. 创建 Model 类
根据数据表的定义，创建相应的 Model 类:
```java
package com.example.easymybaitsdemo.model;
//...
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //...
}
```
#### 2. 创建 Mapper
创建 Mapper，以操作数据库
* 首先建议在启动类中添加 `@MapperScan`，这样就不用为每个 Mapper 接口加上 @Mapper 的注解。
```java
@MapperScan("com.example.easymybaitsdemo.dao")
@SpringBootApplication
public class EasyMybaitsDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(EasyMybaitsDemoApplication.class, args);
	}

}
```
* 最直接的方式，是将 SQL 与 Mapper 写到一起：
```java
public interface UserMapper {
    @Select("SELECT * FROM `user`")
    List<User> getAllUsers();
}
```
到这里，如果没有特别要求，项目已经可以顺利运行了。

如果想要将 SQL 与 Mapper 分开，请继续往下阅读。

---

#### 3. 将 SQL 放到单独的同名 xml 文件中
* 与 Mapper 接口对应的 xml 文件必须同名，如 UserMapper 接口对应 UserMapper.xml。
* MyBatis 默认的约定是将 xml 放到 resource 目录下与包名相同的路径下。
  例如在本 demo 中，UserMapper 的包名是 `com.example.easymybaitsdemo.dao`，那么应将 UserMapper.xml 放到 resource/com/example/easymybaitsdemo/dao 目录下。

这样，基于默认约定，无需多余配置，将 SQL 单独出来，也可以顺利运行了。

如果想要自定义 xml 的存放位置，可以在 application.properties 进行配置，请继续往下阅读。

#### 4. mybatis 的更多配置
想要实现下面的目标，只需要往 application.properties 中追加配置即可。
* 想要自定义 mapper xml 位置？
```
# 自定义 mapper xml 位置（放到 resource/mapper 下）
mybatis.mapper-locations=classpath:mapper/*.xml
```
* 想要将“下划线命名” 转为 “驼峰命名”？
```
# 下划线命名 转 驼峰命名
mybatis.configuration.map-underscore-to-camel-case=true
```



