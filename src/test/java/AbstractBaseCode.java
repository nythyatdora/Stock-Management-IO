import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public Product retreiveProductByID(int productID) {
        return null;
    }

    public int displayProductByName(String productName) {
        return 0;
    }

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




    //KIMLINH
    public void writeDataLayout(HashMap map) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        AsciiTable menu = new AsciiTable();
        Scanner sc = new Scanner(System.in);
        int check, inc = 0;
        boolean b = true, b1 = true;
        String pName;
        int qty;
        double unitPrice;
        inc = map.keySet().size();

        do {
            Product product = new Product();
            inc++;
            System.out.println("Product ID:" + inc);
            product.setProductID(inc);
            System.out.print("Product Name:");
            pName = sc.next();
            product.setProductName(pName);
            System.out.print("Product Quantity:");
            qty = sc.nextInt();
            product.setQuantity(qty);

            System.out.print("Product Unit Price:");
            unitPrice = sc.nextDouble();
            product.setUnitPrice(unitPrice);
            System.out.println("Product import date:" + dateFormat.format(date));
            product.setImportDate(dateFormat.format(date));

            System.out.println("Are you sure want to update this record? [Y/y] or [N/n]");
            while (b1) {
                char ch = sc.next().charAt(0);
                if (ch == 'y' || ch == 'Y') {
                    map.put(inc, product);
                    showMessage("Product was add");

                    break;
                }
                if (ch == 'n' || ch == 'N') {
                    showMessage("Has been cancel");
                    return;
                } else
                    System.out.println("Please input [Y/y] or [N/n]");
            }

            System.out.println("Do you want to keep adding the record? [Y/y] or [N/n]");
            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                continue;
            }
            if (ch == 'n' || ch == 'N') {
                break;
            }

        } while (b);
    }



    public static void showDataTable(Product product) {
        Scanner sc = new Scanner(System.in);
        AsciiTable at = new AsciiTable();
        AsciiTable msg = new AsciiTable();
        at.addRule();
        at.addRow("ID", ":" + product.getProductID());
        at.addRule();
        at.addRow("Name", ":" + product.getProductName());
        at.addRule();
        at.addRow("Unit price", ":" + product.getUnitPrice());
        at.addRule();
        at.addRow("Qty", ":" + product.getQuantity());
        at.addRule();
        at.addRow("Imported Date", ":" + product.getImportDate());
        at.addRule();
        at.setPaddingRight(1);
        at.setPaddingLeft(1);
        at.setTextAlignment(TextAlignment.LEFT);
        at.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        at.getContext().setGrid(U8_Grids.borderDoubleLight());

        System.out.println(at.render(50));
    }
    public void updataDataLayout(int i, HashMap hashMap) {

        if (hashMap.get(i) == null) {
            System.out.println("Cannot not found");
            return;
        } else {


            hashMap.put(i, insertByIndex(i, hashMap));
        }
    }
    public static void showMessage(String msg) {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow(msg);
        at.addRule();
        at.setTextAlignment(TextAlignment.CENTER);
        at.getContext().setGridTheme(TA_GridThemes.TOPBOTTOM);
        at.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        System.out.println(at.render(50));
    }


    private static Product insertByIndex(int i, HashMap<Integer, Product> map) {
        Product product = map.get(i);

        AsciiTable menu = new AsciiTable();
        Scanner sc = new Scanner(System.in);
        int check;
        boolean b = true, b1 = true;
        String pName;
        int qty;
        double unitPrice;

        //Output Table
        showDataTable(product);

        //Output menu
        menu.addRule();
        menu.addRow("1.All", "2.Name", "3.Quantity", "4.Unit Price", "5.Back");
        menu.addRule();
        menu.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        menu.setTextAlignment(TextAlignment.CENTER);
        System.out.println(menu.render());

        do {

            try {

                System.out.print("Option(1-5):");
                check = sc.nextInt();
                switch (check) {

                    case 1:

                        System.out.print("Product Name:");
                        pName = sc.next();

                        System.out.print("Product Quantity:");
                        qty = sc.nextInt();

                        System.out.print("Product Unit Price:");
                        unitPrice = sc.nextDouble();


                        System.out.println("Are you sure want to update this record? [Y/y] or [N/n]");
                        while (b1) {
                            char ch = sc.next().charAt(0);
                            if (ch == 'y' || ch == 'Y') {
                                product.setProductName(pName);
                                product.setQuantity(qty);
                                product.setUnitPrice(unitPrice);
                                showMessage("Product was update");
                                break;
                            }
                            if (ch == 'n' || ch == 'N') {
                                showMessage("Has been cancel");
                                return product;
                            } else
                                System.out.println("Please input [Y/y] or [N/n]");
                        }
                        break;
                    case 2:
                        System.out.print("Product Name:");
                        pName = sc.next();
                        showDataTable(new Product(product.getProductID(), pName, product.getUnitPrice(), product.getQuantity(), product.getImportDate()));
                        System.out.println("Are you sure want to update this record? [Y/y] or [N/n]");
                        while (b1) {
                            char ch = sc.next().charAt(0);
                            if (ch == 'y' || ch == 'Y') {
                                product.setProductName(pName);
                                showMessage("Product was update");
                                break;
                            }
                            if (ch == 'n' || ch == 'N') {
                                showMessage("Has been cancel");
                                return product;
                            } else
                                System.out.println("Please input [Y/y] or [N/n]");
                        }
                        break;
                    case 3:
                        System.out.print("Product Quantity:");
                        qty = sc.nextInt();
                        showDataTable(new Product(product.getProductID(), product.getProductName(), product.getUnitPrice(), qty, product.getImportDate()));
                        System.out.println("Are you sure want to update this record? [Y/y] or [N/n]");
                        while (b1) {
                            char ch = sc.next().charAt(0);
                            if (ch == 'y' || ch == 'Y') {

                                product.setQuantity(qty);
                                showMessage("Product was update");
                                break;
                            }
                            if (ch == 'n' || ch == 'N') {
                                showMessage("Has been cancel");
                                return product;
                            } else
                                System.out.println("Please input [Y/y] or [N/n]");
                        }
                        break;
                    case 4:
                        System.out.print("Product Unit Price:");
                        unitPrice = sc.nextDouble();
                        showDataTable(new Product(product.getProductID(), product.getProductName(), unitPrice, product.getQuantity(), product.getImportDate()));
                        System.out.println("Are you sure want to update this record? [Y/y] or [N/n]");
                        while (b1) {
                            char ch = sc.next().charAt(0);
                            if (ch == 'y' || ch == 'Y') {

                                product.setUnitPrice(unitPrice);
                                showMessage("Product was update");
                                break;
                            }
                            if (ch == 'n' || ch == 'N') {
                                showMessage("Has been cancel");
                                return product;
                            } else
                                System.out.println("Please input [Y/y] or [N/n]");
                        }
                        break;
                    case 5:
                        b = false;
                        break;
                    default:
                        System.out.println("Error... Please Input again");
                        break;


                }
            } catch (Exception ex) {
                System.out.println("Please Input again....");
                sc.next();
                continue;

            }
        } while (b);

        return product;
    }

}
