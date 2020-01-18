## ShortMessageManage(仿QQ邮箱)

这是一个web应用，模拟了邮箱中的一些功能，是一个学习Java技术的练习项目。

主要功能：
- 登陆注册
- 发送邮件
- 转发邮件
- 删除邮件

技术说明

- 框架：JSP+Servlet+Bootstrap+原生jdbc+JNDI
- 数据库：mysql
- 开发平台：IDEA2018

使用说明：

1. 导入脚本message_0807.sql和user_0807.sql，其中包含了建表语句和一些初始数据
2. 修改WebContent\META-INF\context.xml文件中配置的数据库连接信息
3. 登录账号lili，密码123

>注意：开发平台的编码是GBK，其余设置的是UTF-8
