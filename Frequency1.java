import java.io.*;
import java.util.*;
public class Frequency1 {
    // frequency array
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        String s = br.readLine();
        int[] map = new int[26];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map[ch-'a']++;
        }
        for(int i=0; i<26; i++){
            if(map[i]!=0){
                System.out.println((char)(i+'a')+" - "+map[i]);
            }
        }
    }
}
