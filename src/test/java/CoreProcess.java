import java.util.ArrayList;

public interface CoreProcess {
    ArrayList<Product> readDataFromFile();

    void saveDataToFile();
    void backUpDataToFile();
    void restoreDataToFile();

    void moveToFirstPage(int rowSetup, ArrayList<Product> products);
    void moveToLastPage(int rowSetup, ArrayList<Product> products);
    void moveToPreviousPage(int rowSetup, ArrayList<Product> products);
    void moveToNextPage(int rowSetup, ArrayList<Product> products);

    void exitProgram();
}