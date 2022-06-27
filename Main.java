import java.io.*;
import java.util.*;
class Product{
    String name;
    int id;
    int price;
    Product(int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    @Override
    public String toString(){
        return "{ id : "+this.id+", name : "+this.name+", price : "+this.price+" }";
    }
}
public class Main {
    public static final Scanner sn = new Scanner(System.in);
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        Product[] pros = new Product[5];
        System.out.println("enter 5 product details : ");
        for(int i=0; i<5; i++){
            System.out.println("enter id, name, price : ");
            int id = sn.nextInt();
            String name = sn.next();
            int price = sn.nextInt();
            pros[i] = new Product(id, name, price);
        }
        for(Product p : pros){
            System.out.println(p);
        }
    }
}
