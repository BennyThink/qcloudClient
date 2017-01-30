# qcloudClient
一个使用Java编写的腾讯云本地客户端<br>
开发工具：NetBeans

#这是啥#
一个方便管理腾讯云服务器的Java应用程序，尤其是那些有着多个学生优惠的童鞋

#下载#
[GitHub Release](https://github.com/BennyThink/qcloudClient/releases "GitHub Release")

#使用条件与方法#
需要安装JDK或者JRE，解压缩然后双击`qcloudClient.jar`,如无法运行，Windows双击`start.bat`, Linux切换到对应目录执行`sh start.sh`<br>
详细说明[戳我啦](https://www.bennythink.com/qclient.html "土豆不好吃")

# 更新日志 #
* 2017年1月25日 修复了创建快照时的逻辑错误、删除快照时的处理方式
* 2017年1月27日 修复所有已知bug、提升操作性
* 2017年1月30日 乱码处理

#功能#
* 查询实例
* 开机
* 关机
* 重启
* 查询快照
* 创建快照
* 删除快照
* 恢复快照
* 重装系统（Haven't tested yet.）

#关于乱码的一些说明#
Windows默认是使用ANSI（或者说GB2312更适合），而NetBeans默认使用UTF-8；
默认已经能够识别大部分编码了，如果错误，请手动转换成自己平台的ANSI！

##许可证##
GPL v2, thanks to JSON.org, Mozilla.org's chardet!
