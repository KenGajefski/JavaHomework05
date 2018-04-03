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

    public static void setProductCount(int productCount) {
        Product.productCount = productCount;
    }

    public static void setInventoryValue(double inventoryValue) {
        Product.inventoryValue = inventoryValue;
    }

    public static void setInventoryCount(int inventoryCount) {
        Product.inventoryCount = inventoryCount;
    }

    public boolean equals(Product prod) {
        return (code == prod.code);
    }
}
