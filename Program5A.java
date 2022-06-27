import java.io.*;
import java.util.*;
public class Program5A {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sn.next();
        int ones = 0, zeros = 0;
        for(char ch : s.toCharArray()){
            if(ch=='1') ones++;
            else zeros++;
        }
        if(ones==zeros) System.out.println("0 to "+s.length()); // suppose the given string contains all the ones and zeros are equal
        else{
            int count = 0, end = 0;
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);
                if(ch=='0') count--;
                else count++;
                if(count==0) end = i;
            }
            System.out.println("0 to "+end);
        }
    }
}
// 101011000011
