public class Product {

    private static int productCount;
    private static double inventoryValue;
    private static int inventoryCount;
    private int code;
    private String name;
    private double cost;
    private int count;

    public Product(){
        productCount = productCount + 1;
        code = -1;
        name = "(not set)";
        cost = -1;
        count = -1;
    }

    public Product(int productCount, double inventoryValue, int inventoryCount, int code){
        this.productCount = productCount + 1;
        this.inventoryValue = inventoryValue + (cost * count);
        this.inventoryCount = inventoryCount + count;
        this.code = code;
    }
}
