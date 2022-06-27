import java.io.*;
import java.util.*;
public class Program1B{
    //printing pattern using two dimensional array
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = Int(); // getting input from user;
        int[][] grid = new int[n][]; // init 2d array to store pattern
        int gap = n-1;
        for(int row=1; row<=n; row++){ // loop from 1 to n
            int start = row;
            grid[row-1] = new int[row]; // allocating memory for row
            for(int i=1; i<=row; i++){
                grid[row-1][i-1] = start; 
                start += gap; // add the gap value to start
                gap--; // reduce gap value by one
            }
            gap = n-1; // reset the gap value to n-1
        }
        //printing pattern which we were stored
        for(int[] row : grid){
            for(int x : row){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
    public static int Int(){
        return sn.nextInt();
    }
}