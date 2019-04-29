
public interface DataManipulate {
    boolean findProductByID(int productID);
    boolean findProductByName(String productName);

    Product retreiveProductByID(int productID);

    int displayProductByID(int productID);
    int displayProductByName(String productName);

    boolean deleteProductByID(int productID);
}
