package com.github.azryelryvel.p2p.client

import javax.net.ssl.SSLSocket
import javax.net.ssl.SSLSocketFactory

class Main {
        static void main(String[] args) {
                SSLSocketFactory sslSocketFactory = SSLSocketFactory.default as SSLSocketFactory
                SSLSocket sslSocket = sslSocketFactory.createSocket("127.0.0.1",1234) as SSLSocket

	Thread.start {
		println 'Starting reader thread'
		while(true) {
			Reader reader = sslSocket.inputStream.newReader()
			String line
			while ((line = reader.readLine()) != null) {
				println "Received: $line"
			}
		}
	}
	while(true) {
		print 'Sending: '
		String input = new Scanner(System.in).next()
		sslSocket.outputStream.withWriter { Writer writer ->
			writer.write(input + '\n')
			writer.flush()
		}
	}
                sslSocket.close()
        }
}
