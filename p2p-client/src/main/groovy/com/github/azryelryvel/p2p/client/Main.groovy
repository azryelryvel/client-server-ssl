package com.github.azryelryvel.p2p.client

import javax.net.ssl.SSLSocket
import javax.net.ssl.SSLSocketFactory

class Main {
        static void main(String[] args) {
                SSLSocketFactory sslSocketFactory = SSLSocketFactory.default as SSLSocketFactory
                SSLSocket sslSocket = sslSocketFactory.createSocket("127.0.0.1",1234) as SSLSocket

                DataOutputStream dataOutputStream = new DataOutputStream(sslSocket.outputStream)
                DataInputStream dataInputStream = new DataInputStream(sslSocket.inputStream)

                String str = "helloworld"
                dataOutputStream.writeBytes(str)

                String responseStr
                if((responseStr=dataInputStream.readUTF())!=null) {
                        println 'reponse: ' + responseStr
                }

                dataOutputStream.close()
                dataInputStream.close()
                sslSocket.close()
        }
}
