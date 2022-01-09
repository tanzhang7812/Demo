package com.bo.ch1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private static final String HOST="127.0.0.1";
	private static final int PORT=8000;
	private static final int SLEEP_TIME=5000;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		final Socket socket=new Socket(HOST,PORT);
		new Thread(()->{
			System.out.println("Client start");
			while(true) {
				String message="hellow world";
				System.out.println("client send message:"+message);
				try {
					socket.getOutputStream().write(message.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				sleep();
			}
		}).start();
	}

	private static void sleep() {
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
