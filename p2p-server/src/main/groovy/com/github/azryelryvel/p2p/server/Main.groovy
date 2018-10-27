package com.github.azryelryvel.p2p.server

import javax.net.ssl.SSLServerSocket
import javax.net.ssl.SSLServerSocketFactory
import javax.net.ssl.SSLSocket

class Main {
	static void main(String[] args) {
		SSLServerSocketFactory sslServerSocketFactory = SSLServerSocketFactory.default as SSLServerSocketFactory
		SSLServerSocket sslServerSocket = sslServerSocketFactory.createServerSocket(1234) as SSLServerSocket
		SSLSocket sslSocket = sslServerSocket.accept() as SSLSocket
		DataInputStream dataInputStream = new DataInputStream(sslSocket.inputStream)
		PrintStream os = new PrintStream(sslSocket.outputStream)
		while(true) {
			String input = dataInputStream.readUTF()
			os.println(input)
		}
	}
}