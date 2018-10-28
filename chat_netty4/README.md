# Netty4 Chat
相比于[netty3 chat demo](../chat_netty3/),netty4chat要修改底层的实现
一些底层的方法由于做了封装所有不需要改动
- channel的一些方法改变
```
@Override
	public void write(Object message) {
		channel.writeAndFlush(message);
	}
	@Override
	public boolean isConnected() {
		return channel.isActive();
	}
	@Override
    public void setAttachment(Object attachment) {
        channel.attr(ATTACHMENT_KEY).set(attachment);
    }
```
- 启动的一些改变
```
        EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			// 设置循环线程组事例
			b.group(bossGroup, workerGroup);

			// 设置channel工厂
			b.channel(NioServerSocketChannel.class);

			// 设置管道
			b.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new RequestDecoder());
					ch.pipeline().addLast(new ResponseEncoder());
					ch.pipeline().addLast(new ServerHandler());
				}
			});
```
- ChannelBuffer变成ByteBuffer
```
//3.0
public static ChannelBuffer getBuffer() {
		ChannelBuffer dynamicBuffer = ChannelBuffers.dynamicBuffer();
		return dynamicBuffer;
	
//4.0
UnpooledByteBufAllocator
PooledByteBufAllocator //需要释放对象
//释放buffer
ReferenceCountUtil.release(writeBuffer);

private static ByteBufAllocator bufAllocator = PooledByteBufAllocator.DEFAULT;
public static ByteBuf getBuffer() {
		ByteBuf buffer = bufAllocator.heapBuffer();
		buffer = buffer.order(BYTE_ORDER);
		return buffer;
```
- 写法的改变
```
FrameDecoder	->	ByteToMessageDecoder

OneToOneEncoder	->	MessageToByteEncoder

4.0和5.0的区别messageReceive		channelRead0//(netty5里面是messageReceive)
```
- 4.0的业务线程池可以自己有序处理
```
  EventLoopGroup cookerGroup = new NioEventLoopGroup();
  ch.pipeline().addLast(cookerGroup,new ServerHandler());
```