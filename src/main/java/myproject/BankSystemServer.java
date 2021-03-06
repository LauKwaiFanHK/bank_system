package myproject;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BankSystemServer {
	public Socket clientSocket;
	public ServerSocket serverSocket;
	public PrintStream out;
    public InputStream in;
    
    public void start(int port, boolean isProVersion) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintStream(clientSocket.getOutputStream(), true);
        in = clientSocket.getInputStream();
        
        BankSystem bankSystem = new BankSystem(in, out);
        bankSystem.mainLoop(isProVersion);
    }
    
    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
