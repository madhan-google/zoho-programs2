import java.util.*;
public class Pattern1 {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sn.nextInt();
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
