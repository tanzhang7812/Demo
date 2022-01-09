package com.bo.ch1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static final int PORT=8000;
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		Server server=new Server(PORT);
		server.start();
	}
	public Server(int port) {
		try {
			this.serverSocket=new ServerSocket(port);
		}catch (IOException e) {
			// TODO: handle exception
		}
	}
	public void start() {
		new Thread(()->{
			doStart();
		}).start();
	}
	private void doStart() {
		while(true) {
			try {
				Socket client = serverSocket.accept();
				new ClientHandler(client).start();
			} catch (IOException e) {
				System.out.println("server exception");
			}
		}
		
	}
}
