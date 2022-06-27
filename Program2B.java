import java.io.*;
import java.util.*;
public class Program2B {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        // 0 0 0 1 2 3 4
        // 0 0 8 7 6 5 0
        // 0 9 10 11 12 0 0
        // 16 15 14 13 0 0 0
        int row = sn.nextInt();
        int col = row+(row-1);
        int[][] grid = new int[row][col];
        int startSpace=row-1, endSpace = 0, initNum = 1;
        for(int r=0; r<row; r+=2){
            for(int i=startSpace; i<col-endSpace; i++){
                grid[r][i] = initNum++;
            }
            initNum = initNum+row;
            startSpace-=2;
            endSpace+=2;
        }
        initNum = row+1;
        for(int r=1; r<row; r+=2){
            for(int ind=0, i=col-r-1; ind<row; ind++, i--) grid[r][i] = initNum++;
            initNum = initNum+row;
        }
        for(int[] rows : grid){
            for(int x : rows) System.out.print(x==0?" \t":(x+"\t"));
            System.out.println();
        }
    }
}
