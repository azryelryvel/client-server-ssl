package com.github.azryelryvel.p2p.client

import javax.net.ssl.SSLSocket
import javax.net.ssl.SSLSocketFactory

class Main {
        static void main(String[] args) {
                SSLSocketFactory sslSocketFactory = SSLSocketFactory.default as SSLSocketFactory
                SSLSocket sslSocket = sslSocketFactory.createSocket("127.0.0.1",1234) as SSLSocket
	sslSocket.outputStream << "hello world"
                sslSocket.close()
        }
}
