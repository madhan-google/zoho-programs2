import java.io.*;
import java.util.*;
public class Program2C {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sn.nextInt();
        int startNum = 1, spaceGap = n-1, lastNum = n, row=1;     
        for(;;){
            if(row%2==1){
                // System.out.println("start "+startNum+" end "+lastNum);
                int j;
                for(j=0; j<spaceGap; j++) System.out.print(" \t");
                for(j=startNum; j<=lastNum; j++) System.out.print(j+"\t");
                startNum = lastNum+n;
                lastNum = j;
                row++;
                spaceGap--;
                System.out.println();
            }
            if(row==n+1) break;
            if(row%2==0){
                int j;
                // System.out.println("start "+startNum+" end "+lastNum);
                for(j=0; j<spaceGap; j++) System.out.print(" \t");
                for(j=startNum; j>=lastNum; j--) System.out.print(j+"\t");
                row++;
                spaceGap--;
                startNum = j+n+1;
                lastNum = startNum+n-1;
                System.out.println();
            }
            if(row==n+1) break;
        }
    }
}
//                         1       2       3       4
//                 8       7       6       5
//         9       10      11      12
// 16      15      14      13
