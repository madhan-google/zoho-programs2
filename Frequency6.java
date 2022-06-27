import java.io.*;
import java.util.*;
public class Frequency6 {
    static class Node{
        int count;
        Node[] childs;
        Node(){
            this.count = 0;
            childs = new Node[26];
        }
    }
    static Node root;
    static void insert(String s){
        Node node = root;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(node.childs[ch-'a']==null){
                node.childs[ch-'a'] = new Node();
            }
            node.childs[ch-'a'].count++;
            node = node.childs[ch-'a'];
        }
    }
    static void find(String s){
        Node node = root;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(node.childs[ch-'a']!=null){
                System.out.println(ch+" - "+node.childs[ch-'a'].count);
            }
            node = node.childs[ch-'a'];
        }
    }
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        String s = br.readLine();
        root = new Node();
        insert(s);
        find(s);
    }
}
