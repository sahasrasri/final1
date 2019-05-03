import java.net.*;
import java.io.*;

class B
{
	//String ip = 'a';
	public static void main(String [] args) throws Exception
	{
		DatagramSocket cs = new DatagramSocket(2001);
		InetAddress ip = InetAddress.getByName("localhost");
		byte[] send = new byte[1024];
		byte[] receive = new byte[1024];
  		int n=0;
		String sen = "082"+Integer.toString(n)+"2"; 
		send = sen.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(send,send.length,ip,2002);
		cs.send(sendPacket);
    		UServer s = new UServer(2,cs);
		
	}
}