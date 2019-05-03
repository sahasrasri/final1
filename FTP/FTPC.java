import java.io.*;
import java.net.*;

class FTPC
{
	Socket s = null;
	String file = "abc.txt";
	ObjectOutputStream out;
	ObjectInputStream in;
	String msg;
 	
	void start()
	{
		System.out.println("Requesting for file: "+file);
		try
		{
			s = new Socket("localhost",2000);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
			clientMessage("Hello!");
			do
			{
				try
				{
					msg = (String) in.readObject();
					System.out.println(msg);
					clientMessage(file);
				}
				catch(Exception e){}
			}while(!msg.equals("bye"));
		}
		catch(IOException e) {System.out.println(e);}
	}
   
	void clientMessage(String str)
	{
		try
		{
			out.writeObject(str);
			out.flush();
		}
		catch(IOException e){System.out.println(e);}
	}
	public static void main(String [] args) throws Exception
	{
		FTPC f = new FTPC();
		f.start();
	}
}
					
