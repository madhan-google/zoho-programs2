import java.util.*;
public class Pattern4 {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sn.nextInt();
        for(int i=1; i<=n; i++){
            int start = i;
            for(int j=1; j<=n; j++){
                if(j>n-i){
                    System.out.print(start+"\t");
                    start--;
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
