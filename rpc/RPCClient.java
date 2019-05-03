
import java.io.*;
import java.net.*;
class RPCClient
{
 public static void main(String[] args) throws Exception
 {
  Socket s = new Socket("localhost", 3000); 
  BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in)); 
  DataOutputStream dout=new DataOutputStream(s.getOutputStream());
  DataInputStream din=new DataInputStream(new BufferedInputStream(s.getInputStream()));  
  System.out.println("Client ready, type and press Enter key");
  String receiveMessage, sendMessage,temp; 
  while(true) 
  {
   System.out.println("\nEnter operation to perform(add,sub,mul,div,stop)....");
   temp = keyRead.readLine();
   sendMessage=temp.toLowerCase(); 
   dout.writeUTF(sendMessage);
   if(sendMessage.compareTo("stop")==0)
   {
     break;
   }
   System.out.println("Enter first parameter :");
   sendMessage = keyRead.readLine(); 
   dout.writeUTF(sendMessage);
   System.out.println("Enter second parameter : ");
   sendMessage = keyRead.readLine(); 
   dout.writeUTF(sendMessage);
   System.out.flush(); 
   if((receiveMessage = din.readUTF()) != null) 
    System.out.println(receiveMessage); 
  }
 }
}