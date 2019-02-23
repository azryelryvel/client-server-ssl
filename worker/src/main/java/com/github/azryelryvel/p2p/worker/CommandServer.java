package com.github.azryelryvel.p2p.worker;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CommandServer implements Runnable {
	private final static int MAX_QUEUED_CONNECTIONS = 20;
	private String host;
	private int port;

	CommandServer(String host, int port) {
		this.host = host;
		this.port = port;
	}

	@Override
	public void run() {
		ServerSocketFactory sslSocketFactory = SSLServerSocketFactory.getDefault();
		try {
			ServerSocket serverSocket = sslSocketFactory.createServerSocket(port, MAX_QUEUED_CONNECTIONS, InetAddress.getByName(host));
			System.out.println("Server started on " + host + ":" + port + " and ready for connections");

			while (true) {
				Socket clientSocket = serverSocket.accept();
				new Thread(new ClientConnection(clientSocket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
