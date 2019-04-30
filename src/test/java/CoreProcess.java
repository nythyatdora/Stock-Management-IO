import java.util.ArrayList;

public interface CoreProcess {
    ArrayList<Product> readDataFromFile();

    void saveDataToFile();
    void backUpDataToFile();
    void restoreDataToFile();

    void moveToFirstPage(int startRow, ArrayList<Product> products);
    void moveToLastPage(int startRow, ArrayList<Product> products);
    void moveToPreviousRow(int startRow, ArrayList<Product> products);
    void moveToNextRow(int startRow, ArrayList<Product> products);

    void exitProgram();
}