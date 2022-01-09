# Netty Demo
## Component
### 1.NioEventLoop
it could start two kinds of thread, one could listen connection from client, another could process read & write from client.
### 2.Channel
wrap connection, could read & write via channel.
### 3.Pipeline
corresponding to logic process chain.
### 4.ChannelHandler
each chain is one ChannelHandler.
### 5.ByteBuf
read & write operator base on ByteBuf.


## the process of Netty Server Start
### 1. Create Server Side's Channel.
invoke JDK api to create channel, netty encapsulate it as netty channel and bind some component.

### 2.Initialize Server Side's Channel.
like init some attribute ,add some logic handler.

### 3.Register Selector.
register JDK channel to Selector. bind Server side's channel to JDK server side channel.

### 4.Bind port.


