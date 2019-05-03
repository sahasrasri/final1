import java.io.*;
import java.net.*;

class FTPS
{
	ServerSocket ss;
	Socket s = null;
	ObjectOutputStream out;
	ObjectInputStream in;
	String filename="";
	String contents = "";
	File file = null;
	void start()
	{
		try
		{
			ss = new ServerSocket(2000,10);
			System.out.println("Waiting for client request");
			s = ss.accept();
 			System.out.println("A client is connected "+s);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
			serverMessage("HI");
		do{
			try
			{
			filename = (String) in.readObject();
			File file = new File(filename);								FileInputStream fin = new FileInputStream(file);
			DataInputStream din = new DataInputStream(fin);
			while((contents = din.readLine())!=null)
			{
				System.out.println("Sending.."+contents);
				serverMessage(contents);
			}
			//if(filename.equals("bye"))
				serverMessage("Bye!");
			}
			catch(Exception e) {}
		}while(!filename.equals("bye"));
		}
		catch(IOException e) {}
  		finally
		{
			try
			{
				in.close();
				out.close();
				ss.close();
			}
			catch(IOException e) { System.out.println(e); }
		}
	}
 	void serverMessage(String str) throws IOException
	{
		try
		{
  			out.writeObject(str);	
			out.flush();
		}
		catch(IOException e) { System.out.println(e); }
  	}
	public static void main(String [] args) throws UnknownHostException
	{
		FTPS f = new FTPS();
		while(true)
		{
 			try
			{
				f.start();
			}
			catch(Exception e){ System.out.println(e); }
		}
	}
}

		