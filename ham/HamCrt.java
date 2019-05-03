import java.io.*;
import java.util.*;
class HamCrt
{
    public static void main (String[] args) {
        System.out.println("Enter received code");
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        decode(ip);
    }
    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<Integer, Integer> > list = 
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
    static void decode(String ip)
    {
        String[] s = ip.split("");
        int[] integers = new int[s.length];
         int r = 4;
         int l1 = ip.length();
       while(Math.pow(2,r)<l1+1)
         r++;

       for(int i=0;i<s.length;i++)
        {
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
        HashMap<Integer,Integer> vec =new HashMap<Integer,Integer>();
        for(int i=0;i<r;i++)
        {
            int p =(int)Math.pow(2,i);
            if(integers[p-1]!=0)
            {
                int k=p;
                int l=-1;
                while(k<integers.length)
                {
                    l=l+2;
                    int j=0;
                    while(j<=i)
                    {
                    if(vec.containsKey(k+j-1))
                       vec.put(k+j-1,vec.get(k+j-1)+1);
                    else
                     vec.put(k+j-1,1);
                     j++;
                    }
                    k = k*l;
                }
            }
        }
        if(vec.size()==0)
         System.out.println("No error in code");
        else
        {
        vec = sortByValue(vec);
        int r1 =vec.get(vec.keySet().toArray()[0]);
        int p = (integers[r1]+1)%2;
        System.out.print("Bit is flipped at position ");
        System.out.println(r1);
        System.out.print("Correct code is: ");
        StringBuilder sb = new StringBuilder(ip);
         sb.setCharAt(r, (char)p);
         System.out.println(sb);
        }
    }
}

