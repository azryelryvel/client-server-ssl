package com.github.azryelryvel.p2p.client;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;

class CommandClient {
	private String remoteHost;
	private int remotePort;
	private Socket socket;

	CommandClient(String remoteHost, int remotePort) {
		this.remoteHost = remoteHost;
		this.remotePort = remotePort;
	}

	void connect() throws IOException {
		SocketFactory socketFactory = SSLSocketFactory.getDefault();
		socket = socketFactory.createSocket(remoteHost, remotePort);
	}

	void request(String request) throws IOException {
		if (socket == null) {
			throw new IllegalArgumentException("Socket is null");
		}

		OutputStream os = null;
		InputStream is = null;

		try {
			os = socket.getOutputStream();
			is = socket.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (os == null || is == null) {
			throw new IOException("Could not initialize i/o streams");
		}

		System.out.println("Sending : " + request);
		PrintWriter out = new PrintWriter(os, true);
		out.write(request + "\n");
		out.flush();

		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		String answer = in.readLine();
		System.out.println("Got answer: " + answer);
	}

	void disconnect() throws IOException {
		socket.close();
	}
}
