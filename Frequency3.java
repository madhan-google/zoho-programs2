import java.io.*;
import java.util.*;
public class Frequency3 {
    //sorting method
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        char[] ar = br.readLine().toCharArray();
        for(int i=0; i<ar.length; i++){
            for(int j=i+1; j<ar.length; j++){
                if(ar[i]>ar[j]){
                    char temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }
        int i=0;
        while(i<ar.length){
            int count = 1;
            while(i<ar.length-1&&ar[i]==ar[i+1]){
                count++;
                i++;
            }
            System.out.println(ar[i]+" - "+count);
            if(i<ar.length){
                i++;
            }
        }
    }
}
