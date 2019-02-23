package com.github.azryelryvel.p2p.worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

class ClientConnection implements Runnable {
	private Socket clientSocket;

	ClientConnection(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public void run() {
		if (clientSocket == null) {
			throw new IllegalArgumentException("Can't establish a connection from a null socket");
		}
		System.out.println("Incoming connection from " + clientSocket.getInetAddress().getCanonicalHostName() + ":" + clientSocket.getPort());

		try {
			OutputStream os = clientSocket.getOutputStream();
			InputStream is = clientSocket.getInputStream();

			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			PrintWriter out = new PrintWriter(os, true);

			String line;
			while ((line = in.readLine()) != null) {
				System.out.println("Received: " + line);
				System.out.println("Sending: " + line);
				out.write(line + '\n');
				out.flush();
			}
			System.out.println(clientSocket.getInetAddress().getCanonicalHostName() + ":" + clientSocket.getPort() + " disconnected");
			clientSocket.close();
		} catch (IOException e) {
			// TODO: LOGGING
			System.out.println(clientSocket.getInetAddress().getCanonicalHostName() +  ":" + clientSocket.getPort() + ": " + e.getMessage());
		}
	}
}
