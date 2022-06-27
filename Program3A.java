import java.io.*;
import java.util.*;
class stack{
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
public class Program3A {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sn.next();
        stack st = new stack();
        for(char ch : s.toCharArray()){
            if(!st.isEmpty()&&(ch==')'&&st.peek()=='(')||(ch==']'&&st.peek()=='[')||(ch=='}'&&st.peek()=='{')) st.pop();
            else st.push(ch);
        }
        System.out.println(st.isEmpty()?"VALID":"INVALID"); 
    }
}
