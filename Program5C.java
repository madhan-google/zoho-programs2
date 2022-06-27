import java.io.*;
import java.util.*;
public class Program5C {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sn.next();
        var map = new HashMap<Integer, Integer>();
        int endInd = 0, maxLen = 0, equal = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='1') equal++;
            else equal--;
            if(equal==0){
                maxLen = i+1;
                endInd = i;
            }
            if(map.containsKey(equal)){
                if(maxLen<i-map.get(equal)){
                    maxLen = i-map.get(equal);
                    endInd = i;
                }
            }else map.put(equal, i);
        }
        int startInd = endInd-maxLen+1;
        System.out.println(startInd+" "+endInd);
    }
}
