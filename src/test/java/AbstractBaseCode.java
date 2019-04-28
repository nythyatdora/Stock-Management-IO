import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Scanner;

public abstract class AbstractBaseCode implements DisplayLayout, CoreProcess {

    public void regexSearch() {

    }

    public void saveDataToFile() {

    }

    public void backUpDataToFile() {

    }

    public void restoreDataToFile() {

    }

    public void moveToFirstPage() {

    }

    public void moveToLastPage() {

    }

    public void moveToPreviousRow() {

    }

    public void moveToNextRow() {

    }

    public void shortcutCommand() {

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
        AsciiTable ac = new AsciiTable();
        ac.addRule();
        ac.addRow("*)Display", "W)rite", "R)ead", "U)pdate", "D)elete", "F)irst", "P)rivious", "N)ext");
        ac.addRule();
        ac.addRow("L)ast", "G)o to", "S)et row", "Sa)ve", "B)ack up", "Re)store", "H)elp", "E)xit");
        ac.addRule();
        System.out.println(ac.render());
    }

    public void inputCommandLayout() {
        Inputfield inputField = new Inputfield();
        char cmd;
        cmd = inputField.readCharType("Command : ");
    }

    public void outputProductData() {
        Scanner sc = new Scanner(System.in);
        AsciiTable at = new AsciiTable();
        AsciiTable msg= new AsciiTable();
        at.addRule();
        at.addRow("ID",":"+"10000000");
        at.addRule();
        at.addRow("Name",":"+"Coca Cola");
        at.addRule();
        at.addRow( "Unit price",":"+"2.0");
        at.addRule();
        at.addRow("Qty",":"+90);
        at.addRule();
        at.addRow("Imported Date",":"+"24-04-2019");
        at.addRule();
        at.setPaddingRight(1);
        at.setPaddingLeft(1);
        at.setTextAlignment(TextAlignment.LEFT);
        at.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        at.getContext().setGrid(U8_Grids.borderDoubleLight());

        System.out.println(at.render(50));

        System.out.print("Are you sure want to update this record? [Y/y] or [N/n]");
        sc.next();

        msg.addRule();
        msg.addRow("Product was update");
        msg.addRule();
        msg.setTextAlignment(TextAlignment.CENTER);
        msg.getContext().setGridTheme(TA_GridThemes.TOPBOTTOM);
        msg.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        System.out.println(msg.render(50));
    }

    public void displayTableData() {
        AsciiTable row = new AsciiTable();
        AsciiTable page = new AsciiTable();
        row.addRule();
        row.addRow("ID", "Title", "Author", "Date");
        row.addRule();
        row.addRow("5000", "java", "john", "12323");
        row.addRule();
        row.addRow("5000", "java", "john", "12323");
        row.addRule();
        row.addRow("5000", "java", "john", "12323");
        row.addRule();
        row.addRow("5000", "java", "john", "12323");
        row.addRule();
        row.setTextAlignment(TextAlignment.CENTER);
        row.getContext().setGrid(U8_Grids.borderDouble());
        System.out.println(row.render());

        page.addRule();
        page.addRow("Page:1/3000000 ", " \t\t   ", " Total Record:300000");
        page.addRule();

        page.setTextAlignment(TextAlignment.CENTER);
        page.getContext().setGrid(U8_Grids.borderDoubleLight());

        page.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        System.out.println(page.render());
    }

    public void writeDataLayout() {

    }

    public void readDataLayout() {

    }

    public void searchDataLayout() {
        Inputfield inputfield = new Inputfield();
        String productName;
        boolean isFound;
        int searchResult;

        productName = inputfield.readStringType("Input the Name of Product : ");
        isFound = findProductByName();

        switch (isFound) {
            case true:
                searchResult = displayProductByName();
                break;

            case false:
                outputMessage("");
                break;
        }

        System.out.println("Product Found for [" + productName + "] : " + searchResult);
    }

    public void deleteDataLayout() {
        Inputfield inputfield = new Inputfield();
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
        String[] st = {
                "1.Press *:Display all record of product.",
                "2.Press W: Add new Product",
                "Press w ->#proname-unitprice-qty: sortcut for add new product",
                "3. Press r: Read contents",
                "Press r#productId: shortCUt for read product by Id",
                "4. Press u : Update Data",
                "5. Press d: Delete Data",
                "   Press d#proId : shortcut for delete product by id",
                "6. Press f : Display first page",
                "7. Press p : Display Previous page",
                "8. Press n: Display Next Page",
                "9. Press l : Display Last Page",
                "10. Press s : Search Product by name",
                "11. Press sa : To save record to file",
                "12. Press ba : Backup data",
                "13. Press re : To restore data",
                "14. Press h : To Help",
        };

        AsciiTable ac = new AsciiTable();
        ac.addRule();
        for (String te : st) {
            ac.addRow("" + te).setPaddingLeft(3);
        }
        ac.addRule();
        System.out.println(ac.render());
    }

    public void outputInvalidInputLayout() {

    }

    public void gotoDataLayout() {
        System.out.println("Go to Page : ");
    }

    public void setRowLayout() {
        System.out.println("Please Enter Row for Display : ")
    }
}
