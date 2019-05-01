import java.util.ArrayList;

public interface DisplayLayout {
    void outputWelcomeLayout();
    void outputLogoLayout();
    void outputLoadingLayout();
    void outputMainLayout();
    void outputHelpLayout();
    void outputTableDataLayout();

    void outputProductData(Product product);
    void displayTableData(int startRow, int viewPage, ArrayList<Product> products);

    void writeDataLayout();
    void readDataLayout();
    void searchDataLayout();
    void deleteDataLayout();
    void updataDataLayout();

    void saveDataToFileLayout();
    void backupDataToFileLayout();
    void restoreDataToFileLayout();

    void moveToFirstPageLayout();
    void moveToLastPageLayout();
    void moveToPreviousPageLayout();
    void moveToNextPageLayout();
    void gotoDataLayout();
    void setRowLayout();

    void exitProgramLayout();

    void outputMessageLayout(String message);
    void outputInvalidInputLayout(String message);
    void outputUpdateOptionLayout();
}