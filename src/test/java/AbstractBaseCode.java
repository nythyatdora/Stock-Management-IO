import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.a8.A8_Grids;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import org.apache.commons.collections4.MapUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractBaseCode implements DisplayLayout, CoreProcess, DataManipulate, UpdateOption, FileLocation {

    private static ConfigureSetting setting;
    private static ArrayList<Product> listOfProducts;

    AbstractBaseCode() {
         setting = ConfigureSetting.readFromConfigureFile();

         listOfProducts = readDataFromFileProcess();
    }

    // LAYOUT
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
        mainLayout.addRow("[*]\tDisplay","[W|w]\tWrite","[R|r]\tRead","[U|u]\tUpdate","[D|d]\tDelete","[F|f]\tFirst","[P|p]\tPrevious","[N|n]\tNext");
        mainLayout.addRule();
        mainLayout.addRow("[L|l]\tLast","[G|g]\tGoto","[O|o]\tSet Row","[V|v]\tSave","[C|c]\tBack up","[T|t]\tRestore","[H|h]\tHelp","[E|e]\tExit");
        mainLayout.addRule();

       mainLayout.getContext().setWidth(160);
        mainLayout.setTextAlignment(TextAlignment.CENTER);
        mainLayout.getContext().setGrid(U8_Grids.borderDouble());

        System.out.println(mainLayout.render());
    }

    public void outputHelpLayout() {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("1.", "Press","* : Display all record of product").setPaddingLeftRight(2);
        at.addRow("2.", "Press","W : Add new product").setPaddingLeftRight(2);
        at.addRow("",   "Press","W ->#proname-unit_price-qty : shortcut for add new product").setPaddingLeftRight(2);
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

    public void writeDataLayout() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        LinkedHashMap<Integer, Product> hashMap = new LinkedHashMap<>();
        MapUtils.populateMap(hashMap, listOfProducts, Product::getProductID);

        char choice;
        int id = setting.currentID + 1;
        boolean hasInserted = false;
        boolean toContinue = true;
        Product insertProduct;

        System.out.println("[NEW] Product ID : " + id);
        String productName = TextFieldConsole.readStringType( "[NEW] Product Name       : ");
        int productQuantity = TextFieldConsole.readIntegerType("[NEW] Product Quantity   : ");
        double productUnitPrice = TextFieldConsole.readDoubleType( "[NEW] Product Unit-Price : ");
        String importDate = dateFormat.format(date);

        insertProduct = new Product(id, productName, productUnitPrice, productQuantity, importDate);

        do {
            choice = TextFieldConsole.readCharType("Are you sure that you want to insert the product? [Y|y] or [N|n] : ");

            switch (choice) {
                case 'Y':
                case 'y':
                    hasInserted = insertNewProduct(insertProduct, hashMap);
                    break;

                case 'N':
                case 'n':
                    toContinue = false;
                    break;

                default:
                    outputInvalidInputLayout("INVALID INPUT!");
                    break;
            }
        } while(toContinue);

        if(!hasInserted) {
            outputMessageLayout("Process Canceled!");
        }
        else {
            outputMessageLayout("Product was added!");
        }
    }

    public void readDataLayout() {
        int productID;
        boolean isFound;
        HashMap<Integer, Product> hashMap = new HashMap<>();
        MapUtils.populateMap(hashMap, listOfProducts, Product::getProductID);

        productID = TextFieldConsole.readIntegerType("Input the ID of Product : ");
        isFound = findProductByID(productID, hashMap);

        if(!isFound) {
            outputMessageLayout("Product not found!");
        }
        else {
            displayProductByID(productID, hashMap);
        }
    }

    public void searchDataLayout() {
        String productName;
        boolean isFound;
        int searchResult = -1;

        HashMap<String, Product> hashMap = new HashMap<>();
        MapUtils.populateMap(hashMap, listOfProducts, Product::getProductName);

        productName = TextFieldConsole.readStringType("Input the Name of Product : ");
        isFound = findProductByName(productName, hashMap);

        if(!isFound) {
            outputMessageLayout("Product Not Found!");
        }
        else {
            searchResult = displayProductByName(productName, hashMap);
        }

        System.out.println("Product Found for [" + productName + "] : " + searchResult);
    }

    public void deleteDataLayout() {
        int productID;
        char choice;
        boolean isFound;
        boolean hasDeleted = false;
        boolean toContinue = true;

        HashMap<Integer, Product> hashMap = new HashMap<>();
        MapUtils.populateMap(hashMap, listOfProducts, Product::getProductID);

        productID = TextFieldConsole.readIntegerType("Input the ID of Product to Delete : ");
        isFound = findProductByID(productID, hashMap);

        if(!isFound) {
            outputMessageLayout("Product Not Found!");
        }
        else {
            displayProductByID(productID, hashMap);

            do {
                choice = TextFieldConsole.readCharType("Are you sure that you want to delete this record? [Y|y] or [N|n] :");
                switch (choice) {
                    case 'Y':
                    case 'y':
                        hasDeleted = deleteProductByID(productID, hashMap);
                        break;

                    case 'N':
                    case 'n':
                        outputMessageLayout("Process Canceled!");
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

        HashMap<Integer, Product> hashMap = new HashMap<>();
        MapUtils.populateMap(hashMap, listOfProducts, Product::getProductID);

        productID = TextFieldConsole.readIntegerType("Input the ID of Product : ");
        isFound = findProductByID(productID, hashMap);

        if(!isFound) {
            outputMessageLayout("Product not found!");
        }
        else {
            searchProduct = retreiveProductByID(productID, hashMap);
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
                                    hasUpdated = updateProductData(searchProduct);
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
                                    hasUpdated = updateProductName(searchProduct);
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
                                    hasUpdated = updateProductUnitPrice(searchProduct);
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
                                    hasUpdated = updateProductQuantity(searchProduct);
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

    public void saveDataToFileLayout() {
        saveDataToFileProcess();
    }

    public void backupDataToFileLayout() {
        boolean isSuccessful = backupDataToFileProcess();
        if(!isSuccessful) {
            outputInvalidInputLayout("Process Failed!");
        }
        else {
            outputMessageLayout("Backup Successfully!");
        }
    }

    public void restoreDataToFileLayout() {
        boolean isSuccessful = restoreDataToFileProcess();
        if(!isSuccessful) {
            outputInvalidInputLayout("Process Failed!");
        }
        else {
            outputMessageLayout("Restore Successfully!");
        }
    }

    public void moveToFirstPageLayout() {
        moveToFirstProcess(setting.rowSetup, listOfProducts);
    }

    public void moveToPreviousPageLayout() {
        moveToPreviousPageProcess(setting.rowSetup, listOfProducts);
    }

    public void moveToNextPageLayout() {
        moveToNextPageProcess(setting.rowSetup, listOfProducts);
    }

    public void moveToLastPageLayout() {
        moveToLastPageProcess(setting.rowSetup, listOfProducts);
    }

    public void setRowLayout() {
        setRowProcess();
    }

    public void gotoDataLayout() {
        gotoDataProcess(setting.rowSetup, listOfProducts);
    }

    public void exitProgramLayout() {

    }

    public void outputMessageLayout(String message) {
        // DIALOG
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow(message);
        at.addRule();

        at.setPaddingLeftRight(3);
        CWC_LongestLine cwc = new CWC_LongestLine();
        at.getRenderer().setCWC(cwc);
        at.setTextAlignment(TextAlignment.CENTER);
        at.getContext().setGrid(A8_Grids.lineDoubleBlocks());
        System.out.println(at.render());
    }

    public void outputUpdateOptionLayout() {
        AsciiTable table = new AsciiTable();

        table.addRule();
        table.addRow("[1] - All", "[2] - Name", "[3] - Quantity", "[4] - Unit Price", "[5] - Back to Menu");
        table.addRule();
        table.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render());
    }

    public void outputTableDataLayout() {
        displayTableData(setting.rowSetup, setting.currentPage, listOfProducts);
    }

    public void outputInvalidInputLayout(String message) {
        // DIALOG
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow(message);
        table.addRule();

        table.setPaddingLeftRight(3);
        CWC_LongestLine cwc = new CWC_LongestLine();
        table.getRenderer().setCWC(cwc);
        table.setTextAlignment(TextAlignment.CENTER);
        table.getContext().setGridTheme(TA_GridThemes.HORIZONTAL);
        System.out.println(table.render());
    }
    // END LAYOUT

    // PROCESS
    public ArrayList<Product> readDataFromFileProcess() {
        String str;
        String temp = "";
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(FileLocation.DEFAULT_FILE_NAME));

            str = bufferedReader.readLine();
            while (str != null) {
                temp = temp.concat(str);
                str = bufferedReader.readLine();
            }

            bufferedReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        StringTokenizer stringTokenizer = new StringTokenizer(temp, "+");
        ArrayList<String> arr = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            arr.add(stringTokenizer.nextToken());
        }

        ArrayList<Product> obj = new ArrayList<>();

        for (String anArr1 : arr) {
            String a[] = anArr1.split("#");
            obj.add(new Product(Integer.parseInt(a[0]), a[1], Double.parseDouble(a[2]), Integer.parseInt(a[3]), a[4]));
        }
        return obj;
    }

    @Override
    public void saveDataToFileProcess() {

    }

    @Override
    public boolean backupDataToFileProcess() {
        FileInputStream inputStream;
        FileOutputStream outputStream;

        try {
            File currentCollectionFile = new File(setting.currentCollectionFile);
            File backupCollectionFileWithLocation = new File(setting.getBackupFileName());

            inputStream = new FileInputStream(currentCollectionFile);
            outputStream = new FileOutputStream(backupCollectionFileWithLocation);

            byte[] buffer = new byte[1024];

            int length;

            /*
             * copying the contents from input stream to
             * output stream using read and write methods
             */
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            // Closing the input/output file streams
            inputStream.close();
            outputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean restoreDataToFileProcess() {
        int numberOfFile = 1;
        String fileToBackup;

        List<String> result = null;
        FileInputStream inputStream;
        FileOutputStream outputStream;

        try {

            System.out.println("==================== PLEASE CHOOSE A BACKUP FILE ====================");
            try (Stream<Path> walk = Files.walk(Paths.get("src/Backup"))) {

                result = walk.filter(Files::isRegularFile)
                        .map(x -> x.toString()).collect(Collectors.toList());

                for (String listOfFile : result){
                    System.out.println(numberOfFile+")"+listOfFile);
                    numberOfFile++;
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            int indexOfFile = TextFieldConsole.readIntegerType("Choose File for Backup : ");

            fileToBackup = result.get(indexOfFile - 1);

            File infile = new File(fileToBackup);
            File outfile = new File(setting.currentCollectionFile);

            inputStream = new FileInputStream(infile);
            outputStream = new FileOutputStream(outfile);

            byte[] buffer = new byte[1024];

            int length;
            /*
            copying the contents from input stream to
             * output stream using read and write methods
             */
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            //Closing the input/output file streams
            inputStream.close();
            outputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void moveToFirstProcess(int rowSetup, ArrayList<Product> products) {
        displayTableData(rowSetup, 1, products);
        setting.currentPage = 1;
    }

    public void moveToLastPageProcess(int rowSetup, ArrayList<Product> products) {
        int lastPage = products.size() / rowSetup;
        int temp = products.size() % rowSetup;

        if (temp != 0) {
            lastPage++;
        }

        setting.currentPage = lastPage;
        displayTableData(rowSetup,setting.currentPage, products);
    }

    public void moveToPreviousPageProcess(int rowSetup, ArrayList<Product> products) {
        int lastPage = products.size() / rowSetup;
        int temp = products.size() % rowSetup;

        if (temp != 0) {
            lastPage++;
        }
        if (setting.currentPage == 0) {
            setting.currentPage = lastPage;
        }

        System.out.println(setting.currentPage);
        setting.currentPage--;
        displayTableData(rowSetup, setting.currentPage, products);
    }

    public void moveToNextPageProcess(int rowSetup, ArrayList<Product> products) {
        int lastPage = products.size() / rowSetup;
        int temp = products.size() % rowSetup;

        if (temp != 0) {
            lastPage++;
        }

        if (setting.currentPage == lastPage) {
            setting.currentPage = 0;
        }
        setting.currentPage++;
        displayTableData(rowSetup, setting.currentPage, products);
    }

    public void setRowProcess() {
        setting.rowSetup = TextFieldConsole.readIntegerType("Enter Row for Display : ");
    }

    public void gotoDataProcess(int rowSetup, ArrayList<Product> products) {
        setting.currentPage = TextFieldConsole.readIntegerType("Go to Page : ");

        displayTableData(setting.rowSetup, setting.currentPage, products);

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

    public void displayTableData(int rowSetup, int viewPage, ArrayList<Product> products) {

        if (rowSetup <= 0 || viewPage <= 0) {
             System.out.println("Can not input less than 0");
            return;
        }
        AsciiTable table = new AsciiTable();
        AsciiTable pagination = new AsciiTable();

        long lastPage = products.size() / rowSetup;
        long temp = products.size() % rowSetup;

        if (temp != 0) {
            lastPage++;
        }

        if (viewPage > lastPage) {
            // System.out.println("This viewPage is not found!");
            return;
        }

        table.addRule();
        table.addRow("ID", "NAME", "UNIT PRICE", "QTY", "IMPORT DATE");
        table.addRule();

        if (lastPage == viewPage) {
            for (int i = (viewPage - 1) * rowSetup; i < products.size(); i++) {
                Product product = products.get(i);

                table.addRow(product.getProductID(), product.getProductName(), product.getUnitPrice(),
                        product.getQuantity(), product.getImportDate());
                table.addRule();
            }
        }
        else {
            int t = viewPage * rowSetup;
            for (int j = t - rowSetup; j < t; j++) {
                Product product = products.get(j);

                table.addRow(product.getProductID(), product.getProductName(), product.getUnitPrice(),
                        product.getQuantity(), product.getImportDate());
                table.addRule();
            }
        }

        table.setTextAlignment(de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment.CENTER);
        table.getContext().setGrid(U8_Grids.borderDouble());
        System.out.println(table.render());

        pagination.addRule();
        pagination.addRow("viewPage:" + viewPage + "/" + lastPage, " \t\t   ", " Total Record:" + products.size());
        pagination.addRule();

        pagination.setTextAlignment(de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment.CENTER);
        pagination.getContext().setGrid(U8_Grids.borderDoubleLight());

        pagination.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        System.out.println(pagination.render());
    }

    public boolean findProductByID(int productID, HashMap hashMap) {
        return hashMap.containsKey(productID);
    }

    public boolean findProductByName(String productName, HashMap<String, Product> hashMap) {
        return hashMap.containsKey(productName);
    }

    public boolean insertNewProduct(Product product, HashMap<Integer, Product> hashMap) {
        hashMap.put(product.getProductID(), product);
        return true;
    }

    public Product retreiveProductByID(int productID, HashMap<Integer, Product> hashMap) {
        return hashMap.get(productID);
    }

    public void displayProductByID(int productID, HashMap<Integer, Product> hashMap) {
        Product productToOutput = hashMap.get(productID);
        outputProductData(productToOutput);
    }

    public int displayProductByName(String productName, HashMap<String, Product> hashMap) {
        return 0;
    }

    public boolean deleteProductByID(int productID, HashMap<Integer, Product> hashMap) {
        hashMap.remove(productID);
        return true;
    }

    public boolean updateProductData(Product product) {
        char choice;
        String productName;
        int productQuantity;
        double productUnitPrice;

        productName = TextFieldConsole.readStringType( "[NEW] Product Name       : ");
        productQuantity = TextFieldConsole.readIntegerType("[NEW] Product Quantity   : ");
        productUnitPrice = TextFieldConsole.readDoubleType( "[NEW] Product Unit-Price : ");

        do {
            choice = TextFieldConsole.readCharType("Are you sure that you want to update this record? [Y|y] or [N|n] : ");
            switch (choice) {
                case 'Y':
                case 'y':
                    product.setProductName(productName);
                    product.setQuantity(productQuantity);
                    product.setUnitPrice(productUnitPrice);
                    return true;

                case 'N':
                case 'n':
                    outputMessageLayout("Process Canceled!");
                    return false;

                default:
                    outputInvalidInputLayout("Invalid Input!");
            }
        } while (true);
    }

    public boolean updateProductName(Product product) {
        char choice;
        String productName;

        productName = TextFieldConsole.readStringType("[NEW] Product Name       : ");

        do {
            choice = TextFieldConsole.readCharType("Are you sure that you want to update this record? [Y|y] or [N|n] : ");
            switch (choice) {
                case 'Y':
                case 'y':
                    product.setProductName(productName);
                    return true;

                case 'N':
                case 'n':
                    outputMessageLayout("Process Canceled!");
                    return false;

                default:
                    outputInvalidInputLayout("Invalid Input!");
            }
        } while (true);
    }

    public boolean updateProductQuantity(Product product) {
        char choice;
        int productQuantity;

        productQuantity = TextFieldConsole.readIntegerType("[NEW] Product Quantity   : ");

        do {
            choice = TextFieldConsole.readCharType("Are you sure that you want to update this record? [Y|y] or [N|n] : ");
            switch (choice) {
                case 'Y':
                case 'y':
                    product.setQuantity(productQuantity);
                    return true;

                case 'N':
                case 'n':
                    return false;

                default:
                    outputInvalidInputLayout("INVALID INPUT!");
            }
        } while (true);
    }

    public boolean updateProductUnitPrice(Product product) {
        char choice;
        double productUnitPrice;

        productUnitPrice = TextFieldConsole.readDoubleType( "[NEW] Product Unit-Price : ");

        do {
            choice = TextFieldConsole.readCharType("Are you sure that you want to update this record? [Y|y] or [N|n] : ");
            switch (choice) {
                case 'Y':
                case 'y':
                    product.setUnitPrice(productUnitPrice);
                    return true;

                case 'N':
                case 'n':
                    outputMessageLayout("Process Canceled!");
                    return false;

                default:
                    outputInvalidInputLayout("Invalid Input!");
            }
        } while (true);
    }
    // END PROCESS

    public void writeExampleRecords(){
        long startTime;
        long endTime;
        long duration;

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileLocation.DEFAULT_FILE_NAME));

            startTime = System.currentTimeMillis();
            for (int i = 1; i <= 100; ++i) {
                bufferedWriter.append("+").append((new Product(i, "ca", 12, 12, "22")).ToString());
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

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
