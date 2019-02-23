package com.github.azryelryvel.p2p.worker;

class Main {
	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 1234;
		String torrent = "http://releases.ubuntu.com/18.04/ubuntu-18.04.2-live-server-amd64.iso.torrent";

		new CommandServer(host, port).run();
	}
}