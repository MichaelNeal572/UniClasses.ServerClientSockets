package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;

public class client {
	private ObjectOutputStream output;
	private ObjectInputStream input;

	private Socket conn;
	private int radius=20;
	private double area;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		client newClient=new client();
		newClient.runClient();
	}
	public void runClient() {
		try{
			conn=new Socket("Localhost",12345);
			System.out.println("Connected to the server..");
			
			output=new ObjectOutputStream(conn.getOutputStream());
			output.writeInt(this.radius);
			output.flush();
			input=new ObjectInputStream(conn.getInputStream());
			this.area=input.readDouble();
			System.out.println("The area of a circle with a radius of "+this.radius+" is "+this.area);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
