import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.a8.A8_Grids;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

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

    AbstractBaseCode() {
        setting = new ConfigureSetting();
//         READ DATA FROM setting.bak
//         IF FILE NOT EXIST
//              CREATE DEFAULT SETTING
//         ELSE
//              READ FROM FILE TO this.setting
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
        FileInputStream instream = null;
        FileOutputStream outstream = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM,dd-mm:ss");
        Date date = new Date();
        String filename = dateFormat.format(date) + ".txt";
        System.out.println(filename);
        try {
            File infile = new File("mytext1.txt");
            File outfile = new File("src/Backup/" + filename);

            instream = new FileInputStream(infile);
            outstream = new FileOutputStream(outfile);

            byte[] buffer = new byte[1024];

            int length;
            /*copying the contents from input stream to
             * output stream using read and write methods
             */
            while ((length = instream.read(buffer)) > 0) {
                outstream.write(buffer, 0, length);
            }

            //Closing the input/output file streams
            instream.close();
            outstream.close();

            System.out.println("Backup successfully!!");

        } catch (Exception ioe) {
            ioe.printStackTrace();
        }


    }

    public void restoreDataToFile() {
        FileInputStream instream = null;
        FileOutputStream outstream = null;
        List<String> result=null;
        Scanner scanner = new Scanner(System.in);
        String nameOfFile;
        int numberOfFile=1;
        try {

            try (Stream<Path> walk = Files.walk(Paths.get("src/Backup"))) {

                result = walk.filter(Files::isRegularFile)
                        .map(x -> x.toString()).collect(Collectors.toList());

                for (String listOfFile : result){
                    System.out.println(numberOfFile+")"+listOfFile);
                    numberOfFile++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //validate here....
            System.out.print("Which files you want to restore...:");
            int indexOfFile = scanner.nextInt();

            nameOfFile = result.get(indexOfFile-1);

            File infile = new File(nameOfFile);
            File outfile = new File("mytext1.txt");

            instream = new FileInputStream(infile);
            outstream = new FileOutputStream(outfile);

            byte[] buffer = new byte[1024];

            int length;
            /*copying the contents from input stream to
             * output stream using read and write methods
             */
            while ((length = instream.read(buffer)) > 0) {
                outstream.write(buffer, 0, length);
            }
            //Closing the input/output file streams
            instream.close();
            outstream.close();
            System.out.println("Restore successfully!!");

        } catch (Exception ioe) {
            ioe.printStackTrace();
        }


    }

    public void moveToFirstPage(int rowSetup, ArrayList<Product> products) {
        displayTableData(rowSetup, 1, products);
        setting.rowSetup = 1;
    }

    public void moveToLastPage(int rowSetup, ArrayList<Product> products) {
        int lastPage = products.size() / rowSetup;
        int temp = products.size() % rowSetup;

        if (temp != 0) {
            lastPage++;
        }

        setting.rowSetup = lastPage;
        displayTableData(rowSetup, setting.rowSetup, products);
    }

    public void moveToPreviousPage(int rowSetup, ArrayList<Product> products) {
        int lastPage = products.size() / rowSetup;
        int temp = products.size() % rowSetup;
        if (temp != 0) {
            lastPage++;
        }
        if (setting.rowSetup == 0) {
            setting.rowSetup = lastPage;
        }
        displayTableData(rowSetup, setting.rowSetup--, products);
    }

    public void moveToNextPage(int rowSetup, ArrayList<Product> products) {
        int lastPage = products.size() / rowSetup;
        int temp = products.size() % rowSetup;
        if (temp != 0) {
            lastPage++;
        }

        if (setting.rowSetup == lastPage) {
            setting.rowSetup = 0;
        }
        displayTableData(rowSetup, setting.rowSetup++, products);
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

    public void displayTableData(int startRow, int viewPage, ArrayList<Product> products) {
        if (startRow <= 0 || viewPage <= 0) {
            // System.out.println("Can not input less than 0");
            return;
        }
        AsciiTable table = new AsciiTable();
        AsciiTable pagination = new AsciiTable();

        long lastPage = products.size() / startRow;
        long temp = products.size() % startRow;

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
            for (int i = (viewPage - 1) * startRow; i < products.size(); i++) {
                Product product = products.get(i);

                table.addRow(product.getProductID(), product.getProductName(), product.getUnitPrice(),
                        product.getQuantity(), product.getImportDate());
                table.addRule();
            }
        }
        else {
            int t = viewPage * startRow;
            for (int j = t - startRow; j < t; j++) {
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

    public void writeDataLayout() {
        // ArrayList

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        HashMap<Integer, Product> hashMap;

        char choice;
        int id = hashMap.size() + 1; // wrong logic
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
        HashMap<Integer, Product> hashMap;

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

        HashMap<Integer, Product> hashMap;

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

        HashMap<Integer, Product> hashMap;

        productID = TextFieldConsole.readIntegerType("Input the ID of Product to Delete : ");
        isFound = findProductByID(productID, hashMap);

        if(!isFound) {
            outputMessageLayout("Product Not Found!");
        }
        else {
            displayProductByID(productID, hashMap);

            System.out.println("Product Found for [" + productID + "] : " + searchResult);

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

        HashMap<Integer, Product> hashMap;

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
            hashMap.put(searchProduct.getProductID(), searchProduct);
            outputMessageLayout("Product was updated!");
        }
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

    public void outputMessageLayout(String message) {
        // DIALOG
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow(message);
        at.addRule();

        at.setPaddingLeftRight(3);
        CWC_LongestLine cwc = new CWC_LongestLine(); // for auto resize
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

    public void outputInvalidInputLayout(String message) {
        // DIALOG
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow(message);
        table.addRule();

        table.setPaddingLeftRight(3);
        CWC_LongestLine cwc = new CWC_LongestLine(); //for auto resize
        table.getRenderer().setCWC(cwc);
        table.setTextAlignment(TextAlignment.CENTER);
        table.getContext().setGridTheme(TA_GridThemes.HORIZONTAL);
        System.out.println(table.render());
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
}
