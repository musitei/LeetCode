import sun.invoke.empty.Empty;
import sun.security.util.Length;

import java.io.OutputStream;
import java.util.Arrays;
import  java.util.Scanner;
public class Test2 {
    public static void main(String[] args)
    {
        String s;
        Scanner sc =new Scanner(System.in);
        s = sc.nextLine();
        char c[] = s.toCharArray();
        int i,j,k;
        int length =0;

        for(i=0;i<c.length-2;i++)
        {
            for(j=i+1;j<c.length-1;j++)
            {
                for(k=j+1;k<c.length;k++)
                { if(c[i]==c[j]&&c[j]==c[k]&&c[i]!=0&&c[j]!=0&&c[k]!=0)
                  {  // c[i]=0;
                    c[i]=0;
                    c[j]=0;
                    c[k]=0;

                    length=length+3;
                  }
            }

            }
        }
        Arrays.sort(c);
        if(c.length==length)
        {
            System.out.print(0);
        }
        for(i=length;i<c.length;i++)
        {
            System.out.print(c[i]);
        }
        //System.out.println("\n");

        sc.close();
    }

}
