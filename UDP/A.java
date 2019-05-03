import java.net.*;
import java.io.*;

class A
{
	//String ip = 'a';
	public static void main(String [] args) throws Exception
	{
		DatagramSocket cs = new DatagramSocket(2000);
		InetAddress ip = InetAddress.getByName("localhost");
		byte[] send = new byte[1024];
		byte[] receive = new byte[1024];
  		int n=0;
		String sen = "081"+Integer.toString(n)+"1"; 
		send = sen.getBytes();
	    DatagramPacket sendPacket = new DatagramPacket(send,send.length,ip,2001);
		cs.send(sendPacket);
    		UServer s = new UServer(1,cs);
	}
}