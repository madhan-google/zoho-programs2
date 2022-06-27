import java.io.*;
import java.util.*;
public class Program2A {
    public static int printOddNum(int startNum, int col, int spaceGap, int n){
        for(int i=0; i<spaceGap; i++) System.out.print(" \t");
        for(int i=0; i<n; i++, startNum++) System.out.print(startNum+"\t");
        System.out.println();
        return startNum;
    }
    public static int printEvenRow(int startNum, int col, int spaceGap, int n){
        for(int i=0; i<spaceGap; i++) System.out.print(" \t");
        for(int i=0; i<n; i++, startNum--) System.out.print(startNum+"\t");
        System.out.println();
        return startNum;
    }
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        // 0 0 0 1 2 3 4
        // 0 0 8 7 6 5 0
        // 0 9 10 11 12 0 0
        // 16 15 14 13 0 0 0
        int row = sn.nextInt();
        int spaceGap = row-1, evenRowNum = row*2, oddRowNum = 1, col = row+row-1, r=0;
        for(;;){
            if(r==row) break;
            // System.out.println("odd num "+oddRowNum);
            oddRowNum = printOddNum(oddRowNum, col, spaceGap, row)+row;
            // oddRowNum = oddRowNum+row+1;
            spaceGap--;
            r++;
            if(r==row) break;
            // System.out.println("even num "+evenRowNum);
            printEvenRow(evenRowNum, col, spaceGap, row);
            spaceGap--;
            evenRowNum = evenRowNum*2;
            r++;
        }
    }
}
/**

 */
