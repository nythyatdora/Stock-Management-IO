import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.a7.A7_Grids;
import de.vandermeer.asciithemes.a8.A8_Grids;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public abstract class AbstractBaseCode implements DisplayLayout, CoreProcess, DataManipulate, UpdateOption, FileLocation {
    private ConfigureSetting setting;

    AbstractBaseCode() {
        setting = new ConfigureSetting();
        // READ DATA FROM setting.bak
        // IF FILE NOT EXIST
        //      CREATE DEFAULT SETTING
        // ELESE
        //      READ FROM FILE TO this.setting
    }

    public ArrayList<Product> readDataFromFile() {
        String str;
        String temp = "";
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(FileLocation.DEFAULT_FILE_NAME));

            str = bufferedReader.readLine();
            while (str != null) {
                str = bufferedReader.readLine();
                temp = temp.concat(str);
            }

            bufferedReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        StringTokenizer stringTokenizer = new StringTokenizer(temp, "+");
        ArrayList<String> arr = new ArrayList<String>();

        while (stringTokenizer.hasMoreTokens()) {
            arr.add(stringTokenizer.nextToken());
        }

        ArrayList<Product> obj = new ArrayList<Product>();

        for (String anArr1 : arr) {
            String a[] = anArr1.split("#");
            obj.add(new Product(Integer.parseInt(a[0]), a[1], Double.parseDouble(a[2]), Integer.parseInt(a[3]), a[4]));
        }
        return obj;
    }

    public void saveDataToFile() {
        long startTime;
        long endTime;
        long duration;

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileLocation.DEFAULT_FILE_NAME));

            startTime = System.currentTimeMillis();
            for (int i = 1; i <= 100; ++i) {
                bufferedWriter.append("+").append((new Product(i, "ca", 12, 12, "22")).toString());
            }
            endTime = System.currentTimeMillis();

            duration = endTime - startTime;
            System.out.println(duration);

            bufferedWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backUpDataToFile() {

    }

    public void restoreDataToFile() {

    }

    public void moveToFirstPage() {
        // displayTableData(setting.rowStart, length_setup_row, collection)
    }

    public void moveToLastPage() {
        // displayTableData(length_collection - length_setup_row, length_setup_row, collection)
    }

    public void moveToPreviousRow() {
        // set --setting.rowStart;
        // displayTableData(setting.rowStart, setting.rowDisplayLimit, collection)
        // calculate page
    }

    public void moveToNextRow() {
        // set ++setting.rowStart;
        // displayTableData(setting.rowStart, setting.rowDisplayLimit, collection)
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
        OutputLoadingScreen outputLoadingScreen = new OutputLoadingScreen();
        outputLoadingScreen.startThread();
    }

    public void outputMainLayout() {
        AsciiTable mainLayout = new AsciiTable();

        mainLayout.addRule();
        mainLayout.addRow("[D|d]\tDisplay","[W|w]\tWrite","[R|r]\tRead","[U|u]\tUpdate","[D|d]\tDelete","[F|f]\tFirst","[P|p]\tPrevious","[N|n]\tNext");
        mainLayout.addRule();
        mainLayout.addRow("[L|l]\tLast","[G|g]\tGoto","[O|o]\tSet Row","[V|v]\tSave","[C|c]\tBack up","[T|t]\tRestore","[H|h]\tHelp","[E|e]\tExit");
        mainLayout.addRule();

        mainLayout.getContext().setWidth(160);
        mainLayout.setTextAlignment(TextAlignment.CENTER);
        mainLayout.getContext().setGrid(U8_Grids.borderDouble());

        System.out.println(mainLayout.render());
    }

    public void outputProductData(Product product) {
        AsciiTable table = new AsciiTable();

        table.addRule();
        table.addRow("ID", " : " + + product.getProductID());

        table.addRow("Name", " : " + product.getProductName());

        table.addRow("Unit price", " : " + product.getUnitPrice());

        table.addRow("Qty", " : " + product.getQuantity());

        table.addRow("Imported Date", " : " + product.getImportDate());
        table.addRule();

        table.setPaddingRight(3);
        table.setPaddingLeft(1);
        CWC_LongestLine cwc = new CWC_LongestLine();
        table.getRenderer().setCWC(cwc);
        table.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        table.getContext().setGrid(U8_Grids.borderDouble());
        System.out.println(table.render());
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

        productID = TextFieldConsole.readIntegerType("Input the ID of Product : ");
        isFound = findProductByID(productID);

        if(!isFound) {
            outputMessageLayout("Product not found!");
        }
        else {
            displayProductByID(productID);
        }
    }

    public void searchDataLayout() {
        String productName;
        boolean isFound;
        int searchResult = -1;

        productName = TextFieldConsole.readStringType("Input the Name of Product : ");
        isFound = findProductByName(productName);

        if(!isFound) {
            outputMessageLayout("");
        }
        else {
            searchResult = displayProductByName(productName);
        }

        System.out.println("Product Found for [" + productName + "] : " + searchResult);
    }

    public void deleteDataLayout() {
        int productID;
        char choice;
        boolean isFound;
        int searchResult;
        boolean hasDeleted = false;
        boolean toContinue = true;

        productID = TextFieldConsole.readIntegerType("Input the ID of Product to Delete : ");
        isFound = findProductByID(productID);

        if(!isFound) {
            outputMessageLayout("");
        }
        else {
            searchResult = displayProductByID(productID);

            System.out.println("Product Found for [" + productID + "] : " + searchResult);

            do {
                choice = TextFieldConsole.readCharType("Are you sure that you want to delete this record? [Y|y] or [N|n] :");
                switch (choice) {
                    case 'Y':
                    case 'y':
                        hasDeleted = deleteProductByID(productID);
                        break;

                    case 'N':
                    case 'n':
                        outputMessageLayout("");
                        toContinue = false;
                        break;
                }
            }
            while (toContinue);

            if (!hasDeleted) {
                outputMessageLayout("Process canceled!");
            } else {
                outputMessageLayout("Product was removed");
            }
        }
    }

    public void updataDataLayout() {
        int productID;
        char choice;
        char innerChoice;

        boolean isFound;
        boolean hasUpdated = false;
        boolean isContinue = true;

        Product searchProduct;

        productID = TextFieldConsole.readIntegerType("Input the ID of Product : ");
        isFound = findProductByID(productID);

        if(!isFound) {
            outputMessageLayout("Product not found!");
        }
        else {
            searchProduct = retreiveProductByID(productID);
            outputProductData(searchProduct);

            do {
                System.out.println("What do you want to update?");
                outputUpdateOptionLayout();
                choice = TextFieldConsole.readCharType("What do you want to update : ");

                switch (choice) {
                    case UPDATE_ALL:

                        do {
                            outputProductData(searchProduct);
                            innerChoice = TextFieldConsole.readCharType("Are you sure that you want to update this record? [Y|y] or [N|n] : ");
                            switch (innerChoice) {
                                case 'Y':
                                case 'y':
                                    hasUpdated = updateProductData(productID);
                                    isContinue = false;
                                    break;

                                case 'N':
                                case 'n':
                                    outputMessageLayout("Invalid input!");
                                    break;
                            }
                        }
                        while(isContinue);
                        break;

                    case UPDATE_NAME:
                        do {
                            outputProductData(searchProduct);
                            innerChoice = TextFieldConsole.readCharType("Are you sure that you want to update this record? [Y|y] or [N|n] : ");
                            switch (innerChoice) {
                                case 'Y':
                                case 'y':
                                    hasUpdated = updateProductName(productID);
                                    isContinue = false;
                                    break;

                                case 'N':
                                case 'n':
                                    outputMessageLayout("Invalid input!");
                                    break;
                            }
                        }
                        while(isContinue);
                        break;

                    case UPDATE_UNIT_PRICE:
                        do {
                            outputProductData(searchProduct);
                            innerChoice = TextFieldConsole.readCharType("Are you sure that you want to update this record? [Y|y] or [N|n] : ");
                            switch (innerChoice) {
                                case 'Y':
                                case 'y':
                                    hasUpdated = updateProductUnitPrice(productID);
                                    isContinue = false;
                                    break;

                                case 'N':
                                case 'n':
                                    outputMessageLayout("Invalid input!");
                                    break;
                            }
                        }
                        while(isContinue);
                        break;

                    case UPDATE_QUANTITY:
                        do {
                            outputProductData(searchProduct);
                            innerChoice = TextFieldConsole.readCharType("Are you sure that you want to update this record? [Y|y] or [N|n] : ");
                            switch (innerChoice) {
                                case 'Y':
                                case 'y':
                                    hasUpdated = updateProductQuantity(productID);
                                    isContinue = false;
                                    break;

                                case 'N':
                                case 'n':
                                    outputMessageLayout("Invalid input!");
                                    break;
                            }
                        }
                        while(isContinue);
                        break;

                    case RETURN_TO_MAIN:
                        isContinue = false;
                        break;

                    default:
                        outputMessageLayout("Invalid Input!");
                }
            } while (isContinue);
        }

        if(!hasUpdated) {
            outputMessageLayout("Update process canceled!");
        }
        else {
            outputMessageLayout("Product was updated!");
        }
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
        at.getContext().setGrid(U8_Grids.borderDouble());
        System.out.println(at.render());
    }

    public void outputMessageLayout(String message) {
        // DIALOG
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow(message);
        at.addRule();

        at.setPaddingLeftRight(3);
        CWC_LongestLine cwc = new CWC_LongestLine(); //for auto resize
        at.getRenderer().setCWC(cwc);
        at.setTextAlignment(TextAlignment.CENTER);
        at.getContext().setGrid(A8_Grids.lineDoubleBlocks());
        System.out.println(at.render());
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

    public boolean findProductByID(int productID) { return false; }

    public boolean findProductByName(String productName) {
        return false;
    }

    public Product retreiveProductByID(int productID) { return null; }

    public int displayProductByID(int productID) { return 0; }

    public int displayProductByName(String productName) { return 0; }

    public boolean deleteProductByID(int productID) { return false; }

    public boolean updateProductData(int productID) {
        return false;
    }

    public boolean updateProductName(int productID) {
        return false;
    }

    public boolean updateProductQuantity(int productID) {
        return false;
    }

    public boolean updateProductUnitPrice(int productID) {
        return false;
    }
}
