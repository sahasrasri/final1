import java.io.*;
import java.net.*;
class RPCServer
{ 
 public static void main(String[] args) throws Exception 
 { 
  ServerSocket ss = new ServerSocket(3000); 
  System.out.println("Server ready"); 
  Socket s = ss.accept( ); 
  DataInputStream din =new DataInputStream(new BufferedInputStream(s.getInputStream()));  
  DataOutputStream dout =new DataOutputStream(s.getOutputStream());  
  
  String receiveMessage, sendMessage,fun;
  int a,b,c;
  while(true) 
  {
   fun = din.readUTF();
  if(fun.compareTo("stop")==0)
   {
    break;
    }
   
   if(fun != null) 
    System.out.println("Operation : "+fun);
   a = Integer.parseInt(din.readUTF());
   System.out.println("Parameter 1 : "+a);
   b = Integer.parseInt(din.readUTF());
   System.out.println("Parameter 2 : "+b);
   if(fun.compareTo("add")==0)
   {
    c=a+b;
    System.out.println("Addition = "+c);
    dout.writeUTF("Addition is:"+c); 
   }
   if(fun.compareTo("sub")==0)
   {
    c=a-b;
    System.out.println("Substraction = "+c);
    dout.writeUTF("Substraction is:"+c); 
    }
   if(fun.compareTo("mul")==0)
   {
    c=a*b;
    System.out.println("Multiplication = "+c);
    dout.writeUTF("Multiolication is:"+c); 
     }
   if(fun.compareTo("div")==0)
   {
    if(b==0)
    {
      System.out.println("Division with 0");
      dout.writeUTF("Division with 0");
    }
    else
    {
    c=a/b;
    System.out.println("Division = "+c);
    dout.writeUTF("Division is:"+c); 
    }
    }
   System.out.flush();
  } 
 } 
}