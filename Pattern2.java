import java.util.*;
public class Pattern2 {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sn.nextInt();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
