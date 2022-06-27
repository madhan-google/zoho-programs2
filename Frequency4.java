import java.io.*;
import java.util.*;
public class Frequency4 {
    // using hashmap method
    static class Node{
        char ch;
        int count;
        Node(char ch){
            this.ch = ch;
            this.count = 1;
        }
        public void incCount(){
            this.count++;
        }
    }
    public static boolean contains(Node[] nodes, int n, char ch){
        for(int i=0; i<n; i++){
            if(nodes[i].ch==ch) return true;
        }
        return false;
    }
    public static void setCount(Node[] nodes, int n, char ch){
        for(int i=0; i<n; i++){
            if(nodes[i].ch==ch){
                nodes[i].incCount();
            }
        }
    }
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        String s = br.readLine();
        int n=0;
        Node[] nodes = new Node[26];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!contains(nodes, n, ch)){
                nodes[n] = new Node(ch);
                n++;
            }else{
                setCount(nodes, n, ch);
            }
        }
        for(int i=0; i<n; i++){
            System.out.println(nodes[i].ch+" - "+nodes[i].count);
        }
    }
}
