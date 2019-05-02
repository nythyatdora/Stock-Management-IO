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
        boolean isSettingExisted = ConfigureSetting.isFileExist();

        if(!isSettingExisted)
            ConfigureSetting.writeToConfigureFile(new ConfigureSetting());

        setting = ConfigureSetting.readFromConfigureFile();
        // listOfProducts = readDataFromFileProcess();
    }

    // LAYOUT
    public void outputWelcomeLayout() {
        String[] stockText = {
                "            ____    __                   __                                                                                       __",
                "           /\\  _`\\ /\\ \\__               /\\ \\          /'\\_/`\\                                                                    /\\ \\__",
                "           \\ \\,\\L\\_\\ \\ ,_\\   ___     ___\\ \\ \\/'\\     /\\      \\     __      ___      __       __      __    ___ ___      __    ___\\ \\ _\\",
                "            \\/_\\__ \\\\ \\ \\/  / __`\\  /'___\\ \\ , <     \\ \\ \\__\\ \\  /'__`\\  /' _ `\\  /'__`\\   /'_ `\\  /'__`\\/' __` __`\\  /'__`\\/' _ `\\ \\ \\/",
                "              /\\ \\L\\ \\ \\ \\_/\\ \\L\\ \\/\\ \\__/\\ \\ \\\\`\\    \\ \\ \\_/\\ \\/\\ \\L\\.\\_/\\ \\/\\ \\/\\ \\L\\.\\_/\\ \\L\\ \\/\\  __//\\ \\/\\ \\/\\ \\/\\  __//\\ \\/\\ \\ \\ \\_",
                "              \\ `\\____\\ \\__\\ \\____/\\ \\____\\\\ \\_\\ \\_\\   \\ \\_\\\\ \\_\\ \\__/.\\_\\ \\_\\ \\_\\ \\__/.\\_\\ \\____ \\ \\____\\ \\_\\ \\_\\ \\_\\ \\____\\ \\_\\ \\_\\ \\__\\",
                "               \\/_____/\\/__/\\/___/  \\/____/ \\/_/\\/_/    \\/_/ \\/_/\\/__/\\/_/\\/_/\\/_/\\/__/\\/_/\\/___L\\ \\/____/\\/_/\\/_/\\/_/\\/____/\\/_/\\/_/\\/__/",
                "                                                                                             /\\____/",
                "                                                                                             \\_/__/"
        };
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
//        OutputLoadingScreen outputLoadingScreen = new OutputLoadingScreen();
//        outputLoadingScreen.startThread();
        listOfProducts = readDataFromFileProcess();
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
        at.addRow("1.", "Press","[*]    : Display all record of product").setPaddingLeftRight(2);
        at.addRow("2.", "Press","[W|w]  : Add new product").setPaddingLeftRight(2);
        at.addRow("",   "Press","[W|w] -> #proname-unit_price-qty : shortcut for add new product").setPaddingLeftRight(2);
        at.addRow("3.", "Press","[R|r]  : read Content any content").setPaddingLeftRight(2);
        at.addRow("",   "Press","[R|r] -> #proId shortcut for read product by Id").setPaddingLeftRight(2);
        at.addRow("4.", "Press","[U|u]  : Update Data").setPaddingLeftRight(2);
        at.addRow("5.", "Press","[D|d]  : Delete Data").setPaddingLeftRight(2);
        at.addRow("",   "Press","[D|d] -> #proId shortcut for delete product by Id").setPaddingLeftRight(2);
        at.addRow("6.", "Press","[F|f]  : Display First Page").setPaddingLeftRight(2);
        at.addRow("7.", "Press","[P|p]  : Display Previous Page").setPaddingLeftRight(2);
        at.addRow("8.", "Press","[N|n]  : Display Next Page").setPaddingLeftRight(2);
        at.addRow("9.", "Press","[L|l]  : Display Last Page").setPaddingLeftRight(2);
        at.addRow("10.", "Press","[N|n] : Search product by name").setPaddingLeftRight(2);
        at.addRow("11.", "Press","[V|v] : save record to file").setPaddingLeftRight(2);
        at.addRow("12.", "Press","[C|c] : Backup Data").setPaddingLeftRight(2);
        at.addRow("13.", "Press","[T|t] : Restore data").setPaddingLeftRight(2);
        at.addRow("14.", "Press","[H|h] : Help").setPaddingLeftRight(2);
        at.addRule();

        CWC_LongestLine cwc = new CWC_LongestLine();
        at.getRenderer().setCWC(cwc);
        at.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        at.getContext().setGrid(U8_Grids.borderDouble());

        System.out.println(at.render());
    }

    public void writeDataLayout() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();

        LinkedHashMap<Integer, Product> hashMap = new LinkedHashMap<>();
        MapUtils.populateMap(hashMap, listOfProducts, Product::getProductID);

        char choice;
        int id = setting.currentID + 1;
        boolean hasInserted = false;
        boolean toContinue = true;
        Product insertProduct;

        System.out.println("======== INSERT NEW PRODUCT =========");
        System.out.println("[NEW] Product ID         : " + id);
        String productName = TextFieldConsole.readStringType("[NEW] Product Name       : ");
        int productQuantity = TextFieldConsole.readIntegerType("[NEW] Product Quantity   : ");
        double productUnitPrice = TextFieldConsole.readDoubleType("[NEW] Product Unit-Price : ");
        String importDate = dateFormat.format(date);

        insertProduct = new Product(id, productName, productUnitPrice, productQuantity, importDate);

        System.out.println();
        outputProductData(insertProduct);
        System.out.println();

        do {
            choice = TextFieldConsole.readCharType("Are you sure that you want to insert the product? [Y|y] or [N|n] : ");
            System.out.println();
            switch (choice) {
                case 'Y':
                case 'y':
                    hasInserted = insertNewProduct(insertProduct, hashMap);
                    toContinue = false;
                    break;

                case 'N':
                case 'n':
                    toContinue = false;
                    break;

                default:
                    outputMessageErrorLayout("Invalid Input!");
                    break;
            }
        } while(toContinue);

        if(!hasInserted) {
            outputMessageErrorLayout("Process Canceled!");
        }
        else {
            setting.currentID++;
            ConfigureSetting.writeToConfigureFile(setting);

            listOfProducts = new ArrayList<>(hashMap.values());
            outputMessageLayout("Product with ID : " + id + " was added successfully!");
        }
    }

    public void readDataLayout() {
        int productID;
        boolean isFound;

        HashMap<Integer, Product> hashMap = new HashMap<>();
        MapUtils.populateMap(hashMap, listOfProducts, Product::getProductID);

        System.out.println("======== READ PRODUCT =========");
        productID = TextFieldConsole.readIntegerType("Input the ID of Product : ");
        isFound = findProductByID(productID, hashMap);

        System.out.println();

        if(!isFound) {
            outputMessageErrorLayout("Product not found!");
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
            outputMessageErrorLayout("Product Not Found!" );
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

        System.out.println("======= DELETE PRODUCT ========");
        productID = TextFieldConsole.readIntegerType("Input the ID of Product : ");
        isFound = findProductByID(productID, hashMap);
        System.out.println();

        if(!isFound) {
            outputMessageErrorLayout("Product Not Found!");
        }
        else {
            displayProductByID(productID, hashMap);
            System.out.println();

            do {
                choice = TextFieldConsole.readCharType("Are you sure that you want to delete this record? [Y|y] or [N|n] : ");
                switch (choice) {
                    case 'Y':
                    case 'y':
                        hasDeleted = deleteProductByID(productID, hashMap);
                        toContinue = false;
                        break;

                    case 'N':
                    case 'n':
                        toContinue = false;
                        break;
                }
            }
            while (toContinue);

            if (!hasDeleted) {
                System.out.println();
                outputMessageErrorLayout("Process Canceled!");
            }
            else {
                listOfProducts = new ArrayList<>(hashMap.values());
                outputMessageLayout("Product with ID : " + productID + " was deleted successfully!");
            }
        }
    }

    public void updataDataLayout() {
        int productID;
        int choice;

        boolean isFound;
        boolean hasUpdated = false;
        boolean isContinue = true;

        String productName;
        int productQuantity;
        double productUnitPrice;

        Product searchProduct;

        HashMap<Integer, Product> hashMap = new HashMap<>();
        MapUtils.populateMap(hashMap, listOfProducts, Product::getProductID);

        System.out.println("======= UPDATE PRODUCT ========");
        productID = TextFieldConsole.readIntegerType("Input the ID of Product : ");
        isFound = findProductByID(productID, hashMap);

        if(!isFound) {
            System.out.println();
            outputMessageErrorLayout("Product Not Found!");
            return;
        }
        else {
            searchProduct = retreiveProductByID(productID, hashMap);

            System.out.println();
            outputProductData(searchProduct);
            System.out.println();

            do {
                System.out.println("What do you want to update?");
                outputUpdateOptionLayout();
                choice = TextFieldConsole.readIntegerType("Option : ");

                switch (choice) {
                    case UPDATE_ALL:
                        System.out.println("======== UPDATE PRODUCT ========");
                        productName = TextFieldConsole.readStringType("[NEW] Product Name       : ");
                        productQuantity = TextFieldConsole.readIntegerType("[NEW] Product Quantity   : ");
                        productUnitPrice = TextFieldConsole.readDoubleType("[NEW] Product Unit-Price : ");

                        searchProduct.setProductName(productName);
                        searchProduct.setQuantity(productQuantity);
                        searchProduct.setUnitPrice(productUnitPrice);

                        System.out.println();
                        outputProductData(searchProduct);
                        System.out.println();

                        hasUpdated = toUpdateOrNot(searchProduct, hashMap);

                        isContinue = false;
                        break;

                    case UPDATE_NAME:
                        System.out.println("======== UPDATE PRODUCT ========");
                        productName = TextFieldConsole.readStringType("[NEW] Product Name       : ");

                        searchProduct.setProductName(productName);

                        System.out.println();
                        outputProductData(searchProduct);
                        System.out.println();

                        hasUpdated = toUpdateOrNot(searchProduct, hashMap);

                        isContinue = false;
                        break;

                    case UPDATE_UNIT_PRICE:
                        System.out.println("======== UPDATE PRODUCT ========");
                        productUnitPrice = TextFieldConsole.readDoubleType("[NEW] Product Unit-Price : ");

                        searchProduct.setUnitPrice(productUnitPrice);

                        System.out.println();
                        outputProductData(searchProduct);
                        System.out.println();

                        hasUpdated = toUpdateOrNot(searchProduct, hashMap);

                        isContinue = false;
                        break;

                    case UPDATE_QUANTITY:
                        System.out.println("======== UPDATE PRODUCT ========");
                        productQuantity = TextFieldConsole.readIntegerType("[NEW] Product Quantity   : ");

                        searchProduct.setQuantity(productQuantity);

                        System.out.println();
                        outputProductData(searchProduct);
                        System.out.println();

                        hasUpdated = toUpdateOrNot(searchProduct, hashMap);

                        isContinue = false;
                        break;

                    case RETURN_TO_MAIN:
                        isContinue = false;
                        break;

                    default:
                        System.out.println();
                        outputMessageErrorLayout("Invalid Input!");
                        System.out.println();
                        break;
                }
            }
            while (isContinue);
        }

        if(!hasUpdated) {
            System.out.println();
            outputMessageErrorLayout("Process Canceled!");
            System.out.println();
        }
        else {
            listOfProducts = new ArrayList<>(hashMap.values());

            System.out.println();
            outputMessageLayout("Product with ID : " + productID + " was updated successfully!");
        }
    }

    public void saveDataToFileLayout() {
        saveDataToFileProcess();
    }

    public void backupDataToFileLayout() {
        boolean isSuccessful = backupDataToFileProcess();
        if(!isSuccessful) {
            System.out.println();
            outputMessageErrorLayout("Process Failed!");
        }
        else {
            System.out.println();
            outputMessageLayout("Backup Successfully!");
        }
    }

    public void restoreDataToFileLayout() {
        boolean isSuccessful = restoreDataToFileProcess();
        if(!isSuccessful) {
            System.out.println();
            outputMessageErrorLayout("Restore Canceled!");
        }
        else {
            System.out.println();
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
        String ANSI_RESET = "\u001B[0m";
        String GREEN_BOLD = "\033[1;32m";

        // DIALOG
        AsciiTable dialog = new AsciiTable();
        dialog.addRule();
        dialog.addRow(message);
        dialog.addRule();

        dialog.setPaddingLeftRight(3);
        CWC_LongestLine cwc = new CWC_LongestLine();
        dialog.getRenderer().setCWC(cwc);
        dialog.setTextAlignment(TextAlignment.CENTER);
        dialog.getContext().setGrid(A8_Grids.lineDoubleBlocks());
        System.out.print(GREEN_BOLD);
        System.out.println(dialog.render());
        System.out.print(ANSI_RESET);
    }

    public void outputUpdateOptionLayout() {
        AsciiTable table = new AsciiTable();

        table.addRule();
        table.addRow("[1] - All", "[2] - Name", "[3] - Quantity", "[4] - Unit Price", "[5] - Back to Menu");
        table.addRule();
        table.getContext().setGridTheme(TA_GridThemes.FULL);
        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render(110));
    }

    public void outputTableDataLayout() {
        displayTableData(setting.rowSetup, setting.currentPage, listOfProducts);
    }

    public void outputMessageErrorLayout(String message) {
        String ANSI_RED = "\u001B[31;1m";
        String ANSI_RESET = "\u001B[0m";

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
        System.out.print(ANSI_RED);
        System.out.println(table.render());
        System.out.print(ANSI_RESET);
    }
    // END LAYOUT

    // PROCESS
    public ArrayList<Product> readDataFromFileProcess() {
        String str;
        String temp = "";

        long startTime;
        long endTime;
        long duration;

        BufferedReader bufferedReader;

        startTime = System.currentTimeMillis();

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

        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Current Time Loading : " + duration);
        return obj;
    }

    @Override
    public void saveDataToFileProcess() {
        File file = new File(FileLocation.DEFAULT_FILE_NAME);
        file.delete();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            for (int i = 0; i < listOfProducts.size(); i++) {
                bufferedWriter.append("+" + listOfProducts.get(i).ToString());
            }

            bufferedWriter.close();

            outputMessageLayout("Save Data Successfully!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean backupDataToFileProcess() {
        FileInputStream inputStream;
        FileOutputStream outputStream;

        try {
            File currentCollectionFile = new File(FileLocation.DEFAULT_FILE_NAME);
            File backupCollectionFileWithLocation = new File(ConfigureSetting.getBackupFileName());

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

        List<String> listFiles = null;
        FileInputStream inputStream;
        FileOutputStream outputStream;

        try {
            try (Stream<Path> walk = Files.walk(Paths.get(FileLocation.BACKUP_FILE_LOCATION))) {

                listFiles = walk.filter(Files::isRegularFile)
                        .map(x -> x.toString()).collect(Collectors.toList());

                System.out.println("==================== PLEASE CHOOSE A BACKUP FILE ====================");
                for (String listOfFile : listFiles){
                    System.out.println(numberOfFile+")"+listOfFile);
                    numberOfFile++;
                }

                if(listFiles.isEmpty()) {
                    return false;
                }

            }
            catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println();

            int indexOfFile = TextFieldConsole.readIntegerType("Choose File for Backup : ");

            if(indexOfFile<0 || indexOfFile > listFiles.size()) {
                return false;
            }

            fileToBackup = listFiles.get(indexOfFile - 1);

            File infile = new File(fileToBackup);
            File outfile = new File(FileLocation.DEFAULT_FILE_NAME);

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

            listOfProducts = readDataFromFileProcess();
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void moveToFirstProcess(int rowSetup, ArrayList<Product> products) {
        displayTableData(rowSetup, 1, products);
        setting.currentPage = 1;
    }

    @Override
    public void moveToLastPageProcess(int rowSetup, ArrayList<Product> products) {
        int lastPage = products.size() / rowSetup;
        int temp = products.size() % rowSetup;

        if (temp != 0) {
            lastPage++;
        }

        setting.currentPage = lastPage;
        displayTableData(rowSetup,setting.currentPage, products);
    }

    @Override
    public void moveToPreviousPageProcess(int rowSetup, ArrayList<Product> products) {
        int lastPage = products.size() / rowSetup;
        int temp = products.size() % rowSetup;

        if (temp != 0) {
            lastPage++;
        }

        setting.currentPage--;

        if (setting.currentPage == 0) {
            setting.currentPage = lastPage;
        }

        displayTableData(rowSetup, setting.currentPage, products);
    }

    @Override
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

    @Override
    public void setRowProcess() {
        int temp = TextFieldConsole.readIntegerType("Enter Row for Display : ");

        if(temp >= 1 && temp <= 20) {
            setting.rowSetup = temp;
            ConfigureSetting.writeToConfigureFile(setting);

            System.out.println();
            outputMessageLayout("SET " + temp + " ROWS PER PAGE");
        }
        else {
            System.out.println();
            outputMessageErrorLayout("Row Out of Bound!");
        }
    }

    @Override
    public void gotoDataProcess(int rowSetup, ArrayList<Product> products) {
        int lastPage = products.size() / rowSetup;
        int temp = TextFieldConsole.readIntegerType("Go to Page : ");

        if(temp >= 1 && temp <= lastPage) {
            setting.currentPage = temp;
            displayTableData(setting.rowSetup, setting.currentPage, products);
        }
        else {
            System.out.println();
            outputMessageErrorLayout("Page Out of Bound!");
        }
    }

    @Override
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

    @Override
    public void displayTableData(int rowSetup, int viewPage, ArrayList<Product> products) {
        if (rowSetup <= 0 || viewPage <= 0) {
            // outputMessageErrorLayout("Input Value Less Than 0!");
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
            // outputMessageErrorLayout("View Page Bigger Than Total Page!");
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

        pagination.addRule();
        pagination.addRow("Page : " + viewPage + " of " + lastPage, " Total Record : " + products.size());
        pagination.addRule();

        pagination.setTextAlignment(de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment.CENTER);
        pagination.getContext().setGrid(U8_Grids.borderDoubleLight());
        pagination.getContext().setGridTheme(TA_GridThemes.OUTSIDE);

        System.out.println(table.render(100));
        System.out.println(pagination.render(100));
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

    public boolean updateProductData(Product product, HashMap<Integer, Product> hashMap) {
        hashMap.put(product.getProductID(), product);
        return true;
    }
    // END PROCESS

    public void writeExampleRecords(){
        long startTime;
        long endTime;
        long duration;

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileLocation.DEFAULT_FILE_NAME));

            startTime = System.currentTimeMillis();
            for (int i = 1; i <= 10000; i++) {
                bufferedWriter.append("+").append((new Product(i, "ca", 12, 12, "22")).ToString());
                setting.currentID++;
            }
            endTime = System.currentTimeMillis();

            duration = endTime - startTime;
            System.out.println(duration);

            bufferedWriter.close();

            ConfigureSetting.writeToConfigureFile(setting);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean toUpdateOrNot(Product product, HashMap<Integer, Product> hashMap) {
        char innerChoice;
        do {
            innerChoice = TextFieldConsole.readCharType("Are you sure that you want to update this record? [Y|y] or [N|n] : ");
            switch (innerChoice) {
                case 'Y':
                case 'y':
                    return updateProductData(product, hashMap);

                case 'N':
                case 'n':
                    return false;

                default:
                    System.out.println();
                    outputMessageErrorLayout("Invalid Input!");
                    break;
            }
        }
        while(true);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
