import java.io.*;
import java.util.*;
public class Pattern9 {
    static class queue{
        int front, rear;
        int[] Q;
        final int MAX = 100;
        queue(){
            Q = new int[MAX];
            front = 0;
            rear = 0;
        }
        public void add(int x){
            Q[rear] = x;
            rear++;
        }
        public int poll(){
            int x = Q[front];
            front++;
            return x;
        }
        public void insertFirst(int x){
            front--;
            Q[front] = x;
        }
    }
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        String s = br.readLine();
        //solution 1
        // int len = s.length();
        // int res = s.charAt(0)-'0';
        // int ind = 0;
        // for(int i=1; i<=len-(len/2)-1; i++){
        //     char ch = s.charAt((len/2)+i);
        //     // System.out.print(ch+" ");
        //     switch(ch){
        //         case '+':
        //             res = res + (s.charAt(i)-'0');
        //             break;
        //         case '-':
        //             res = res - (s.charAt(i)-'0');
        //             break;
        //         case '*':
        //             res = res * (s.charAt(i)-'0');
        //             break;
        //         case '/':
        //             res = res / (s.charAt(i)-'0');
        //             break;
        //     }
        // }
        // System.out.println(res);
        // solution 2
        int res = 0;
        queue q = new queue();
        for(char ch : s.toCharArray()){
            switch(ch){
                case '+':
                    res = (q.poll()+q.poll());
                    q.insertFirst(res);
                    break;
                case '-':
                    res = (q.poll()-q.poll());
                    q.insertFirst(res);
                    break;
                case '*':
                    res = (q.poll()*q.poll());
                    q.insertFirst(res);
                    break;
                case '/':
                    res = q.poll()/q.poll();
                    q.insertFirst(res);
                    break;
                default:
                    q.add((ch-'0'));
            }
        }
        System.out.println(q.poll());
    }
    // "12345*+-+"
    // 6 [1*2+3-4+5=6]
    // "374291--*+-"
}
