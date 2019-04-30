import java.util.ArrayList;

public class BaseCode extends AbstractBaseCode {

    private static ConfigureSetting configureSetting = new ConfigureSetting();
    private ArrayList<Product> productArrayList;

    /**
     *  process:
     *  - save data to file
     *  - output message
     */
    public void saveDataToFile() { super.saveDataToFile(); }

    /**
     *  process:
     *  - create backup file
     *  - to back up or not
     *  - output message
     */
    public void backUpDataToFile() { super.backUpDataToFile(); }

    /**
     *  process
     *  - output backup file
     *  - select file
     *  - to restore or not
     *  - output message
     */
    public void restoreDataToFile() { super.restoreDataToFile(); }

    /**
     *  process:
     *  - display table
     *  - first page display
     *  - show pagination
     */
    public void moveToFirstPage(int rowSetup, ArrayList<Product> products) { super.moveToFirstPage(configureSetting.rowSetup, productArrayList); }

    /**
     *  process:
     *  - display table
     *  - last page display
     *  - show pagination
     */
    public void moveToLastPage(int rowSetup, ArrayList<Product> products) { super.moveToLastPage(configureSetting.rowSetup, productArrayList); }

    /**
     *  process:
     *  - display table
     *  - move -1 page
     *  - show pagination
     */
    public void moveToPreviousPage(int rowSetup, ArrayList<Product> products) { super.moveToPreviousPage(configureSetting.rowSetup, productArrayList); }

    /**
     *  process:
     *  - display table
     *  - move + 1 page
     *  - show pagination
     */
    public void moveToNextPage(int rowSetup, ArrayList<Product> products) { super.moveToNextPage(configureSetting.rowSetup, productArrayList); }

    /**
     *  process:
     *  - (working on it)
     */
    public void shortcutCommand() {}

    /**
     *  process:
     *  - output message
     *  - write data into log file
     *  - exit program
     */
    public void exitProgram() { super.exitProgram(); }

    /**
     *  process:
     *  - output welcome layout
     */
    public void outputWelcomeLayout() { super.outputWelcomeLayout(); }

    /**
     *  process:
     *  - output logo
     *  - output group logo
     */
    public void outputLogoLayout() { super.outputLogoLayout(); }

    /**
     *  process:
     *  - output loading screen
     *  - read file to collection
     */
    public void outputLoadingLayout() { super.outputLoadingLayout(); }

    /**
     *  process:
     *  - output main table
     */
    public void outputMainLayout() { super.outputMainLayout(); }

    /**
     *  process:
     *  - output help layout
     */
    public void outputHelpLayout() { super.outputHelpLayout(); }

    /**
     *  process:
     *  - input product id
     *  - input product name
     *  - input product price
     *  - input product quantity
     *  - input product import-date (explicitly)
     *  - display product data
     *  - to save data or not
     *  - output message
     */
    public void writeDataLayout() { super.writeDataLayout(); }

    /**
     *  process:
     *  - update by id
     *  - output product information
     *  - output option
     *  - select option
     *  - input option
     *  - display product data
     *  - to save or not
     *  - output message
     */
    public void updataDataLayout() { super.updataDataLayout(); }

    /**
     *  process:
     *  - input id
     *  - search by id
     *  - display product data
     */
    public void readDataLayout() { super.readDataLayout(); }

    /**
     *  process:
     *  - delete by id
     *  - display product data
     *  - to delete or not
     *  - output message
     */
    public void deleteDataLayout() { super.deleteDataLayout(); }

    /**
     *  process:
     *  - input name
     *  - regular expression search
     *  - output search result count or message
     *  - display search result table
     *  - display pagination with total record
     */
    public void searchDataLayout() { super.searchDataLayout(); }

    /**
     *  process:
     *  - input page
     *  - display table at page
     */
    public void gotoDataLayout() { super.gotoDataLayout(); }

    /**
     *  process:
     *  - input row
     *  - output message
     */
    public void setRowLayout() { super.setRowLayout(); }
}
