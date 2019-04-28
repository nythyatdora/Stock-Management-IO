public class Product {
    private int productID;
    private String productName;
    private double unitPrice;
    private int quantity;
    private String importDate;

    public Product() {
        this.productID = -1;
        this.productName = "";
        this.unitPrice = -1;
        this.quantity = -1;
        this.importDate = "DD-MM-YY";
    }

    public Product(int productID, String productName, double unitPrice, int quantity, String importDate) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.importDate = importDate;
    }

    private void createFileForTesting() {
        Product product = new Product(1, "Coca Cola", 2.50, 10, "12-12-2019");

        final int TEN_MILLION_RECORDS = 10000000;
        for(int i=0; i<TEN_MILLION_RECORDS; i++) {
            // WRITE INTO FILE
        }
    }

    public static void main(String[] args) {

    }
}