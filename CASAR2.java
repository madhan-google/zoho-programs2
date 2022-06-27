import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
class Inventory{
    protected String productName;
    protected int productId;
    protected int quantity;
    protected int price;
    protected int offerId=-1;

    Inventory(){}

    public int getOfferId() {
        return this.offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }


    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "{ product name : "+getProductName()+", product id : "+getProductId()+", quantity : "+getQuantity()+", price : "+getPrice()+"}";
    }

    // class Sale{
    //     public void calculate(int pid, int pquantity){
    //         setQuantity(getQuantity()-pquantity);
    //     }
    // }

}
class NewOffer extends Inventory{
    private int offerId;
    private int productId;
    private int minQuantity;
    private int discountPercentage;

    NewOffer(){}

    public int getOfferId() {
        return this.offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMinQuantity() {
        return this.minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    public int getDiscountPercentage() {
        return this.discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }



}
class Sale extends NewOffer{
    private int totalBill = 0;

    public int getTotalBill() {
        return this.totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }

    public int getPercentageAmount(int amount, int discount){
        return (int)(amount*(discount/100.0f));
    }

    public void saleTheProduct(int pid, int pQuantity, Map<Integer, Inventory> inventoryMap, Map<Integer, NewOffer> offerMap){
        Inventory inventory = inventoryMap.get(pid);
        NewOffer newOffer = offerMap.get(pid);
        inventory.setQuantity(inventory.getQuantity()-pQuantity);
        int totalAmount = 0;
        if(newOffer!=null&&pQuantity>=newOffer.getMinQuantity()) totalAmount = (pQuantity*inventory.getPrice())-getPercentageAmount((pQuantity*inventory.getPrice()), newOffer.getDiscountPercentage()); 
        else totalAmount = pQuantity*inventory.getPrice();
        System.out.println(inventory.getProductId()+" - "+inventory.getProductName()+" - "+pQuantity+ " - "+ inventory.getPrice() +" - "+(inventory.getOfferId()==-1?"N/A":inventory.getOfferId())+" - "+(totalAmount));
        setTotalBill(getTotalBill()+(totalAmount));
    }

}
class Stock extends Inventory{
    public void getDetails(int pid, Map<Integer, Inventory> map){
        Inventory inventory = map.get(pid);
        System.out.println(inventory.getProductName()+" - "+inventory.getQuantity());
    }

}
public class CASAR2 {
    public static final Scanner sn = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        // List<Inventory> inventorys = new ArrayList<>();
        File file = new File("f:\\input.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Map<Integer, Inventory> inventoryMap = new HashMap<>();
        Map<Integer, NewOffer> offerMap = new HashMap<>();
        Stock stock = new Stock();
        Sale sale = new Sale();
        NewOffer newOffer = new NewOffer();
        String input = "";
        while(((input=bufferedReader.readLine())!=null) && !input.equalsIgnoreCase("exit")){
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            String[] step1 = input.trim().split("=>");
            // System.out.println(Arrays.toString(step1));
            switch(step1[0]){
                case "INVENTORY":
                    Inventory inventory = new Inventory();
                    String[] splitFirst = step1[1].trim().split("[|]");
                    // System.out.println(Arrays.toString(splitFirst));
                    inventory.setProductId(Integer.parseInt(splitFirst[0]));
                    inventory.setProductName(splitFirst[1]);
                    inventory.setQuantity(Integer.parseInt(splitFirst[2]));
                    inventory.setPrice(Integer.parseInt(splitFirst[3]));
                    inventoryMap.put(inventory.getProductId(), inventory);
                    System.out.println("Inventory Updated.");
                    // System.out.println(inventory);
                    break;
                case "SALE":
                    splitFirst = step1[1].trim().split("[;]");
                    // System.out.println(Arrays.toString(splitFirst));
                    System.out.println("====Bill====");
                    for(String str : splitFirst){
                        String[] temp = str.trim().split("[|]");
                        // System.out.println(Arrays.toString(temp));
                        sale.saleTheProduct(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), inventoryMap, offerMap);
                    }
                    System.out.println("====Total====");
                    System.out.println(sale.getTotalBill());
                    System.out.println("===============");
                    sale.setTotalBill(0);
                    break;
                case "STOCK":
                    stock.getDetails(Integer.parseInt(step1[1]), inventoryMap);
                    break;
                case "NEW-OFFER":
                    // System.out.println(step1[1]);
                    String[] offerData = step1[1].trim().split("[|]");
                    // System.out.println(Arrays.toString(offerData));
                    newOffer.setOfferId(Integer.parseInt(offerData[1]));
                    newOffer.setProductId(Integer.parseInt(offerData[2]));
                    newOffer.setMinQuantity(Integer.parseInt(offerData[3]));
                    newOffer.setDiscountPercentage(Integer.parseInt(offerData[4]));
                    inventoryMap.get(newOffer.getProductId()).setOfferId(newOffer.getOfferId());
                    offerMap.put(newOffer.getOfferId(), newOffer);
                    System.out.println("Offer Added.");
                    break;
            }
            // input = sn.next();
        }
    }
}
