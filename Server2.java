package Time;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Simple server to make some calculations
 */
public class Server2 extends Thread{
	private boolean running = true;

	public static void main(String[] args) {
		Thread server = new Server2();
		server.start();
	}

	@Override
	public void run() {
		try(ServerSocket socket = new ServerSocket(6789)){
			while(running) {
				Socket connectionSocket = socket.accept();
				DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
				String result = new Date(System.currentTimeMillis()).toString() + "\n";
				outToClient.writeBytes(result);
			}
		} catch (Exception e){
			System.out.println("Sth went wrong!");
		}

	}
}
