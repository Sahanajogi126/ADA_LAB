Server Side Program (DatagramSocketServer.java)	
import java.io.*; 
import java.net.*; 
import java.util.*;
 public class DatagramSocketServer { 
public static void main(String args) throws Exception {
 Scanner in = new Scanner(System.in); DatagramSocket serverSocket = new DatagramSocket(9090); 
byte receiveData = new byte; byte sendData = new byte; System.out.println("Server Side ***"); 
    System.out.println("Create the receive datagram packet"); /* Receive packet using server socket */ 
    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); serverSocket.receive(receivePacket); /* Extract sender address and port */
    InetAddress IPAddress = receivePacket.getAddress(); int port = receivePacket.getPort(); 
    System.out.println("Server is running on port: " + serverSocket.getLocalPort()); 
    while(true) { /* Convert received message to String */ 
        String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Message received from client side is: " + sentence);
        System.out.println("Type some message to display at client end"); String serverSentence = in.nextLine(); 
        sendData = serverSentence.getBytes(); /* Create send packet using client's address and port */ 
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port); 
        serverSocket.send(sendPacket); /* Prepare for next receive */ 
        receiveData = new byte; receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket); 
    } 
   } 
 }
