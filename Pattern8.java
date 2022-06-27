import java.io.*;
import java.util.*;
public class Pattern8 {
    // 5 5 5 5 5 5 5 5 5 
    // 5 4 4 4 4 4 4 4 5 
    // 5 4 3 3 3 3 3 4 5 
    // 5 4 3 2 2 2 3 4 5 
    // 5 4 3 2 1 2 3 4 5
    // 5 4 3 2 2 2 3 4 5
    // 5 4 3 3 3 3 3 4 5
    // 5 4 4 4 4 4 4 4 5
    // 5 5 5 5 5 5 5 5 5
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        int n = sn.nextInt();
        int limit = n+n-1;
        int[][] grid = new int[limit][limit];
        int left=0, right=limit-1, top=0, bottom=limit-1;
        int end = 0;
        while(n>=1){
            for(int i=left; i<=right; i++){
                grid[top][i] = n;
                grid[i][left] = n;
                grid[i][right] = n;
                grid[bottom][i] = n;
            }
            left++;
            right--;
            top++;
            bottom--;
            n--;
        }
        for(int[] ar : grid){
            for(int x : ar){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}
