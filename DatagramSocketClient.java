Client Side Program (DatagramSocketClient.java)	
import java.io.*; 
import java.net.*; 
import java.util.*; 
public class DatagramSocketClient { 
public static void main(String args) throws Exception { 
DatagramSocket clientSocket = new DatagramSocket(); 
InetAddress IPAddress = InetAddress.getLocalHost(); 
byte sendData = new byte; 
byte receiveData = new byte; 
Scanner in = new Scanner(System.in);
System.out.println("Type 'Connected with Client:'"); /* Create the send datagram packet */ 
while(true) { 
String clientSentence = in.nextLine(); 
sendData = clientSentence.getBytes(); 
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9090); 
clientSocket.send(sendPacket); /* Receive the packet using client socket */
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
clientSocket.receive(receivePacket); /* Convert the message received into the string */
String messageReceived = new String(receivePacket.getData(), 0, receivePacket.getLength());
System.out.println("Message received at client side is: " + messageReceived);
} 
} 
}
