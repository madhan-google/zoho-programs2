import java.io.*;
import java.util.*;
public class Frequency5 {
    // brute force
    // check from 'a' to 'z'
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        String s = br.readLine();
        for(char ch='a'; ch<='z'; ch++){
            int count = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)==ch){
                    count++;
                }
            }
            if(count!=0){
                System.out.println(ch+" - "+count);
            }
        }
    }
    // google
    // bit
    // hashing
}
