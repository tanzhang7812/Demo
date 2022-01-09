package com.bo.ch2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.AttributeKey;

public class Server {
	public static void main(String[] args) throws InterruptedException {
		EventLoopGroup boosGroup=new NioEventLoopGroup(1);
		EventLoopGroup workerGroup=new NioEventLoopGroup();
		
		try {
			ServerBootstrap sb = new ServerBootstrap();
			sb.group(boosGroup, workerGroup).channel(NioServerSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)
					.childAttr(AttributeKey.newInstance("childAttr"), "childAttrValue").handler(new ServerHandler())
					.childHandler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel ch) throws Exception {

						}
					});
			ChannelFuture f = sb.bind(8888).sync();
			f.channel().closeFuture().sync();
		} finally {
			boosGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
		
	}
}
