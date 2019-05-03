import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.*;
public class SingleParityServer {
public static void main(String args[])
{
	Socket          socket   = null; 
  ServerSocket    server   = null; 
   DataInputStream in       =  null; 
   int[] d=new int[50];
   int p=0,n=0;
   try
   { 
       server = new ServerSocket(5000); 
       System.out.println("Server started"); 

       System.out.println("Waiting for a client ..."); 

       socket = server.accept(); 
       System.out.println("Client accepted"); 

       in = new DataInputStream( 
           new BufferedInputStream(socket.getInputStream())); 

String line1="";
       while (!(line1= in.readUTF()).equals(Integer.toString(9))) 
       { 
           try
           { 

               d[p]=Integer.parseInt(line1);
               p++;
           } 
           catch(Exception ex) 
           { 
               System.out.println(ex); 
           } 
    
       } 
       System.out.println("Closing connection"); 

       socket.close(); 
       in.close(); 
   } 
   catch(IOException i) 
   { 
       System.out.println(i); 
   } 
   
   Scanner sc=new Scanner(System.in);
int k=9;
n=p-1;
int sum=0,i=0;
for(i=0;i<n;i++) {
	
		sum+=d[i];
		}
if(sum%2==d[n])
	k=0;
else
{
	k=1;
}

System.out.println("The Simple Parity is:\n");
for(i=0;i<=n;i++)
{
		System.out.print(d[i]+ " ");
	}
if(k==1)
	System.out.println("\nError Detected");
else
	System.out.println("\nNo Error Detected");

}		
}
