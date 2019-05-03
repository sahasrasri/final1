import java.util.Scanner;

public class Netting2 
{
	String Class1="",Class2="";
	public void scenario2(int nets,int hosts)
	{
		double through1=subnet(nets,hosts);
		double through2=supernet(nets,hosts);
		if(through1>through2)
			System.out.println("Sub netting and Class is : "+Class1);
		else
			System.out.println("Super netting and Class is : "+Class2);
	}
	public double subnet(int nets,int hosts)
	{
		int no_of_bits=0,no_of_host_bits=0;
		for(int i=0;i<nets/2;i++)
			if(nets<=(int)Math.pow(2,i))
			{
				no_of_bits=i;break;
			}
		System.out.println("No of subnet bits: "+no_of_bits);
		if(hosts<=Math.pow(2,32-(24+no_of_bits)))
		{
			no_of_host_bits=32-(24+no_of_bits);
			System.out.println("Class C is suitable");
			Class1="C";
		}
		else if(hosts<=Math.pow(2,32-(16+no_of_bits)))
		{
			no_of_host_bits=32-(16+no_of_bits);
			System.out.println("Class B is suitable");
			Class1="B";
		}
		else if(hosts<=Math.pow(2,32-(8+no_of_bits)))
		{
			no_of_host_bits=32-(8+no_of_bits);
			System.out.println("Class A is suitable");
			Class1="A";
		}
		int total_subnets=(int)Math.pow(2,no_of_bits);
		int total_hosts=(int)Math.pow(2,no_of_host_bits);
		double through=throughput(nets*hosts,total_subnets*total_hosts)*100;
		System.out.println(through);
		return through;
	}
	public double supernet(int nets,int hosts)
	{
		int no_of_bits=0,no_of_host_bits=0;
		for(int i=0;i<=nets/2;i++)
			if(nets<=(int)Math.pow(2,i))
			{
				no_of_bits=i;break;
			}
		System.out.println("no of super net bits"+no_of_bits);
		if(hosts<=Math.pow(2,32-(24-no_of_bits)))
		{
			no_of_host_bits=32-(24-no_of_bits);
			System.out.println("Class C is suitable");
			Class2="C";
		}
		else if(hosts<=Math.pow(2,32-(16-no_of_bits)))
		{
			no_of_host_bits=32-(16-no_of_bits);
			System.out.println("Class B is suitable");
			Class2="B";
		}
		else if(hosts<=Math.pow(2,32-(8-no_of_bits)))
		{
			no_of_host_bits=32-(8-no_of_bits);
			System.out.println("Class A is suitable");
			Class2="A";
		}
		System.out.println("No of host bits = "+no_of_host_bits);
		int total_supnets=(int)Math.pow(2,no_of_bits);
		int total_hosts=(int)Math.pow(2,no_of_host_bits);
		double through=throughput(nets*hosts,total_supnets*total_hosts)*100;
		System.out.println(through);
		return through;
	}
	public double throughput(int usednets,int totalnets)
	{
		double ans;
		ans=(double)usednets/(double)totalnets;
		return ans;
	}
	public static void main(String args[])
	{
		Netting2 net=new Netting2();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of networks");
		int nets=sc.nextInt();
		System.out.println("Enter no of hosts per net");
		int hosts=sc.nextInt();
		net.scenario2(nets,hosts);
	}
}


