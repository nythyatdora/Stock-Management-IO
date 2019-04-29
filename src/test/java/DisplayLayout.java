public interface DisplayLayout {
    void outputWelcomeLayout();
    void outputLogoLayout();
    void outputLoadingLayout();
    void outputMainLayout();
    void outputHelpLayout();
    void outputMessageLayout(String message);
    void outputUpdateOptionLayout();

    void outputProductData(Product product);
    void displayTableData(Product[] products);
    void writeDataLayout();
    void readDataLayout();
    void searchDataLayout();
    void deleteDataLayout();
    void updataDataLayout();

    void outputInvalidInputLayout(String message);
    void gotoDataLayout();
    void setRowLayout();
}