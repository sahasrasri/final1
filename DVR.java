import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
class DVR
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter number of vertices");
int v=sc.nextInt();
System.out.println("Enter number of edges");
int e=sc.nextInt();
char vn[]=new char[v];
for(int i=0;i<v;i++)
{
System.out.println("Enter vertex name");
vn[i]=sc.next().charAt(0);
}
int ad[][]=new int[e][3];
for(int i=0;i<e;i++)
{
System.out.println("Enter edge");
char ch=sc.next().charAt(0);
for(int j=0;j<v;j++)
{
if(ch==vn[j])
ad[i][0]=j;
}
ch=sc.next().charAt(0);
for(int j=0;j<v;j++)
{
if(ch==vn[j])
ad[i][1]=j;
}
ad[i][2]=sc.nextInt();
}
int d[]=new int[v];
int p[]=new int[v];
for(int s=0;s<v;s++)
{
for(int i=0;i<v;i++)
{
d[i]=147483647;
p[i]=-1;
}
d[s]=0;
p[s]=-1;
for(int j=0;j<v-1;j++)
{
for(int i=0;i<e;i++)
{
if(d[ad[i][1]]>d[ad[i][0]]+ad[i][2])
{
d[ad[i][1]]=d[ad[i][0]]+ad[i][2];
p[ad[i][1]]=ad[i][0];
}
if(d[ad[i][0]]>d[ad[i][1]]+ad[i][2])
{
d[ad[i][0]]=d[ad[i][1]]+ad[i][2];
p[ad[i][0]]=ad[i][1];
}
}
}
for(int i=0;i<v;i++)
{
if(p[i]==s)
p[i]=i;
}
char pn[]=new char[v];
for(int i=0;i<v;i++)
{
if(p[i]==-1)
pn[i]='-';
else
pn[i]=vn[p[i]];
}
System.out.println("At source vertex "+vn[s]);
System.out.println("v d p");
for(int i=0;i<v;i++)
System.out.println(vn[i]+" "+d[i]+" "+pn[i]);
}
}
}