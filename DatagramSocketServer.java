import java.net.*;
import java.io.*;

class DatagramSocketServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket serversocket = new DatagramSocket(9999);
        BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            byte buf[] = new byte[1024];
            String str = din.readLine();
            buf = str.getBytes();
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            DatagramPacket dp = new DatagramPacket(buf, str.length(), ip, 1000);
            serversocket.send(dp);
        }
    }
}
