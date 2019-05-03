import java.util.*;
import java.lang.*;
public class Netting 
{
	public void scenario1(int subnets,int hosts)
	{
		int no_of_bits=0,no_of_host_bits=0;
		int total_subnets,total_hosts;
		String subnet_mask,Class="";
		for(int i=0;i<=subnets/2;i++)
			if(subnets<=(int)Math.pow(2,i))
			{
				no_of_bits=i;break;
			}
		System.out.println("No of subnet bits: "+no_of_bits);
		if(hosts<=Math.pow(2,32-(24+no_of_bits)))
		{
			no_of_host_bits=32-(24+no_of_bits);
			System.out.println("Class C is suitable");
			Class="C";
		}
		else if(hosts<=Math.pow(2,32-(16+no_of_bits)))
		{
			no_of_host_bits=32-(16+no_of_bits);
			System.out.println("Class B is suitable");
			Class="B";
		}
		else if(hosts<=Math.pow(2,32-(8+no_of_bits)))
		{
			no_of_host_bits=32-(8+no_of_bits);
			System.out.println("Class A is suitable");
			Class="A";
		}
		System.out.println("");
		total_subnets=(int)Math.pow(2,no_of_bits);
		total_hosts=(int)Math.pow(2,no_of_host_bits);
		String[] firsthid=new String[total_subnets];
		String[] lasthid=new String[total_subnets];
		String[] subnet_addr=new String[total_subnets];
		String[] broadcast_addr=new String[total_subnets];
		
		/// for classs B
		if(Class.equals("B"))
		{
			String o1="172",o2="30",o3,o4;
			char ch[]=new char[8];
			for(int i=1;i<=8;i++)
			{
				if(i<=no_of_bits)
					ch[i-1]='1';
				else
					ch[i-1]='0';
			}
			subnet_mask=Integer.toString(Integer.parseInt("11111111",2))+"."+
					Integer.toString(Integer.parseInt("11111111",2))+"."+
					Integer.toString(Integer.parseInt(String.valueOf(ch),2))+"."+
					Integer.toString(Integer.parseInt("00000000",2));
			
			int remain_bits=8-no_of_bits;
			int no_of_ids_per_subnet=(int)Math.pow(2,remain_bits);
			
			for(int i=0,j=0;i<256&&j<total_subnets;i=i+no_of_ids_per_subnet,j++)
			{
				broadcast_addr[j]=o1+"."+o2+"."+Integer.toString(i+no_of_ids_per_subnet-1)+"."+"255";
				subnet_addr[j]=o1+"."+o2+"."+Integer.toString(i)+"."+"0";
				firsthid[j]=o1+"."+o2+"."+Integer.toString(i)+"."+"1";
				lasthid[j]=o1+"."+o2+"."+Integer.toString(i+no_of_ids_per_subnet-1)+"."+"254";
			}
			System.out.println("Subnet mask ="+subnet_mask);
			System.out.println("Total no of subnets ="+total_subnets);
			System.out.println("Total no of hosts ="+total_hosts);
			System.out.println("");
			System.out.println("S.no |  Subnet Address   |   BroadCast Address | FirstHostId    |  LastHostID ");
			for(int j=0;j<total_subnets;j++)
			{
				System.out.println((j+1)+"   |   "+subnet_addr[j]+"   |   "+broadcast_addr[j]+"   |    "+firsthid[j]+"    |   "+lasthid[j]);
			}
		}
		
		
		// for class A
		if(Class.equals("A"))
		{
			String o1="10",o2,o3,o4;
			char ch[]=new char[8];
			for(int i=1;i<=8;i++)
			{
				if(i<=no_of_bits)
					ch[i-1]='1';
				else
					ch[i-1]='0';
			}
			subnet_mask=Integer.toString(Integer.parseInt("11111111",2))+"."+
					Integer.toString(Integer.parseInt(String.valueOf(ch),2))+"."+
					Integer.toString(Integer.parseInt("00000000",2))+"."+
					Integer.toString(Integer.parseInt("00000000",2));
			
			
			int remain_bits=8-no_of_bits;
			int no_of_ids_per_subnet=(int)Math.pow(2,remain_bits);
			
			for(int i=0,j=0;i<256&&j<total_subnets;i=i+no_of_ids_per_subnet,j++)
			{
				broadcast_addr[j]=o1+"."+Integer.toString(i+no_of_ids_per_subnet-1)+"."+"255"+"."+"255";
				subnet_addr[j]=o1+"."+Integer.toString(i)+".0"+"."+"0";
				firsthid[j]=o1+"."+Integer.toString(i)+".0"+"."+"1";
				lasthid[j]=o1+"."+Integer.toString(i+no_of_ids_per_subnet-1)+".255"+"."+"254";
			}
			System.out.println("Subnet mask = "+subnet_mask);
			System.out.println("Total no of subnets = "+total_subnets);
			System.out.println("Total no of hosts = "+total_hosts);
			System.out.println("");
			System.out.println("S.no |  Subnet Address   |   BroadCast Address | FirstHostId    |  LastHostID ");
			for(int j=0;j<total_subnets;j++)
			{
				System.out.println((j+1)+"   |   "+subnet_addr[j]+"   |   "+broadcast_addr[j]+"   |    "+firsthid[j]+"    |   "+lasthid[j]);
			}
			
		}
		
		//for class c
		if(Class.equals("C"))
		{
			String o1="192",o2="168",o3="1",o4;
			char ch[]=new char[8];
			for(int i=1;i<=8;i++)
			{
				if(i<=no_of_bits)
					ch[i-1]='1';
				else
					ch[i-1]='0';
			}
			subnet_mask=Integer.toString(Integer.parseInt("11111111",2))+"."+
					Integer.toString(Integer.parseInt("11111111",2))+"."+
					Integer.toString(Integer.parseInt("11111111",2))+"."+
					Integer.toString(Integer.parseInt(String.valueOf(ch),2));
			
			int remain_bits=8-no_of_bits;
			int no_of_ids_per_subnet=(int)Math.pow(2,remain_bits);
			
			for(int i=0,j=0;i<256&&j<total_subnets;i=i+no_of_ids_per_subnet,j++)
			{
				broadcast_addr[j]=o1+"."+o2+"."+o3+"."+Integer.toString(i+no_of_ids_per_subnet-1);
				subnet_addr[j]=o1+"."+o2+"."+o3+"."+Integer.toString(i);
				firsthid[j]=o1+"."+o2+"."+o3+"."+Integer.toString(i+1);
				lasthid[j]=o1+"."+o2+"."+o3+"."+Integer.toString(i+no_of_ids_per_subnet-2);
			}
			System.out.println("Subnet mask = "+subnet_mask);
			System.out.println("Total no of subnets = "+total_subnets);
			System.out.println("Total no of hosts = "+total_hosts);
			System.out.println("");
			System.out.println("S.no |  Subnet Address   |   BroadCast Address | FirstHostId    |  LastHostID ");
			for(int j=0;j<total_subnets;j++)
			{
				System.out.println((j+1)+"   |   "+subnet_addr[j]+"   |   "+broadcast_addr[j]+"   |    "+firsthid[j]+"    |   "+lasthid[j]);
			}
			
		}
	}
	public static void main(String args[])
	{
		Netting net=new Netting();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of subnets you want");
		int nets=sc.nextInt();
		System.out.println("Enter no of hosts per subnet");
		int hosts=sc.nextInt();
		net.scenario1(nets,hosts);
	}
}


