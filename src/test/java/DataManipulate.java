
public interface DataManipulate {
    boolean findProductByID(int productID);
    boolean findProductByName(String productName);

    int displayProductByID(int productID);
    int displayProductByName(String productName);

    boolean deleteProductByID(int productID);
}
