import java.util.*;
public class Pattern7 {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sn.nextInt();
        for(int i=1; i<=n; i++){
            for(int j=i; j<n+i; j++){
                System.out.print((j%n)==0?n+" ":(j%n)+" ");
            }
            System.out.println();
        }
    }
}
