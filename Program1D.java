import java.io.*;
import java.util.*;
public class Program1D {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sn.nextInt();
        int[][] grid = new int[n][n]; // init 2d array with n size
        int nums = 1; // init nums with 1
        for(int i=0; i<n; i++){ // loop from 0 to n
            for(int j=i; j<n; j++){ // 
                grid[j][i] = nums++;
            }
        }
        for(int[] ar : grid){
            for(int x : ar) System.out.print(x==0?"  ":x+" ");
            System.out.println();
        }
    }
}
