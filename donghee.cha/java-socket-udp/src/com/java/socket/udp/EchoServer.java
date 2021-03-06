package com.java.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class EchoServer extends Thread {

	private DatagramSocket socket; // use throughout to send packets.
	private boolean running;
	private byte[] buf ;	// to warp our messages.

	EchoServer() throws SocketException {
		
		socket = new DatagramSocket(4445);
	}

	public void run() {
		
		running = true;

		try {

			while (running) {
				
				buf = new byte[256];
				
				DatagramPacket packet = new DatagramPacket(buf, buf.length);

				socket.receive(packet);
				
				
				System.out.println("[server] receive packet : "  + packet + "/n");
				
				InetAddress address = packet.getAddress();
				
				int port = packet.getPort();
				packet = new DatagramPacket(buf, buf.length, address, port);
				
				
				
				String received = new String(packet.getData(), 0, packet.getLength());
				
				System.out.println("[server] receive packet to string : "  + received + "/n");
				

				if (received.equals("end")) {
					running = false;
					continue;
				}
				
				System.out.println("[server] make packet and send : "  + packet + "/n");
				
				socket.send(packet);
				
				System.out.println("---------------------------------------------------------");

			}
			
			socket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
