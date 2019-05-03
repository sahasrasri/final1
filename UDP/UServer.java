import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*; 

// Server class 
public class UServer 
{ 
     DatagramSocket ss;
     int id;
     byte[] receiveData;
     InetAddress ip = InetAddress.getByName("localhost");
    public UServer(int b, DatagramSocket a) throws IOException
    {
      this.id = b;
     ss = a;
     System.out.println("Server of process "+ Integer.toString(id));
     receiveData = new byte[1024];
    int i=0;
     while (i<100) 
		{ 
			 DatagramPacket receivePacket = new DatagramPacket(receiveData, 1024);
			try
			{ 
				// socket object to receive incoming client requests 
				ss.receive(receivePacket);
				i++;
			System.out.println("A packet is received");

				// create a new thread object 
				Thread t = new ClientHandler(ss,receivePacket,id); 

				// Invoking the start() method 
				t.start(); 
				String sen = "081"+Integer.toString(0)+"1"; 
		                byte[] send = sen.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(send,send.length,ip,2000+(id%3));
				ss.send(sendPacket);
			} 
			catch (Exception e){ 
				//s.close(); 
				e.printStackTrace(); 
			} 
		} 
	} 
} 

// ClientHandler class 
class ClientHandler extends Thread 
{ 
	DatagramPacket rp;
	DatagramSocket ss;
        int id;
	// Constructor 
	public ClientHandler(DatagramSocket sa,DatagramPacket receivePacket,int i) 
	{ 
	 this.rp = receivePacket;
	 this.id =i;
	 this.ss = sa;
	}

	@Override
	public void run() 
	{ 
 try{
    System.out.println("....Processing.....");
InetAddress ip = InetAddress.getByName("localhost");
	// ss.receive(rp);
String s1 = new String(rp.getData());
          int cid = Character.getNumericValue(s1.charAt(4));
		//System.out.println("!");
		application a = new application(s1);
		String s2 = a.analyse();
		System.out.println("Result "+s2);
		if(s2==null){
			System.out.println("Source ID is :"+Character.toString(s1.charAt(2))+"0");
			System.out.println("Source IP is :"+Character.toString(s1.charAt(2))+"0");}

		else
		{
		//System.out.println("!!");
		 String s = s2.substring(0,4);
	         s = s+Integer.toString(id);
		 byte[] send1 = s.getBytes();
		 if(s2.length()>4)
		 {
		  //System.out.println("!!1");
		   DatagramPacket sendPacket = new DatagramPacket(send1,send1.length,ip,(id+1)%3+2000); //to C,A,B
		   ss.send(sendPacket);	
		   System.out.println("Packet sent to "+ Integer.toString((id+1)%3+2000));
		   DatagramPacket sendPacket1 = new DatagramPacket(send1,send1.length,ip,(id%3)+2000); //to B,C,A
		   ss.send(sendPacket1);	
   System.out.println("Packet sent to "+ Integer.toString((id%3)+2000));
                 }
		else {
			// System.out.println("!!2");
 		  int a1 = id-cid; // >0 clock <0 anticlock
		  int n=0;
		  if(a1==1 || a1==-2)
			n = 2000+(id%3);
 		  else
		    n = (id+1)%3+2000;
		  DatagramPacket sendPacket = new DatagramPacket(send1,send1.length,ip,n);
                       ss.send(sendPacket);	
		}
		}
		}
	catch(Exception e) {
		System.out.println(e);
       }
      }          
} 

