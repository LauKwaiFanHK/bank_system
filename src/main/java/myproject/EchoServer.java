package myproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public Socket clientSocket;
	public ServerSocket serverSocket;
	public PrintWriter out;
    public BufferedReader in;
    
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        print("Hey,it is your bank assistant,we are happy to see you!");
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
	        switch (inputLine) {
	        case "login":
	        	print("Please enter your name");
	        }
        }
    }
    
    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static void main(String[] args) {
        EchoServer server=new EchoServer();
        try {
        	server.start(4444);
        } catch (IOException e) {
        	System.out.println(e);
        }
    }
    
    public void print(String string) {
    	out.println(string);
    }
}
