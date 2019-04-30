public interface UpdateOption {
    int UPDATE_ALL = 1;
    int UPDATE_NAME = 2;
    int UPDATE_QUANTITY = 3;
    int UPDATE_UNIT_PRICE = 4;
    int RETURN_TO_MAIN = 5;

    boolean updateProductData(Product product);
    boolean updateProductName(Product product);
    boolean updateProductQuantity(Product product);
    boolean updateProductUnitPrice(Product product);
}
