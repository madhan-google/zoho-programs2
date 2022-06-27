import java.io.*;
import java.util.*;
class Info{
    String name;
    String gender;
    Info father, mother;
    Info[] uncles, aunties, childs;
    int ucount, acount, ccount;
    Info(){
        father = null;
        mother = null;
        uncles = new Info[10];
        aunties = new Info[10];
        childs = new Info[10];
        ucount = 0;
        acount = 0;
        ccount = 0;
    }
    @Override
    public String toString(){
        return this.name;
    }
}
public class FindMatch {
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        // Info info = new Info();
        int n = sn.nextInt();
        Info[] infos = new Info[n];
        for(int i=0; i<n; i++){
            String name = sn.next();
            String gender = sn.next();
            String father = sn.next();
            String mother = sn.next();
            Info info = new Info();
            info.name = name;
            info.gender = gender;
            //search father which is exist in previous list or not
            for(int j=0; j<i; j++){
                if(infos[j]!=null&&father.equals(infos[j].name)){
                    info.father = infos[j]; // assign father
                    info.father.childs[info.father.ccount++] = info; // setting child to father
                    break;
                }
            }
            //
            if(info.father==null){
                info.father = new Info();
                info.father.name = father;
                info.father.gender = "male";
                info.father.childs[info.father.ccount++] = info;
            }
            // System.out.println(info.father.childs);
            //                
            for(int j=0; j<i; j++){
                if(infos[j]!=null&&mother.equals(infos[j].name)){
                    info.mother = infos[j];
                    info.mother.childs[info.mother.ccount++] = info; // setting child to mother
                    break;
                }
            }
            if(info.mother==null){
                info.mother = new Info();
                info.mother.name = mother;
                info.mother.gender = "female";
                info.mother.childs[info.mother.ccount++] = info;
            }
            System.out.println("name : "+info.name+" father "+info.father+" mother "+info.mother);

            // searching aunties
            if(info.father.father!=null){
                // System.out.println("name "+info.name+" grandpa childs : "+Arrays.toString(info.father.father.childs));
                for(int j=0; j<i; j++){
                    Info inf = infos[j];
                    // if(inf!=null&&){

                    // }
                }
                // for(Info inf : info.father.father.childs){
                //     if(inf!=null&&inf.gender.equals("female")){
                //         info.aunties[info.acount++] = inf;
                //     }
                // }
            }
            // System.out.println("info : "+info);
            // System.out.println("aunties : "+Arrays.toString(info.aunties));

            //searching uncles
            // System.out.println("grandpa : "+info.mother.father);
            if(info.mother.father!=null){
                for(Info inf : info.mother.mother.childs){
                    if(inf!=null&&inf.gender.equals("male")){
                        info.uncles[info.ucount++] = inf;
                    }
                }
            }
            // System.out.println("Uncles : "+Arrays.toString(info.uncles));
            infos[i] = info;
        }
        System.out.println();
        String inp = br.readLine();
        Info temp = null;
        for(int j=0; j<n; j++){
            // System.out.println(infos[j].name);
            if(inp.equals(infos[j].name)){
                // System.out.println("hello");
                temp = infos[j];
                break;
            }
        }
        for(int i=0; i<n; i++){
            System.out.println("name : "+infos[i].name+" childs : "+Arrays.toString(infos[i].childs));
        }
        // for(int i=0; i<n; i++){
        //     System.out.println(infos[i]);
        // }
        // reading uncles
        for(int j=0; j<temp.ucount; j++){
            Info uncle = temp.uncles[j];
            System.out.println(uncle);
            for(int k=0; k<uncle.ccount; k++){
                if(!temp.gender.equals(uncle.childs[k].gender)) {
                    System.out.print(uncle.childs[k].name+" ");
                }
            }
        }
        //reading aunties
        for(int j=0; j<temp.acount; j++){
            Info aunty = temp.aunties[j];
            System.out.println(aunty);
            for(int k=0; k<aunty.ccount; k++){
                if(!temp.gender.equals(aunty.childs[k].gender)){
                    System.out.print(aunty.childs[k].name+" ");
                }
            }
        }
    }
}
