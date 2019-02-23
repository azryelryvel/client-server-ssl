package com.github.azryelryvel.p2p.client;

import java.io.IOException;

class Main {
	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 1234;

		try {
			CommandClient client = new CommandClient(host, port);
			client.connect();
			client.request("test");
			client.disconnect();
		} catch (IOException e) {
			System.out.println("Error during request: " + e.getMessage());
		}
	}
}
