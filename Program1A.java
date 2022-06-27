import java.io.*;
import java.util.*;
public class Program1A {
    // printing pattern
    public static final Scanner sn =  new Scanner(System.in);
    public static void main(String[] args) {
        int n = Int(); // getting input from user
        int gap = n-1;
        for(int row=1; row<=n; row++){ //loop from 1 to n
            int start = row;
            for(int i=1; i<=row; i++){
                System.out.print(start+" ");
                start += gap; // add the gap value to start
                gap--; // reduce the gap value by one
            }
            gap = n-1; // reset the gap value to n-1
            System.out.println(); // for printing next line
        }
    }
    public static int Int(){
        return sn.nextInt();
    }
}
