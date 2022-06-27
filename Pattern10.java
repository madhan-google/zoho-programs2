import java.io.*;
import java.util.*;
public class Pattern10 {
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        String s = br.readLine();
        int[] map = new int[26];
        for(int i=0; i<s.length(); i++){
            map[s.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++){
            if(map[i]!=0){
                System.out.println((char)(i+'a')+" - "+map[i]);
            }
        }
    }
    // google
    // bitwise
    // switch
    // trie
}
