import java.io.*;
import java.util.*;
public class Program4C {
    public static final Scanner sn = new Scanner(System.in);
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String rec(String s, int index, String temp, String res, int maxLen){
        if(index==s.length()) return res;
        char ch = s.charAt(index);
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
            if(maxLen <= temp.length()){
                maxLen = temp.length();
                res = temp;
                temp = "";
            }
        }else temp += s.charAt(index);
        return rec(s, index+1, temp, res, maxLen);
    }
    public static void main(String[] args) throws Exception {
        String s = br.readLine();
        String res = rec(s, 0, "", "", 0);
        if(res.length()==0) System.out.println(s);
        else System.out.println(res);
    }
    // madhan
    // dh
}
