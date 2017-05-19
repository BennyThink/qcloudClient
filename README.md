# qcloudClient
一个使用Java编写的腾讯云本地客户端<br>
开发工具：NetBeans

# 这是啥 #
一个方便管理腾讯云服务器的Java应用程序，尤其是那些有着多个学生优惠的童鞋。可以跨平台使用。

# 下载 #
[GitHub Release](https://github.com/BennyThink/qcloudClient/releases "GitHub Release")

# 使用条件与方法 #
需要安装JDK或者JRE，解压缩然后双击`qcloudClient.jar`,如无法运行，那就切换到对应的目录运行`java -jar qcloudClient.jar`即可。
详细说明[戳我啦](https://www.bennythink.com/qclient.html "土豆不好吃")

# 功能 #
* 查询实例
* 开机
* 关机
* 重启
* 查询快照
* 创建快照
* 删除快照
* 恢复快照
* 重装系统（从Windows重装为Linux时，会更换磁盘ID导致无法恢复快照，请谨慎操作）

# Fix #
* 增加云硬盘判断（只有云硬盘才能创建快照）
* 修复多台主机快照状态判断错误

# 关于乱码的一些说明 #
Windows默认是使用ANSI（或者说GB2312更合适），而NetBeans默认使用UTF-8；
默认已经能够识别大部分编码了，如果错误，请手动转换成自己平台的默认编码！

## 后续计划 ##
我大概想不出来什么后续计划了...这小玩意已经基本满足了我的需求。

## 许可证 ##
GPL v2, thanks to JSON.org, Mozilla.org's chardet!
