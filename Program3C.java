import java.io.*;
import java.util.*;
public class Program3C {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        char[] ar = new char[1000];
        String s = sn.next();
        var pair = new HashMap<Character, Character>();
        pair.put(']', '[');
        pair.put('}', '{');
        pair.put(')', '(');
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(i>0&&pair.containsKey(ch)&&pair.get(ch)==builder.charAt(builder.length()-1)) builder.deleteCharAt(builder.length()-1);
            else builder.append(ch);
        }
        System.out.println(builder.length()==0?"VALID":"INVALID");
    }
    // {[][(]{{}
}
