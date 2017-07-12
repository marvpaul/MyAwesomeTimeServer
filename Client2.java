package Time;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Just a simple client
 */
public class Client2 extends Thread {
	boolean running = true;
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Thread client = new Client2();
		client.start();
	}

	@Override
	public void run() {
		while(running){
			try(Socket clientSocket = new Socket("localhost", 6789)){

				DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
				BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

				outToServer.writeBytes(sc.nextLine() + '\n');
				String result = inFromServer.readLine();
				System.out.println(result);
			} catch (Exception e){
				System.out.println("Server not reachable!");
				running = false;
			}
		}


	}
}
