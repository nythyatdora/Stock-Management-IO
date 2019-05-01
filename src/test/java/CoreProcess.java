import java.util.ArrayList;

public interface CoreProcess {
    ArrayList<Product> readDataFromFileProcess();
    void saveDataToFileProcess();

    void moveToFirstProcess(int rowSetup, ArrayList<Product> products);
    void moveToLastPageProcess(int rowSetup, ArrayList<Product> products);
    void moveToPreviousPageProcess(int rowSetup, ArrayList<Product> products);
    void moveToNextPageProcess(int rowSetup, ArrayList<Product> products);

    void setRowProcess();

    void gotoDataProcess();
}