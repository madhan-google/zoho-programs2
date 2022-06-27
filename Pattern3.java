import java.util.*;
public class Pattern3 {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sn.nextInt();
        for(int i=n; i>=1; i--){
            for(int j=n; j>=i; j--){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
