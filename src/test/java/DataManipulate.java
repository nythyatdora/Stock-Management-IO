import java.util.HashMap;

public interface DataManipulate {
    boolean findProductByID(int productID, HashMap<Integer, Product> hashMap);
    boolean findProductByName(String productName, HashMap<String, Product> hashMap);

    boolean insertNewProduct(Product product, HashMap<Integer, Product> hashMap);
    Product retreiveProductByID(int productID, HashMap<Integer, Product> hashMap);

    void displayProductByID(int productID, HashMap<Integer, Product> hashMap);
    int displayProductByName(String productName, HashMap<String, Product> hashMap);

    boolean deleteProductByID(int productID, HashMap<Integer, Product> hashMap);
}
