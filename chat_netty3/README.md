# Netty3 Chat
客户端和服务端使用统一的报文协议,handler的调用通过spring启动时扫描注解完成一个类似于SpringMvc的形成,来解耦业务调用.
``` java    
    @SocketCommand
    @SocketModule
```
## server
- server接受不同指令跳转不同的handle
- 登录成功后给在每个channel用attachment绑定一个当前用户
- 登陆成功的session放在session
``` java
SessionManager.putSession(player.getPlayerId(), session)
```
* 登陆成功后消息的发送给某个用户和所有用户就是通过channel.writer()来发送消息即可

## client
通过一个简单的UI完成对用户事件的监听


