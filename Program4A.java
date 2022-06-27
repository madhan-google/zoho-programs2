import java.io.*;
import java.util.*;
public class Program4A {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sn.next();
        String temp = "", res = "";
        int len = 0, maxLen = -1;
        for(char ch : s.toCharArray()){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                if(maxLen<=len){
                    maxLen = len;
                    len = 0;
                    res = temp;
                    temp = "";
                }
            }else{
                temp+=ch;
                len++;
            }
        }
        System.out.println(res);
    }
}
//madhan
//dh
