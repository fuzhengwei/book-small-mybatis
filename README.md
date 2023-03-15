# 《手写Mybatis：渐进式源码实践》—— 书籍案例源码

>小傅哥，公众号[【bugstack虫洞栈】](https://bugstack.cn/images/personal/qrcode.png)互联网大厂T8架构师。《重学Java设计模式》、《手写Spring：渐进式源码实践》、《手写MyBatis：渐进式源码实践》图书作者。

- :bus: 作品：[`CodeGuide | 程序员编码指南`](https://github.com/fuzhengwei/CodeGuide) | [`RoadMap 编程路书`](https://github.com/fuzhengwei/RoadMap) | [`Java 数据结构和算法`](https://github.com/fuzhengwei/java-algorithms) | [`IM 仿微信`](https://github.com/fuzhengwei/NaiveChat) | [`Java 面经手册`](https://github.com/fuzhengwei/interview) | [`IntelliJ IDEA 插件开发`](https://github.com/fuzhengwei/guide-idea-plugin) | [`Lottery 抽奖系统 - 基于领域驱动设计的四层架构实践`](https://github.com/fuzhengwei/Lottery) | [`API网关`](https://github.com/fuzhengwei/api-gateway) | [`设计模式`](https://github.com/fuzhengwei/itstack-demo-design) | [`Netty 实战案例`](https://github.com/fuzhengwei/itstack-demo-netty) | [`字节码编程`](https://github.com/fuzhengwei/itstack-demo-bytecode) | [更多搜索...](https://github.com/fuzhengwei?tab=repositories)
- :seedling: 干货：[公众号『 bugstack虫洞栈 』](https://bugstack.cn/images/personal/qrcode.png)
- :pencil: 博客：[bugstack.cn](https://bugstack.cn/) - 足够硬核，内容老狠了！
- :tv: 视频：[B站 小傅哥の码场](https://space.bilibili.com/15637440)
- :love_letter: 微信：[fustack](https://bugstack.cn/images/personal/fustack.png) - 备注来意
- :feet: 我的编程知识星球：[实战生产级项目、手写框架级源码，可以向我 1对1 提问，解答技术/职场/规划问题](https://bugstack.cn/md/zsxq/introduce.html)

---

👨‍💻作者：小傅哥
<br/>
🌱微信：fustack —— 可以添加微信备注【MyBatis读书群📚】

>沉淀、分享、成长，让自己和他人都能有所收获！

## ⛳ 目录

- [Github](https://github.com/fuzhengwei/book-small-mybatis) | [Gitcode](https://gitcode.net/fuzhengwei/book-small-mybatis)
- [0. 内容简述](#) - 添加小傅哥微信【fustack】备注【MyBatis 读书加群】
- [1. 书籍购买](#1-书籍购买)
- [2. 勘误记录](#2-勘误记录) - 非常感谢，`读者提交阅读中发现的错字和问题`。

### 1. 内容简述

<div align="center">
    <a href="https://union-click.jd.com/jdc?e=618%7Cpc%7C&p=JF8BANIJK1olXwUFU1xcAUoRA18IGVIVXQUCU24ZVxNJXF9RXh5UHw0cSgYYXBcIWDoXSQVJQwYAXV5dC0sQHDZNRwYlGH1ZDiUfbTl0Xh1OcyVdXlMLDz9YeEcbM244G1oUXQEKU1hfCHsnA2g4STXN67Da8e9B3OGY1uefK1olXQEEU1haDE0UBm4JHGsSXQ8yIgoCXAhHXjhMK2slXjYFVFdJDjlWUXsOaWslXTYBZF5VC0sXAmkOGUcVXAQDU0JdD00QBWgMHVsTVAYKZFxcCU8eM18" target="_blank">
        <img src="https://bugstack.cn/images/article/product/book/mybatis-t-01.png?raw=true" width="250px">
    </a>
</div>
<br/>

`代理`、`反射`、`池化`、`缓存`，MyBatis 给我们的不只是一个 ORM 框架，还包括了它经过深思熟虑所做的分层设计以及对应产生的行之有效的解决方案。MyBatis 的存在不需要让你再刀耕火种般创建 JDBC，也不需要像使用 Hibernate 那么厚重到还需要增加学习 HQL 语句。同时 MyBatis 还支持通过插件机制扩展；监控、加密、路由等功能。因而如此简单且高效的 MyBatis ORM 框架，备受互联网大厂青睐，也是每一个 Java 程序员必须的技术。

除了运用以外，MyBatis 框架也是众多码农，最能最先接触到的一个优质的**源码级别复杂项目**。此源码为了实现如此长周期软件迭代和维护，运用了分治和抽象进行模块设计，使用了**数10种**设计模型进行代码开发。这哪仅仅是一个 ORM 框架，**这简直是学习设计模式的最佳源码级实践资料**。

### 2. 书籍购买

**链接下单**：[https://item.jd.com/13811216.html](https://union-click.jd.com/jdc?e=618%7Cpc%7C&p=JF8BANIJK1olXwUFU1xcAUoRA18IGVIVXQUCU24ZVxNJXF9RXh5UHw0cSgYYXBcIWDoXSQVJQwYAXV5dC0sQHDZNRwYlGH1ZDiUfbTl0Xh1OcyVdXlMLDz9YeEcbM244G1oUXQEKU1hfCHsnA2g4STXN67Da8e9B3OGY1uefK1olXQEEU1haDE0UBm4JHGsSXQ8yIgoCXAhHXjhMK2slXjYFVFdJDjlWUXsOaWslXTYBZF5VC0sXAmkOGUcVXAQDU0JdD00QBWgMHVsTVAYKZFxcCU8eM18)

本书共 22 章：

- 第 1 ~ 4 章:拆解和实现 ORM 框架的基本功能，构建会话的基本调用流程，初解析 XML 文件，以及串联 DefaultSqlSession 结合解析配置项获取展示信息。
- 第 5 ~ 8 章:创建和使用数据源，池化技术的实现，完成执行 SQL 语句的操作，同时引入反射工具包，实现对属性信息的获取和设置。
- 第 9 ~ 12 章:以实现 ORM 框架的基本功能为目的，完善静态 SQL 的标准化解析、参数设置和结果封装，使整个 ORM 框架可以处理基本的增、删、改、查操作。
- 第 13 ~ 19 章:以完善 ORM 框架的核心功能逻辑为目的，实现注解 SQL 解析、 ResultMap 参数、事务处理自增索引、动态 SQL 解析、插件、一级缓存和二级缓 存等功能。
- 第 20 ~ 22 章:利用 ORM 框架整合 Spring 和 SpringBoot，并介绍整个核心流程， 同时总结 ORM 框架开发中涉及的 10 种设计模式。

### 3. 勘误记录

---

感谢图书编辑：宋亚东、杨中兴

感谢大佬推荐：思否CTO-祁宁(@Joyqi)、中国科学院大学研究生导师-刘俊明、Apipost 创始人-穆红伟、京东垂直业务负责人-孙浩、京东授信认证业务技术负责人-郭泽渊、GitHub开源项目JavaGuide作者-G哥、《深入理解高并发编程:核心原理与案例实战》图书作者-冰河
