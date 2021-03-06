package com.java.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EchoClient {
	
	
	private DatagramSocket socket;
	private InetAddress address;
	
	private byte[] buf;
	
	EchoClient() throws SocketException, UnknownHostException{
		socket = new DatagramSocket();
		address = InetAddress.getByName("localhost");
	}
	
	public String sendEcho(String msg) throws IOException {
		
		System.out.println("[client] make packet");
		buf = msg.getBytes();
		DatagramPacket packet
			= new DatagramPacket(buf, buf.length, address, 4445);
		
		System.out.println("[client] send packet : " + packet);
		
		socket.send(packet);
		
		packet = new DatagramPacket(buf, buf.length);
		
		socket.receive(packet);
		
		System.out.println("[client] receive packet : " + packet);
		
		String received = new String (
				packet.getData(), 0, packet.getLength());
		
		System.out.println("[client] received packet to string : " + received);
		
		System.out.println("---------------------------------------------------------");
		
		return received;
			
	}
	
	public void close() {
        socket.close();
    }
	
	

}
