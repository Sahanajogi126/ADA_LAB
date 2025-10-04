import java.net.*;

public class DatagramSocketClient{
    public static void main(String args[]) throws Exception {
        String line="Connected with Client";
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddressIPAdress=InetAddress.getAByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        sendData=line.getBytes();
        DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAdres,9000);
        clientSocket.send(sendPacket);

        System.out.println("***Client display terminal***");

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String messageRecieved = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
            System.out.println("Message typed at server side is:" + messageRecieved);
        }


    }
}

