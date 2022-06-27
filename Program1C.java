import java.io.*;
import java.util.*;
public class Program1C {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = Int(); // getting input from user
        rec(n, n-1, 1); // calling function
    }
    public static void rec(int n, int gap, int row){
        if(row==n+1) return; // if row reached end then return
        int start = row; // initialize the start with row value
        for(int i=1; i<=row; i++){ // loop from 1 to row
            System.out.print(start+" ");
            start+=gap; // add gap to start
            gap--; // reduce gap by one
        }
        System.out.println(); // printing new line
        rec(n, n-1, row+1); // calling recursion function and pass row that added with one
    }
    public static int Int(){
        return sn.nextInt();
    }
}
