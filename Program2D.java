import java.util.*;
public class Program2D {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sn.nextInt();
        int num = 1, sign = 1, spaceGap = n-1;
        for(int i=0; i<n; i++){
            for(int j=0; j<=n+spaceGap; j++){
                if(j>spaceGap){
                    System.out.print(num+"\t");
                    num+=sign;
                }else System.out.print("\t");
            }
            spaceGap--;
            num = (sign=sign*-1)==1?num+n-1:num+n+1;
            System.out.println();
        }
    }
}
