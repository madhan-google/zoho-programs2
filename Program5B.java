import java.io.*;
import java.util.*;
public class Program5B {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sn.next();
        int n = s.length();
        int startInd = 0, endInd = 0, maxLen = 0, equal = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='0') equal--;
            else equal++;
            for(int j=i+1; j<n; j++){
                char ch = s.charAt(j);
                if(ch=='0') equal--;
                else equal++;
                if(equal==0&&maxLen<=j-i+1){
                    startInd = i;
                    endInd = j;
                    maxLen = j-i+1;
                }
            }
        }
        System.out.println(startInd+" "+endInd);
    }
}
