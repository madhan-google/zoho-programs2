import java.io.*;
import java.util.*;
public class Frequency2 {
    //brute force
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        String s = sn.next();
        boolean[] visit = new boolean[26];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!visit[ch-'a']){
                visit[ch-'a'] = true;
                int count = 1;
                for(int j=i+1; j<s.length(); j++){
                    if(ch==s.charAt(j)) count++;
                }
                System.out.println(ch+" - "+count);
            }
        }
    }
}
