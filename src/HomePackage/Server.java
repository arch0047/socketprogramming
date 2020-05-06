package HomePackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket socket = null;
    private ServerSocket serverSoc = null;
    private DataInputStream cInputStream = null;

    public Server(int port) {


        // server starts and wait for the client's input
        try {
            serverSoc = new ServerSocket(port);
            System.out.println("*********************");
            System.out.println(" Server is started on port:" + port +" And waiting for the client's response...!");
            System.out.println("*********************");
            socket = serverSoc.accept();
            System.out.println("Connection with the client is accepted.");

            // input form the client (cInputStream = client input stream)
            cInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));


            String cMessage = "";
            while (!cMessage.equals("exit") && ! cMessage.equals("Exit")) {

                try {
                    cMessage = cInputStream.readUTF();
                    System.out.println(cMessage);

                } catch (IOException e) {
                    System.out.println(e);
                }
            }

            // closing the connection
            System.out.println("*********************");
            System.out.println("Socket is closing !");
            socket.close();
            cInputStream.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

               // server main method
    public static void main(String[] args) {

       Server server = new Server(9081);

    }
}
