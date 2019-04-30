import java.util.HashMap;

public interface DataManipulate {
    boolean findProductByID(int productID, HashMap hashMap);
    boolean findProductByName(String productName, HashMap hashMap);

    boolean insertNewProduct(Product product, HashMap hashMap);
    Product retreiveProductByID(int productID, HashMap hashMap);

    int displayProductByID(int productID, HashMap hashMap);
    int displayProductByName(String productName, HashMap hashMap);

    boolean deleteProductByID(int productID, HashMap hashMap);
}
