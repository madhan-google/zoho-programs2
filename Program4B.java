import java.io.*;
import java.util.*;
public class Program4B {
    // find starting index and ending index
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // qwtuqwsdfghai
    // qwsdfgh
    // inputstreamreader
    // tstr
    public static void main(String[] args) throws Exception {
        String s = br.readLine();
        int left = 0, right = 0, i = 0, j = 0, max = -1;
        for(j=0; j<s.length(); j++){
            char ch = s.charAt(j);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                if(max<=(j-i)){
                    left = i;
                    right = j;
                    max = j-i;
                    i=j+1;
                    System.out.println(s.substring(left, right));
                }
            }
        }
        System.out.println(left+" "+right+" "+s.substring(left, right));
    }
}
