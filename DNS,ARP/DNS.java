import java.net.*;
import java.io.*;
import java.util.*;

public class DNS
{
 public static void main(String[] args) 
 {
  int n;
  Scanner sc = new Scanner(System.in);
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  do
  {
   System.out.println("\n Menu: \n 1. DNS 2. Reverse DNS 3.MAC 4. Exit \n");
   System.out.println("\n Enter your choice");
   n = Integer.parseInt(sc.nextLine()); 
   if(n==1)
   {
    try 
    {
     System.out.println("\n Enter Host Name ");
     String hname=in.readLine();
     InetAddress address;
     address = InetAddress.getByName(hname);
     System.out.println("Host Name: " + address.getHostName());
     System.out.println("IP: " + address.getHostAddress());
    } 
    catch(IOException ioe) 
    {
    System.out.println(ioe);
    }
   }
   if(n==2)
   {
    try 
    {
       System.out.println("\n Enter IP address");
       String ipstr = in.readLine();
       InetAddress ia = InetAddress.getByName(ipstr);
       System.out.println("IP: "+ipstr);
       System.out.println("Host Name: " +ia.getHostName());
     } 
    catch(IOException ioe) 
    {
     System.out.println(ioe);
    }
   }
   if(n==3)
   {
    try 
    {
       System.out.println("\n Enter IP address");
       String ipstr = sc.nextLine();
       InetAddress ia = InetAddress.getByName(ipstr);
	NetworkInterface ne = NetworkInterface.getByInetAddress(ia);
        byte[] mac = ne.getHardwareAddress();
	StringBuilder sb =  new StringBuilder();
	for(int i=0;i<mac.length;i++)
 	      sb.append(String.format("%02X%s", mac[i], (i<mac.length-1) ? "-" : ""));
       System.out.println("MAC id: " +sb.toString());
     } 
    catch(IOException ioe) 
    {
     System.out.println(ioe);
    }
   }
  }while(!(n==4));
 }
}