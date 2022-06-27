import java.io.*;
import java.util.*;
public class Program3B {
    static class stack{
        int MAX = 100;
        int top;
        char[] ar;
        stack(){
            ar = new char[MAX];
            this.top = -1;
        }
        public void push(char x){
            top++;
            ar[top] = x;
        }
        public void pop(){
            top--;
        }
        public char peek(){
            return ar[top];
        }
        public boolean isEmpty(){
            return top==-1;
        }
    }
    static stack st;
    public static boolean isValid(String s){
        for(char ch : s.toCharArray()){
            if(!st.isEmpty()&&(ch==']'&&st.peek()=='[')||(ch==')'&&st.peek()=='(')||(ch=='}'&&st.peek()=='{')) st.pop();
            else if(ch==']'||ch==')'||ch=='}') return false;
            else st.push(ch);
        }
        return st.isEmpty();
    }
    // {[][(]{{}
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sn.next();
        st = new stack();
        System.out.println(isValid(s)?"VALID":"NOT VALID");
    }
}
