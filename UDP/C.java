import java.net.*;
import java.io.*;

class C
{
	//String ip = 'a';
	public static void main(String [] args) throws Exception
	{
		DatagramSocket cs = new DatagramSocket(2002);
		InetAddress ip = InetAddress.getByName("localhost");
		byte[] send = new byte[1024];
		byte[] receive = new byte[1024];
  		int n=0;
		String sen = "083"+Integer.toString(n)+"3"; 
		send = sen.getBytes();
DatagramPacket sendPacket = new DatagramPacket(send,send.length,ip,2000);
		cs.send(sendPacket);
    		UServer s = new UServer(3,cs);	
	}
}