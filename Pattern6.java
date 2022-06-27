import java.util.*;
public class Pattern6 {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sn.nextInt();
        int count = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(j>n-i){
                    System.out.print(count+"\t");
                    count++;
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
