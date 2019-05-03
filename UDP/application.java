import java.io.*;

public class application
{
  // ID = {10,20,30};
  //clr = { red-0,blue-1,green-2};
  char clr;
  char ttl;
  char src;
  char seq;
  application(String s)
  {
   this.clr = s.charAt(0);
   this.ttl=s.charAt(1);
   this.src = s.charAt(2);
   this.seq=s.charAt(3);
  }
  String analyse()
  {
    String s = null;
    if(clr=='0')
    {
      System.out.println("Packet colour is RED");
      String t = Integer.toString(Character.getNumericValue(ttl)-1);
      s = "2"+t+Character.toString(src)+Character.toString(seq);
      s = s+s;
      //application a1 = new application(2,ttl,1,10);
      //application a2 = new application(2,ttl,1,10);
    }
    else if(clr=='2')
    { 
     System.out.println("Packet colour is GREEN");
     String t = Character.toString(ttl);
     int n = (int)Math.random();
     if(n==0)
        t = Integer.toString(Character.getNumericValue(ttl)-1);
     if(ttl=='0')
	s = "1"+t+Character.toString(src)+Character.toString(seq);
	//application a1 = new application(2,ttl,1,10);
     else
	s = "2"+t+Character.toString(src)+Character.toString(seq);
    }
   else
      System.out.println("Packet colour is BLUE");
   return s;
   }
}
	
 
 