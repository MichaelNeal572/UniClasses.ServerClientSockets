package networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	private final Double PI=3.14;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket serverSock;
	private Socket conn;
	private int radius;
	private double area;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		server newServer = new server();
		newServer.runServer();
	}
	public void runServer() {
		try {
		serverSock = new ServerSocket(12345,100);
		System.out.println("Server is running..");
		conn = serverSock.accept();
		output = new ObjectOutputStream(conn.getOutputStream());
		output.flush();
		input = new ObjectInputStream(conn.getInputStream());
		
		this.radius= input.readInt();
		this.area=radius*radius*PI;
		//System.out.println(this.area);
		output.writeDouble(this.area);
		output.flush();
		}
		catch(IOException ioException) {
			ioException.printStackTrace();
		}
	}
}
