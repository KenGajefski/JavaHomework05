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

    public Product(int code, String name, double cost, int count){
        productCount = productCount + 1;
        inventoryValue = inventoryValue + (cost * count);
        inventoryCount = inventoryCount + count;
        this.code = code;
        this.name = name;
        this.cost = cost;
        this.count = count;
    }

    public static int getProductCount() {
        return productCount;
    }

    public static double getInventoryValue() {
        return inventoryValue;
    }

    public static int getInventoryCount() {
        return inventoryCount;
    }

    public double getCost() {
        return cost;
    }

    public int getCode() {
        return code;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public static void setProductCount(int productCount) {
        Product.productCount += productCount;
    }

    public static void setInventoryValue(double inventoryValue) {
        Product.inventoryValue += inventoryValue;
    }

    public static void setInventoryCount(int inventoryCount) {
        Product.inventoryCount += inventoryCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Product prod) {
        return (code == prod.code);
    }
}
