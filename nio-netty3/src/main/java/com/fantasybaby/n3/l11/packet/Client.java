package com.fantasybaby.n3.l11.packet;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Client {

	public static void main(String[] args) throws Exception {
		Thread thread1 = new Thread(() -> {
			Socket socket = null;
			try {
				socket = new Socket("127.0.0.1", 10101);
			} catch (IOException e) {
				e.printStackTrace();
			}

			String message = "hello";

			byte[] bytes = message.getBytes();

			ByteBuffer buffer = ByteBuffer.allocate(4 + bytes.length);
			buffer.putInt(bytes.length);
			buffer.put(bytes);

			byte[] array = buffer.array();
			for (int i = 0; i < 1000; i++) {
				try {
					socket.getOutputStream().write(array);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		Thread thread = new Thread(() -> {
			String message1 = "hello2";

			byte[] bytes1 = message1.getBytes();
			Socket socket1 = null;
			try {
				socket1 = new Socket("127.0.0.1", 10101);
			} catch (IOException e) {
				e.printStackTrace();
			}

			ByteBuffer buffer1 = ByteBuffer.allocate(4 + bytes1.length);
			buffer1.putInt(bytes1.length);
			buffer1.put(bytes1);
			byte[] array1 = buffer1.array();
			for (int i = 0; i < 1000; i++) {
				try {
					socket1.getOutputStream().write(array1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				socket1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		thread.start();
		thread1.start();
		thread.join();
		thread1.join();


	}

}
