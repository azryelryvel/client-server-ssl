package com.github.azryelryvel.p2p.server

import javax.net.ssl.SSLServerSocket
import javax.net.ssl.SSLServerSocketFactory
import javax.net.ssl.SSLSocket

class Main {
	static void main(String[] args) {
		SSLServerSocket serverSocket = SSLServerSocketFactory.default.createServerSocket(1234) as SSLServerSocket

		while (true) {
			SSLSocket socket = serverSocket.accept() as SSLSocket

			println 'Incoming connection from ' + socket.inetAddress.canonicalHostName + ":" + socket.port
			Reader reader = socket.inputStream.newReader()

			String line
			while ((line = reader.readLine()) != null) {
				println "Received: $line"
				println "Sending: $line"
				Writer writer = socket.outputStream.newPrintWriter()
				writer.write(line + '\n')
				writer.flush()
			}
		}

	}
}