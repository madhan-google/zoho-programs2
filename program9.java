import java.io.*;
import java.util.*;
public class program9 {
    static class queue{
        String[] Q;
        int front, rear;
        queue(){
            Q = new String[500];
            front = 0;
            rear = 0;
        }
        public void add(String s){
            Q[rear] = s;
            rear++;
        }
        public String poll(){
            String temp = Q[front];
            front++;
            return temp;
        }
        public boolean isEmpty(){
            return rear==front;
        }
    }
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        String[] ar = br.readLine().split(" ");
        int maxLen = 0;
        for(String s : ar){
            maxLen = maxLen<s.length()?s.length():maxLen;
        }
        queue[] qs = new queue[10];
        for(int i=0; i<10; i++){
            qs[i] = new queue();
        }
        for(int i=1; i<=maxLen; i++){
            for(String s : ar){
                try{
                    char ind = '%';
                    if(i<=s.length()){
                        ind = s.charAt(s.length()-i);
                    }else{
                        ind = '0';
                    }
                    // System.out.println(s+" - "+ind);
                    switch(ind){
                        case '0':
                            qs[0].add(s);
                            break;
                        case '1':
                            qs[1].add(s);
                            break;
                        case '2':
                            qs[2].add(s);
                            break;
                        case '3':
                            qs[3].add(s);
                            break;
                        case '4':
                            qs[4].add(s);
                            break;
                        case '5':
                            qs[5].add(s);
                            break;
                        case '6':
                            qs[6].add(s);
                            break;
                        case '7':
                            qs[7].add(s);
                            break;
                        case '8':
                            qs[8].add(s);
                            break;
                        case '9':
                            qs[9].add(s);
                            break;
                    }
                }catch(Exception e){
                    qs[0].add(s);
                }
            }
            int ind = 0;
            for(int j=0; j<10; j++){
                while(!qs[j].isEmpty()){
                    ar[ind] = qs[j].poll();
                    ind++;
                }
            }
            // maxLen--;
        }
        for(String s : ar){
            System.out.print(s+" ");
        }
        // for(int i=0; i<10; i++){
        //     while(!qs[i].isEmpty()){
        //         System.out.print(qs[i].poll()+" ");
        //     }
        // }
    }
    // 1 15 35 4 20 18
}
