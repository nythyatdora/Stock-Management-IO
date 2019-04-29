import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.a7.A7_Grids;
import de.vandermeer.asciithemes.a8.A8_Grids;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.HashMap;
import java.util.Scanner;

public abstract class AbstractBaseCode implements DisplayLayout, CoreProcess, DataManipulate {
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

    public void readDataLayout() {}

    public void searchDataLayout() {
        String productName;
        boolean isFound;
        int searchResult;

        productName = TextFieldConsole.readStringType("Input the Name of Product : ");
        isFound = findProductByName();

        switch (isFound) {
            case true:
                searchResult = displayProductByName();
                break;

            case false:
                outputMessageLayout("");
                break;
        }

        System.out.println("Product Found for [" + productName + "] : " + searchResult);
    }

    public void deleteDataLayout() {
        TextFieldConsole inputfield = new TextFieldConsole();
        int productID;
        char choice;
        int searchResult;
        boolean hasDeleted;

        productID = inputfield.readIntegerType("Input the ID of Product : ");
        searchResult = findProductByID(productID);
        displayProductByID(productID);

        System.out.println("Product Found for [" + productID + "] : " + searchResult);

        choice = inputfield.readCharType("Are you sure that you want to delete this record? [Y|y] or [N|n] :");
        switch(choice) {
            case 'Y':
            case 'y':
                hasDeleted = deleteProductByID();
                break;

            case 'N':
            case 'n':
                break;
        }

        if(!hasDeleted) {
            outputMessage("");
        }
        else {
            outputMessage("Product was removed");
        }
    }

    public void updataDataLayout() {

    }

    public void outputHelpLayout() {

        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("1.", "Press","* : Display all record of product").setPaddingLeftRight(2);
        at.addRow("2.", "Press","W : Add new product").setPaddingLeftRight(2);
        at.addRow("",   "Press","W ->#proname-unitprice-qty : shortcut for add new product").setPaddingLeftRight(2);
        at.addRow("3.", "Press","r : read Content any content").setPaddingLeftRight(2);
        at.addRow("",   "Press","r#proId shortcut for read product by Id").setPaddingLeftRight(2);
        at.addRow("4.", "Press","u : Update Data").setPaddingLeftRight(2);
        at.addRow("5.", "Press","d : Delete Data").setPaddingLeftRight(2);
        at.addRow("",   "Press","d#proId shortcut for delete product by Id").setPaddingLeftRight(2);
        at.addRow("6.", "Press","f : Display First Page").setPaddingLeftRight(2);
        at.addRow("7.", "Press","p : Display Previous Page").setPaddingLeftRight(2);
        at.addRow("8.", "Press","n : Display Next Page").setPaddingLeftRight(2);
        at.addRow("9.", "Press","l : Display Last Page").setPaddingLeftRight(2);
        at.addRow("10.", "Press","n : Search product by name").setPaddingLeftRight(2);
        at.addRow("11.", "Press","sa : save record to file").setPaddingLeftRight(2);
        at.addRow("12.", "Press","ba : Backup Data").setPaddingLeftRight(2);
        at.addRow("13.", "Press","re : Restore data").setPaddingLeftRight(2);
        at.addRow("14.", "Press","h : Help").setPaddingLeftRight(2);

        at.addRule();
        CWC_LongestLine cwc = new CWC_LongestLine();
        at.getRenderer().setCWC(cwc);
        at.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        at.getContext().setGrid(A7_Grids.minusBarPlusEquals());
        System.out.println(at.render());
    }

    public void outputMessageLayout(String message) {
        // DIALOG
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow(message);
        at.addRule();

        at.getContext().setWidth(30);
        at.setTextAlignment(TextAlignment.CENTER);
        at.getContext().setGrid(A8_Grids.lineDoubleBlocks());
        System.out.println(at.render());
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

    public boolean findProductByID() {
        return false;
    }

    public boolean findProductByName() {
        return false;
    }

    public int displayProductByName() {
        return 0;
    }
}
