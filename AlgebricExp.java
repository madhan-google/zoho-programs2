import java.io.*;
import java.util.*;
public class AlgebricExp {
    public static final int AMAX = 6; // maximum size for character with power

    // class for storing character along with its power
    static class Alpha{
        char ch;
        int pow;
        Alpha(){}
        @Override
        public String toString(){
            return this.pow==1?this.ch+"":this.ch+"^"+this.pow;
        }
    }
    // class for storing coeffient along with variables
    static class Node{
        int num;
        Alpha[] alphas;
        int aCount;
        Node next;
        Node(int num){
            this.aCount = 0;
            this.next = null;
            this.num = num;
            this.alphas = new Alpha[AMAX];
        }
        @Override
        public String toString(){
            return this.num>0?"+"+this.num:""+this.num;
        }
    }
    // creating new node to append expression list
    public static Node create(Node head, int num, Alpha[] alphas, int aCount){
        Node newnode = new Node(num);
        newnode.aCount = aCount;
        if(alphas!=null) newnode.alphas = Arrays.copyOf(alphas, aCount);
        else newnode.alphas = null;
        if(head==null) return newnode;
        Node cur = head;
        while(cur.next!=null) cur = cur.next;
        cur.next = newnode;
        return head;
    }

    // printing expression list
    public static void print(Node head){
        Node cur = head;
        while(cur!=null){
            System.out.print(cur);
            for(int i=0; i<cur.aCount; i++){
                System.out.print(cur.alphas[i]);
            }
            System.out.print(" ");
            cur = cur.next;
        }
        System.out.println();
    }

    // converting string to expression list
    public static Node getHead(String exp){
        Node head = null;
        int num=0;
        // init alpha to store variables
        Alpha[] alpha = new Alpha[AMAX];
        for(int i=0; i<AMAX; i++){
            alpha[i] = new Alpha();
        }
        int sign = 1;
        // check whether first number is negative or positive
        if(exp.charAt(0)=='-'){
            sign = -1;
        }
        int count = 0;
        // if first character is negative. start with 1st index else start with 0th index
        for(int i=sign==-1?1:0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            if(ch=='+'){
                sign = 1;
                head = create(head, num, alpha, count);
                count = 0;
                for(int j=0; j<AMAX; j++){
                    alpha[j] = new Alpha();
                }
                num = 0;
            }else if(ch=='-'){
                head = create(head, num, alpha, count);
                sign = -1;
                count = 0;
                for(int j=0; j<AMAX; j++){
                    alpha[j] = new Alpha();
                }
                num = 0;
            }else if(ch<='z'&&ch>='a'){
                alpha[count].ch = ch;
                if(i<exp.length()-1&&exp.charAt(i+1)=='^'){
                    int pow = 0;
                    while(i+2<exp.length()&&(exp.charAt(i+2)<='9'&&exp.charAt(i+2)>='0')){
                        pow = pow * 10 + (exp.charAt(i+2)-'0');
                        i++;
                    }
                    i++;
                    alpha[count].pow=pow;
                }else{
                    alpha[count].pow=1;
                }
                count++;
            }else{
                num = num * 10 + sign*(ch-'0');
            }
        }
        if(num==0) num=1;
        if(count==0){
            head = create(head, num, null, count);
        }else{
            head = create(head, num, alpha, count);
        }
        // print(head);
        return head;
    }

    public static boolean check(Node head, Alpha[] alps, int n, int num){
        Node cur = head;
        while(cur!=null){
            boolean ok = true;
            if(cur.aCount==n){
                for(int i=0; i<n; i++){
                    if(cur.alphas[i].ch!=alps[i].ch||cur.alphas[i].pow!=alps[i].pow){
                        ok = false;
                        break;
                    }
                }
                if(ok){
                    cur.num += num;
                    return true;
                }
            }
            cur = cur.next;
        }
        return false;
    }
    public static void sum(Node exp1, Node exp2){
        Node res = null;
        Node i = exp1;
        int num = 0;
        while(i!=null){
            Alpha[] iAlphas = i.alphas;
            Node j = exp2;
            while(j!=null){
                Alpha[] jAlphas = j.alphas;
                Alpha[] alps = new Alpha[AMAX];
                for(int k=0; k<AMAX; k++) alps[k] = new Alpha();
                int ai = 0;
                int x=0, y=0;
                while(x<i.aCount&y<j.aCount){
                    if(iAlphas[x].ch<jAlphas[y].ch){
                        alps[ai].ch = iAlphas[x].ch;
                        alps[ai].pow = iAlphas[x].pow;
                        x++;
                    }else if(iAlphas[x].ch>jAlphas[y].ch){
                        alps[ai].ch = jAlphas[y].ch;
                        alps[ai].pow = jAlphas[y].pow;
                        y++;
                    }else{
                        alps[ai].ch = iAlphas[x].ch;
                        alps[ai].pow = iAlphas[x].pow+jAlphas[y].pow;
                        x++;y++;
                    }
                    ai++;
                }
                while(x<i.aCount){
                    alps[ai].ch = iAlphas[x].ch;
                    alps[ai].pow = iAlphas[x].pow;
                    x++;
                    ai++;
                }
                while(y<j.aCount){
                    alps[ai].ch = jAlphas[y].ch;
                    alps[ai].pow = jAlphas[y].pow;
                    ai++;
                    y++;
                }
                if(!check(res, alps, ai, i.num*j.num)){
                    res = create(res, i.num*j.num, alps, ai);
                }
                // node creation end
                j = j.next;
            }
            i = i.next;
        }
        print(res);
    }
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        String e1 = sn.next();
        String e2 = sn.next();
        Node exp1 = getHead(e1);
        Node exp2 = getHead(e2);
        sum(exp1, exp2);
    }
}
// 2xy+4x^2y
// 2x^2y+6xy
