import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.HashMap;
import java.util.Scanner;

public abstract class AbstractBaseCode implements DisplayLayout, CoreProcess, DataManipulate, UpdateOption {
    private ConfigureSetting setting;

    public AbstractBaseCode() {
        setting = new ConfigureSetting();
        // READ DATA FROM setting.bak
        // IF FILE NOT EXIST
        //      CREATE DEFAULT SETTING
        // ELESE
        //      READ FROM FILE TO this.setting
    }

    public void saveDataToFile() {

    }

    public void backUpDataToFile() {

    }

    public void restoreDataToFile() {

    }

    public void moveToFirstPage() {
        // displayTableData(setting.currentRowStart, length_setup_row, collection)
    }

    public void moveToLastPage() {
        // displayTableData(length_collection - length_setup_row, length_setup_row, collection)
    }

    public void moveToPreviousRow() {
        // set --setting.currentRowStart;
        // displayTableData(setting.currentRowStart, setting.rowDisplayLimit, collection)
        // calculate page
    }

    public void moveToNextRow() {
        // set ++setting.currentRowStart;
        // displayTableData(setting.currentRowStart, setting.rowDisplayLimit, collection)
        // calculate page
    }

    public void exitProgram() {

    }

    public void outputWelcomeLayout() {
        String[] stockText = {
                "                      _____  _                _      __  __                                                            _    ",
                "                     / ____|| |              | |    |  \\/  |                                                          | |   ",
                "                    | (___  | |_  ___    ___ | | __ | \\  / |  __ _  _ __    __ _   __ _   ___  _ __ ___    ___  _ __  | |_  ",
                "                     \\___ \\ | __|/ _ \\  / __|| |/ / | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '_ ` _ \\  / _ \\| '_ \\ | __| ",
                "                     ____) || |_| (_) || (__ |   <  | |  | || (_| || | | || (_| || (_| ||  __/| | | | | ||  __/| | | || |_  ",
                "                    |_____/  \\__|\\___/  \\___||_|\\_\\ |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_| |_| |_| \\___||_| |_| \\__| ",
                "                                                                                   __/ |                                    ",
                "                                                                                  |___/"};
        CommonMethod.printlnStrings(stockText);
    }

    public void outputLogoLayout() {
        String[] classBTBText = {
                "                                    ____     ___                                       ____     ______  ____  ",
                "                                   /\\  _`\\  /\\_ \\                                     /\\  _`\\  /\\__  _\\/\\  _`\\",
                "                                   \\ \\ \\/\\_\\\\//\\ \\       __       ____    ____   __   \\ \\ \\L\\ \\\\/_/\\ \\/\\ \\ \\L\\ \\",
                "                                    \\ \\ \\/_/_ \\ \\ \\    /'__`\\    /',__\\  /',__\\ /\\_\\   \\ \\  _ <'  \\ \\ \\ \\ \\  _ <'",
                "                                     \\ \\ \\L\\ \\ \\_\\ \\_ /\\ \\L\\.\\_ /\\__, `\\/\\__, `\\\\/_/_   \\ \\ \\L\\ \\  \\ \\ \\ \\ \\ \\L\\ \\",
                "                                      \\ \\____/ /\\____\\\\ \\__/.\\_\\\\/\\____/\\/\\____/  /\\_\\   \\ \\____/   \\ \\_\\ \\ \\____/",
                "                                       \\/___/  \\/____/ \\/__/\\/_/ \\/___/  \\/___/   \\/_/    \\/___/     \\/_/  \\/___/ "
        };

        String[] groupBTBText = {
                "                                              ____                                                __ ",
                "                                             /\\  _`\\                                            /'__`\\",
                "                                             \\ \\ \\L\\_\\   _ __   ___    __  __   _____    __    /\\_\\L\\ \\",
                "                                              \\ \\ \\L_L  /\\`'__\\/ __`\\ /\\ \\/\\ \\ /\\ '__`\\ /\\_\\   \\/_/_\\_<_",
                "                                               \\ \\ \\/, \\\\ \\ \\//\\ \\L\\ \\\\ \\ \\_\\ \\\\ \\ \\L\\ \\\\/_/_    /\\ \\L\\ \\",
                "                                                \\ \\____/ \\ \\_\\\\ \\____/ \\ \\____/ \\ \\ ,__/  /\\_\\   \\ \\____/",
                "                                                 \\/___/   \\/_/ \\/___/   \\/___/   \\ \\ \\/   \\/_/    \\/___/",
                "                                                                                  \\ \\_\\",
                "                                                                                   \\/_/"
        };

        CommonMethod.printlnStrings(classBTBText);
        CommonMethod.printlnStrings(groupBTBText);
    }

    public void outputLoadingLayout() {
        OutputLoadingScreen.startThread();
    }

    public void outputMainLayout() {
        AsciiTable mainLayout = new AsciiTable();
        mainLayout.addRule();
        mainLayout.addRow("Display", "Write", "Read", "Update", "Delete", "First", "Previous", "Next");
        mainLayout.addRule();
        mainLayout.addRow("Last", "Goto", "Set Row", "Save", "Back up", "Restore", "Help", "Exit");
        mainLayout.addRule();
        System.out.println(mainLayout.render());
    }

    public void outputProductData(Product product) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("ID", ":" + product.getProductID());
        table.addRule();
        table.addRow("Name", ":" + product.getProductName());
        table.addRule();
        table.addRow("Unit price", ":" + product.getUnitPrice());
        table.addRule();
        table.addRow("Qty", ":" + product.getQuantity());
        table.addRule();
        table.addRow("Imported Date", ":" + product.getImportDate());
        table.addRule();
        table.setPaddingRight(1);
        table.setPaddingLeft(1);
        table.setTextAlignment(TextAlignment.LEFT);
        table.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        table.getContext().setGrid(U8_Grids.borderDoubleLight());

        System.out.println(table.render(50));
    }

    public void displayTableData(Product[] products) {
        AsciiTable table = new AsciiTable();
        AsciiTable pagination = new AsciiTable();

        // TABLE HEADER
        table.addRule();
        table.addRow("ID", "NAME", "UNIT PRICE", "QTY", "IMPORT DATE");
        table.addRule();

        // TABLE BODY
        // IMPLEMENT CURRENT PAGE
        // DISPLAY FROM X TO Y
        // GO TO X PAGE
        for (Product product: products) {
            table.addRow(product.getProductID(), product.getProductName(), product.getUnitPrice(),
                    product.getQuantity() , product.getImportDate());
            table.addRule();
        }

        table.setTextAlignment(TextAlignment.CENTER);
        table.getContext().setGrid(U8_Grids.borderDouble());
        System.out.println(table.render());

        // PAGINATION
        // FIND CURRENT PAGE
        // CALCULATE TOTAL RECORDS
        pagination.addRule();
        pagination.addRow("Page: 1/3000000 ", " \t\t   ", " Total Record:300000");
        pagination.addRule();

        pagination.setTextAlignment(TextAlignment.CENTER);
        pagination.getContext().setGrid(U8_Grids.borderDoubleLight());

        pagination.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        System.out.println(pagination.render());
    }

    public void writeDataLayout() {

    }

    public void readDataLayout() {
        int productID;
        boolean isFound;
        int searchResult;

        productID = TextFieldConsole.readIntegerType("Input the ID of Product : ");
        isFound = findProductByID(productID);

        switch (isFound) {
            case true:
                searchResult = displayProductByID(productID);
                break;

            case false:
                outputMessageLayout("");
                break;
        }

        System.out.println("Product Found for [" + productID + "] : " + searchResult);
    }

    public void searchDataLayout() {
        String productName;
        boolean isFound;
        int searchResult;

        productName = TextFieldConsole.readStringType("Input the Name of Product : ");
        isFound = findProductByName(productName);

        switch (isFound) {
            case true:
                searchResult = displayProductByName(productName);
                break;

            case false:
                outputMessageLayout("");
                break;
        }

        System.out.println("Product Found for [" + productName + "] : " + searchResult);
    }

    public void deleteDataLayout() {
        int productID;
        char choice;
        boolean isFound;
        int searchResult;
        boolean hasDeleted;

        productID = TextFieldConsole.readIntegerType("Input the ID of Product : ");
        isFound = findProductByID(productID);

        if(!isFound) {
            outputMessageLayout("");
        }
        else {
            searchResult = displayProductByID(productID);

            System.out.println("Product Found for [" + productID + "] : " + searchResult);

            choice = TextFieldConsole.readCharType("Are you sure that you want to delete this record? [Y|y] or [N|n] :");
            switch (choice) {
                case 'Y':
                case 'y':
                    hasDeleted = deleteProductByID(productID);
                    break;

                case 'N':
                case 'n':
                    outputMessageLayout("");
                    break;
            }

            if (!hasDeleted) {
                outputMessageLayout("");
            } else {
                outputMessageLayout("Product was removed");
            }
        }
    }

    public void updataDataLayout() {
        int productID;
        char choice;
        boolean isFound;
        int searchResult;
        boolean hasUpdated;

        productID = TextFieldConsole.readIntegerType("Input the ID of Product : ");
        isFound = findProductByID(productID);

        if(!isFound) {
            outputMessageLayout("");
        }
        else {
            searchResult = displayProductByID(productID);

            System.out.println("Product Found for [" + productID + "] : " + searchResult);

            outputUpdateOptionLayout();
            choice = TextFieldConsole.readCharType("What do you want to update : ");

            switch (choice) {
                case UPDATE_ALL:
                    break;
                case UPDATE_NAME:
                    break;
                case UPDATE_UNIT_PRICE:
                    break;
                case UPDATE_QUANTITY:
                    break;
                default:
                    break;
            }
        }
    }

    public void outputHelpLayout() {
        String[] st = {
                "1.             Press\t*:Display all record of product.",
                "2.             Press\tW: Add new Class.Product",
                "               Press\tw ->#proname-unitprice-qty: shortcut for add new product",
                "3.             Press\tr: Read contents",
                "               Press\tr#proId: shortcut for read product by Id",
                "4.     Press\tu : Update Data",
                "5.     Press\td: Delete Data",
                "       Press\td#proId : Shortcut for delete product by Id",
                "6.     Press\tf : Display first page",
                "7.     Press\tp : Display Previous page",
                "8.     Press\tn: Display Next Page",
                "9.     Press\tl : Display Last Page",
                "10.    Press\ts : Search Class.Product by name",
                "11.    Press\tsa : To save record to file",
                "12.    Press\tba : Backup data",
                "13.    Press\tre : To restore data",
                "14.    Press\th : To Help",
        };

        AsciiTable ac = new AsciiTable();
        ac.addRule();
        for (String te : st) {
            ac.addRow("" + te).setPaddingLeft(3);
        }
        ac.addRule();
        System.out.println(ac.render());
    }

    public void outputMessageLayout(String message) {
        AsciiTable dialog = new AsciiTable();
        // DIALOG
        dialog.addRule();
        dialog.addRow(message);
        dialog.addRule();

        dialog.setTextAlignment(TextAlignment.CENTER);
        dialog.getContext().setGridTheme(TA_GridThemes.TOPBOTTOM);
        dialog.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        System.out.println(dialog.render(50));
    }

    public void outputUpdateOptionLayout() {

    }

    public void outputInvalidInputLayout() {

    }

    public void gotoDataLayout() {
        int page;
        page = TextFieldConsole.readIntegerType("Go to Page : ");
        // displayTableData(from, to, collection);
        // assign value for later use
    }

    public void setRowLayout() {
        TextFieldConsole.readIntegerType("Enter Row for Display : ");
    }

    public int displayProductByName() {
        return 0;
    }

    public boolean findProductByName(String productName) {
        return false;
    }

    public int displayProductByName(String productName) {
        return 0;
    }
}
