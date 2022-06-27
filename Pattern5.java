import java.util.*;
public class Pattern5 {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sn.nextInt();
        for(int i=0; i<=n; i++){
            int start = i;
            int beg = 1;
            for(int j=1; j<=n+i+1; j++){
                if(j>n+1){
                    System.out.print(beg+"\t");
                    beg++;
                }else if(j>=n-i+1){
                    System.out.print(start+"\t");
                    start--;
                }else{
                    System.out.print("\t");
                }
                // if(j>n+1){
                //     sign = 1;
                //     System.out.print(start+"\t");
                //     start+=sign;
                // }
            }
            // System.out.print("0\t");
            // for(int j=1; j<=i; j++){
            //     System.out.print(j+"\t");
            // }
            System.out.println();
        }
    }
}
