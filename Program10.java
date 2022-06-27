import java.io.*;
import java.util.*;
public class Program10 {
    // finding the next greater element and replace it otherwise put -1
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int n = sn.nextInt();
        int[] ar = new int[n];
        for(int i=0; i<n; i++){
            ar[i] = sn.nextInt();
        }
        // for(int i=0; i<n; i++){
        //     int x = ar[i], min = Integer.MAX_VALUE;
        //     for(int j=i+1; j<n; j++){
        //         if(x<ar[j]&&min>ar[j]){
        //             min = ar[j];
        //         }
        //     }
        //     ar[i] = (min==Integer.MAX_VALUE?-1:min);
        // }
        for(int i=0; i<n; i++){
            int min = ar[i];
            int x = ar[i], s=i+1, e = n-1;
            while(s<=e){
                if(x<ar[s]&&min>ar[s]){
                    min = ar[s];
                }
                if(x<ar[e]&&min>ar[e]){
                    min = ar[e];
                }
                s++;
                e--;
            }
            ar[i] = (min==Integer.MAX_VALUE?-1:min);
        }
        for(int x : ar){
            System.out.print(x+" ");
        }
    }
    // 6
    // 2 4 8 90 77 54
    // 5
    // 2 -1 0 -1 3
}
