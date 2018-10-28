package com.github.azryelryvel.p2p.server

import javax.net.ssl.SSLServerSocket
import javax.net.ssl.SSLServerSocketFactory
import javax.net.ssl.SSLSocket

class Main {
	static void main(String[] args) {
		SSLServerSocket serverSocket = SSLServerSocketFactory.default.createServerSocket(1234) as SSLServerSocket

		while (true) {
			SSLSocket socket = serverSocket.accept() as SSLSocket

			socket.inputStream.eachLine {
				println it
			}
		}
	}
}