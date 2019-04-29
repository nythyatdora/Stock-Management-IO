import java.util.ArrayList;

public interface CoreProcess {
    ArrayList<Product> readDataFromFile();

    void saveDataToFile();
    void backUpDataToFile();
    void restoreDataToFile();

    void moveToFirstPage();
    void moveToLastPage();
    void moveToPreviousRow();
    void moveToNextRow();

    void exitProgram();
}