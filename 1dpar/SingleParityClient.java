import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.*;
public class SingleParityClient{
 
public static void main(String args[])
{
	
	 Socket socket            = null; 
	    DataInputStream  input   = null; 
	     DataOutputStream out     = null; 
	Scanner sc=new Scanner(System.in);
System.out.println("Enter Length of Message:");
int h=sc.nextInt();
int[] d=new int[h+1];
System.out.println("Enter data bits:");
for(int i=0;i<h;i++)
{
	d[i]=sc.nextInt();
}
int i=0,sum=0;
for(i=0;i<h;i++) {
	
		sum+=d[i];
		}
if(sum%2==0)
	d[h]=0;
else
	d[h]=1;

try
{ 
    socket = new Socket("localhost",5000); 
    System.out.println("Connected"); 


    input  = new DataInputStream(System.in);  
    out    = new DataOutputStream(socket.getOutputStream()); 
} 
catch(UnknownHostException u) 
{ 
    System.out.println(u); 
} 
catch(IOException ex) 
{ 
    System.out.println(ex); 
} 

for(i=0;i<=h;i++)
{
		 try
    { 
        out.writeUTF(Integer.toString(d[i])); 
        
    } 
    catch(IOException ex) 
    { 
        System.out.println(ex); 
    } 
}

try
{ 

out.writeUTF(Integer.toString(9)); 
} 
catch(IOException ex) 
{ 
System.out.println(ex); 
} 
try
{ 
    input.close(); 
    out.close(); 
    socket.close(); 
} 
catch(IOException ex) 
{ 
    System.out.println(ex); 
} 
System.out.println("The Simple Parity is:\n");
for(i=0;i<=h;i++)

		System.out.print(d[i]+ " ");

} 

}		

