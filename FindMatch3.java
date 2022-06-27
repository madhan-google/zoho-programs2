import java.io.*;
import java.util.*;
public class FindMatch3 {
    static class Info{
        String name;
        String gender;
        Info father;
        Info mother;
        Info[] childs;
        Info[] siblings;
        int ccount, scount;
        Info(){
            this.ccount = 0;
            this.scount = 0;
            this.father = null;
            this.mother = null;
            this.childs = new Info[10];
            this.siblings = new Info[10];
        }
        @Override
        public String toString(){
            return this.name;
        }
    }
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        Info[] infos = new Info[100];
        int icount = 0;
        int n = sn.nextInt();
        for(int i=0; i<n; i++){
            String name = sn.next();
            String gender = sn.next();
            String fatherName = sn.next();
            String motherName = sn.next();
            Info info = new Info();
            info.name = name;
            info.gender = gender;
            
            // see already in list
            boolean flag = false;
            for(int j=0; j<icount; j++){
                if(infos[j]!=null&&infos[j].name.equals(name)){
                    // System.out.print("matched name : "+infos[j].name);
                    info = infos[j];
                    flag = true;
                    break;
                }
            }
            // searching father in list
            for(int j=0; j<icount; j++){
                if(infos[j].name.equals(fatherName)){
                    info.father = infos[j];
                    info.father.childs[info.father.ccount++] = info;
                    break;
                }
            }
            if(info.father==null){
                info.father = new Info();
                info.father.name = fatherName;
                info.father.gender = "male";
                info.father.childs[info.father.ccount++] = info;
                infos[icount++] = info.father;
            }

            //searching mother in list
            for(int j=0; j<icount; j++){
                if(infos[j].name.equals(motherName)){
                    info.mother = infos[j];
                    info.mother.childs[info.mother.ccount++] = info;
                    break;
                }
            }
            if(info.mother==null){
                info.mother = new Info();
                info.mother.name = motherName;
                info.mother.gender = "female";
                info.mother.childs[info.mother.ccount++] = info;
                infos[icount++] = info.mother;
            }
            // System.out.println("mother "+info.mother.name);
            //searching for siblings
            for(int j=0; j<icount; j++){
                if(infos[j].father!=null&&infos[j].father.name.equals(info.father.name)){
                    info.siblings[info.scount++] = infos[j];
                    infos[j].siblings[infos[j].scount++] = info;
                }
            }
            if(!flag) infos[icount++] = info;
        }
        // for(int i=0; i<icount; i++){
        //     System.out.println("name "+infos[i]+" mother name "+infos[i].mother.name+" father name "+infos[i].father.name);
        // }
        System.out.println();
        System.out.println();
        // for(int i=0; i<icount; i++){
        //     System.out.println("name "+infos[i].name+" childs "+Arrays.toString(infos[i].childs)+" siblings "+Arrays.toString(infos[i].siblings));
        // }
        String inp = sn.next();
        Info inpInfo = null;
        for(int i=0; i<icount; i++){
            if(inp.equals(infos[i].name)){
                inpInfo = infos[i];
                break;
            }
        }
        if(inpInfo!=null){
            // searching aunties
            for(int i=0; i<inpInfo.father.scount; i++){
                Info inf = inpInfo.father.siblings[i];
                if(inf.gender.equals("female")){
                    for(int j=0; j<inf.ccount; j++){
                        if(!inf.childs[j].gender.equals(inpInfo.gender)){
                            System.out.print(inf.childs[j].name+" ");
                        }
                    }
                }
            }
            // searching uncles
            for(int i=0; i<inpInfo.mother.scount; i++){
                Info inf = inpInfo.mother.siblings[i];
                if(inf.gender.equals("male")){
                    for(int j=0; j<inf.ccount; j++){
                        if(!inf.childs[j].gender.equals(inpInfo.gender)){
                            System.out.print(inf.childs[j].name+" ");
                        }
                    }
                }
            }
        }else{
            System.out.println("member not found");
        }
    }
}
