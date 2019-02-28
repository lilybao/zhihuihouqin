# 项目说明


### 模块划分

*   zhihuihouqin-web 后台项目 依赖lcworld-common模块,lcworld-shiro模板,lcworld-shedule模板,lcworld-gen模板
*   zhihuihouqin-api 接口模块,其中包括参数过滤,sql注入校验,sign值校验,token校验,依賴lcworld-common模块
*   lcworld-common 核心模块 包括dao,service,mapper配置文件,utils工具类等
*   lcworld-gen    代码生成模块,zhihuihouqin-web项目依赖;后台项目启动后,选择代码生成器,选中需要生成的表,即可生成entity、xml、dao、service、html、js、sql,然后放到适当的位置即可;
*   lcworld-shedule 定时任务管理模块,zhihuihouqin-web依赖;
*   lcworld-shiro  权限,用户,角色模块,zhihuihouqin-web 依赖;


### 常见问题:


1.  Tomcat version 7.0 only supports J2EE 1.2, 1.3, 1.4, and Java EE 5 and 6 Web modules:修改项目跟目录下.settings文件夹下org.eclipse.wst.common.project.facet.core.xml文件中
`<installed facet="jst.web" version="3.1"/>` 中version=3.0 然后右键项目刷新;
2. 后台不支持IE8以下浏览器;









	
	








 
 
 
 
 



