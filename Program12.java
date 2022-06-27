import java.io.*;
import java.util.*;
public class Program12 {
    // find the frequency of the numbers if the number having more than one frequency
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int n = sn.nextInt();
        int[] ar = new int[n];
        for(int i=0; i<n; i++){
            ar[i] = sn.nextInt();
        }
        boolean[] visit = new boolean[n];
        for(int i=0; i<n; i++){
            int count = 1, x = ar[i];
            if(!visit[i]){
                for(int j=i+1; j<n; j++){
                    if(x==ar[j]){
                        visit[j] = true;
                        count++;
                    }
                }
                if(count!=1){
                    System.out.println(x+" -> "+count);
                }
            }
        }
        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++){
        //         if(ar[i]>ar[j]){
        //             int temp = ar[i];
        //             ar[i] = ar[j];
        //             ar[j] = temp;
        //         }
        //     }
        // }
        // int i=0;
        // while(i<ar.length-1){
        //     int x = ar[i];
        //     int count = 1;
        //     while(ar[i]==ar[i+1]){
        //         count++;
        //         i++;
        //     }
        //     if(count==1) i++;
        //     if(count!=1){
        //         System.out.println(x+" - "+count);
        //     }
        // }
    }

}
