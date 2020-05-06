package HomePackage;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import static java.io.BufferedReader.*;

public class Client {

    // initializing the socket, DataInputStream  and DataOutputStream
   private Socket socket = null ;
   private DataInputStream input =null;
   private DataOutputStream out = null;

    // constructor with the ip address and port as parameter
    public Client(String address, int port) {

        try {

            socket = new Socket(address, port);
            System.out.println("*********************");
            System.out.println("Connection is established !");
            // taking input form the client
           input = new DataInputStream(System.in);
           // BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            // sending output to the socket
            out = new DataOutputStream(socket.getOutputStream());

            // handling exceptions
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //need the string to read the input message
        String message = "";

        while (!message.equals("exit") && !message.equals("Exit")) {

            try {
                message = input.readLine();
                out.writeUTF(message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // closing the connection
       try{
            input.close();
            out.close();
           socket.close();
        }
       catch (IOException i) {
           System.out.println(i);

       }
    }
    // Client main method

        public static void main(String[]args) {

        Client client = new Client(  "127.0.0.1"    , 9081);

         }
         }
