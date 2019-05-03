import java.io.*;
import java.util.*;
class HamGen
{
    public static void main (String[] args) {
        System.out.println("Enter input message");
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        String bin="";
        char[] chars = ip.toCharArray();
        int i=0;
        for(char ch : chars)
            bin+= Integer.toBinaryString(ch);
        encode(bin);
    }
    static void encode(String ip)
    {
       int l = ip.length();
       System.out.print("Message before encoding :");
       for(int i=0;i<l;i++)
       System.out.print(ip.charAt(i));
       int r = 4;
       while(Math.pow(2,r)<l+r+1)
         r++;
        char red[] = new char[r];
       StringBuilder sb = new StringBuilder(ip);
       sb.reverse();
        for(int i=0 ;i<r;i++)
          sb.insert((int)Math.pow(2,i)-1,'2');
        ip = sb.toString();
        System.out.println("");
        String[] s = ip.split("");
        int[] integers = new int[s.length];
       for(int i=0;i<s.length;i++)
        {
            //System.out.print(s[i]);
           integers[i]+= Integer.parseInt(s[i]); 
           int k=1;
            while(k<=r)
            {
            int j = (int)Math.pow(2,k);
            int n = (i+1)%j;
            if((n>=j/2)&&(n<j))
            {
              integers[j/2-1]+=integers[i];
              integers[j/2-1]= integers[j/2-1]%2;
            }
            k++;
            } 
        }
        System.out.print("Message after encoding(Hamming code):");
        for(int o : integers)
         System.out.print(o);
        System.out.println("\nPowers of 2 is taken from left to right in above hamming code");
        
    }
}

