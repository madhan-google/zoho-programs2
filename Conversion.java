import java.util.*;
public class Conversion {
    public static final String operators = "+-*/{}";
    public static String PostfixToInfix(String s){
        Stack<String> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(operators.contains(ch+"")) st.push("("+st.pop()+ch+st.pop()+")");
            else st.push(ch+"");
        }
        return (st.pop());
    }
    public static String PostfixToPrefix(String s){
        Stack<String> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(operators.contains(ch+"")){
                String a = st.pop();
                String b = st.pop();
                st.push(String.valueOf(ch+b+a));
            } else st.push(ch+"");
        }
        return st.pop();
    }
    //................................................................
    public static String PrefixToPostfix(String s){
        Stack<String> st = new Stack<>();
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(!st.isEmpty()&&operators.contains(ch+"")) st.push(String.valueOf(st.pop()+st.pop()+ch));
            else st.push(ch+"");
        }
        return st.pop();
    }
    public static String PrefixToInfix(String s){
        Stack<String> st = new Stack<>();
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(operators.contains(ch+"")) st.push(String.valueOf("("+st.pop()+ch+st.pop()+")"));
            else st.push(ch+"");
        }
        return st.pop();
    }
    //..................................................................
    public static String InfixToPostfix(String s){
        
    }
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sn.next();
        // System.out.println((PostfixToInfix(s)));
        // System.out.println(PostfixToPrefix(s));
        // System.out.println(PrefixToPostfix(s));
        System.out.println(PrefixToInfix(s));
    }
}
