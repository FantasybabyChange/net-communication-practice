# Netty3 Chat protobuf
该project和[netty3 chat demo](../chat_netty3/)类似,不过在序列化和反序列化方面使用了protobuf.
``` java
RegisterRequest registerRequest = PlayerModule.RegisterRequest.parseFrom(data);
```