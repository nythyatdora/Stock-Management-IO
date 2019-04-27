import de.vandermeer.asciitable.AsciiTable;

import java.util.Scanner;

class BaseCode implements GraphicalScreen, ProcessOperation {
    public void saveDataToFile() {
        // OUTPUT "DATA IS ADDING..."
        // SAVE DATA INTO FILE
        // OUTPUT MESSAGE
    }

    public void backUpDataToFile() {
        // CREATE BACKUP FILE
        // TO BACKUP OR NOT
        // OUTPUT MESSAGE
    }

    public void restoreDataToFile() {
        // OUTPUT BACKUP FILE
        // SELECT FILE
        // TO RESTORE OR NOT
        // OUTPUT MESSAGE
    }

    public void moveToFirstPage() {
        // DISPLAY TABLE
        // WITH SET ROWS AT FIRST PAGE
        // SHOW PAGE NUMBER
    }

    public void moveToLastPage() {
        // DISPLAY TABLE
        // WITH SET ROWS AT LAST PAGE
        // SHOW PAGE NUMBER
    }

    public void moveToPreviousRow() {
        // DISPLAY TABLE
        // MOVE -1 PAGE
        // SHOW PAGE NUMBER
    }

    public void moveToNextRow() {
        // DISPLAY TABLE
        // MOVE +1 PAGE
        // SHOW PAGE NUMBER
    }

    public void shortcutCommand() {
        // READ_PRODUCT_ID
        // UPDATE_ALL
        // UPDATE_...
        //
    }

    public void exitProgram() {
        // TO SAVE WRITE/UPDATE/DELETE RECORD OR NOT
        // OUTPUT MESSAGE
        // WRITE DATA INTO LOG FILE
        // EXIT PROGRAM
    }

    public void outputWelcomeScreen() {
        // OUTPUT WELCOME
        String[] stockText = {
                "                      _____  _                _      __  __                                                            _    ",
                "                     / ____|| |              | |    |  \\/  |                                                          | |   ",
                "                    | (___  | |_  ___    ___ | | __ | \\  / |  __ _  _ __    __ _   __ _   ___  _ __ ___    ___  _ __  | |_  ",
                "                     \\___ \\ | __|/ _ \\  / __|| |/ / | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '_ ` _ \\  / _ \\| '_ \\ | __| ",
                "                     ____) || |_| (_) || (__ |   <  | |  | || (_| || | | || (_| || (_| ||  __/| | | | | ||  __/| | | || |_  ",
                "                    |_____/  \\__|\\___/  \\___||_|\\_\\ |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_| |_| |_| \\___||_| |_| \\__| ",
                "                                                                                   __/ |                                    ",
                "                                                                                  |___/"};

        for (String text : stockText) {
            System.out.println(text);
        }
    }


    public void outputLogoScreen() {
        // OUTPUT LOGO
        String[] classBTBText = {
                "                                    ____     ___                                       ____     ______  ____  ",
                "                                   /\\  _`\\  /\\_ \\                                     /\\  _`\\  /\\__  _\\/\\  _`\\",
                "                                   \\ \\ \\/\\_\\\\//\\ \\       __       ____    ____   __   \\ \\ \\L\\ \\\\/_/\\ \\/\\ \\ \\L\\ \\",
                "                                    \\ \\ \\/_/_ \\ \\ \\    /'__`\\    /',__\\  /',__\\ /\\_\\   \\ \\  _ <'  \\ \\ \\ \\ \\  _ <'",
                "                                     \\ \\ \\L\\ \\ \\_\\ \\_ /\\ \\L\\.\\_ /\\__, `\\/\\__, `\\\\/_/_   \\ \\ \\L\\ \\  \\ \\ \\ \\ \\ \\L\\ \\",
                "                                      \\ \\____/ /\\____\\\\ \\__/.\\_\\\\/\\____/\\/\\____/  /\\_\\   \\ \\____/   \\ \\_\\ \\ \\____/",
                "                                       \\/___/  \\/____/ \\/__/\\/_/ \\/___/  \\/___/   \\/_/    \\/___/     \\/_/  \\/___/ "};

        for (String text : classBTBText) {
            System.out.println(text);
        }

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

        for (String text : groupBTBText) {
            System.out.println(text);
        }
    }

    public void outputLoadingScreen() {
        // OUTPUT LOADING SCREEN
        OutputLoadingOnScreen outputLoadingOnScreen = new OutputLoadingOnScreen();
        Thread thread = new Thread(outputLoadingOnScreen);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Current Time Loading:");
    }

    public void outputMainScreen() {
        // OUTPUT MAIN TABLE
        AsciiTable ac = new AsciiTable();
        ac.addRule();
        ac.addRow("*)Display", "W)rite", "R)ead", "U)pdate", "D)elete", "F)irst", "P)rivious", "N)ext");
        ac.addRule();
        ac.addRow("L)ast", "G)o to", "S)et row", "Sa)ve", "B)ack up", "Re)store", "H)elp", "E)xit");
        ac.addRule();
        System.out.println(ac.render());
    }

    public void inputCommandScreen() {
        // GET USER INPUT
        System.out.println("Please Input Command : ");
    }

    public void outputHelpScreen() {
        // OUTPUT SHORTCUT
        // PROGRAM DESCRIPTION
        String[] st = new String[17];
        st[0] = "1.Press *:Display all record of product.";
        st[1] = "2.Press W: Add new Product";
        st[2] = "Press w ->#proname-unitprice-qty: sortcut for add new product";
        st[3] = "3. Press r: Read contents";
        st[4] = "Press r#productId: shortCUt for read product by Id";
        st[5] = "4. Press u : Update Data";
        st[6] = "5. Press d: Delete Data";
        st[7] = "   Press d#proId : shortcut for delete product by id";
        st[8] = "6. Press f : Display first page";
        st[9] = "7. Press p : Display Previous page";
        st[10] = "8. Press n: Display Next Page";
        st[11] = "9. Press l : Display Last Page";
        st[12] = "10. Press s : Search Product by name";
        st[13] = "11. Press sa : To save record to file";
        st[14] = "12. Press ba : Backup data";
        st[15] = "13. Press re : To restore data";
        st[16] = "14. Press h : To Help";


        AsciiTable ac = new AsciiTable();

        ac.addRule();
        for (String te : st) {
            ac.addRow("" + te).setPaddingLeft(3);
        }
        ac.addRule();
        System.out.println(ac.render());
    }

    public void outputProductData() {
        // DISPLAY PRODUCT INFORMATION
    }

    public void displayTableData() {
        // DRAW TABLE
        // DISPLAY ROW FROM START_ROW TO LENGTH_ROW
        // CURRENT PAGE
    }

    public void writeDataScreen() {
        // INPUT PRODUCT ID
        // INPUT PRODUCT NAME
        // INPUT PRODUCT PRICE
        // INPUT PRODUCT QUANTITY
        // INPUT IMPORT DATE (IMPLICITLY)

        // OUTPUT INPUTED PRODUCT INFORMATION

        // TO SAVE OR NOT

        // OUTPUT MESSAGE SUCCESSFULLY
    }

    public void readDataScreen() {
        // READ BY ID
        // SEARCH DATA BY ID
        // OUTPUT SCREEN AT ID
    }

    public void updataDataScreen() {
        // UPDATE BY ID
        // OUTPUT PRODUCT INFORMATION
        // OUTPUT OPTIONS
        // SELECT OPTIONS
        // INPUT OPTIONS
        // OUTPUT FINAL INFORMATION
        // TO SAVE OR NOT
        // OUTPUT MESSAGE
    }

    public void deleteDataScreen() {
        Scanner scan = new Scanner(System.in);
        // DELETE BY ID
        System.out.println("Please Input the ID of Product : ");
        int id = scan.nextInt();
        // OUTPUT PRODUCT INFORMATION OR MESSAGE
        System.out.println("Product Found for [" + id + "] : " );
        // TO DELETE OR NOT
        System.out.println("Are you sure that you want to delete this record? [Y|y] or [N|n] :");
        // OUTPUT MESSAGE
        System.out.println("Product was removed");
        scan.close();
    }

    public void searchDataScreen() {
        Scanner scan = new Scanner(System.in);
        // SEARCH BY NAME (REGEX EDITION)
        System.out.println("Please Input the Name of Product : ");
        String name = scan.nextLine();
        // OUTPUT SEARCH RESULT COUNT OR MESSAGE
        System.out.println("Product Found for [" + name + "] : " );
        // DISPLAY TABLE

        // DISPLAY PAGE NUMBER

        // TOTAL RECORD
    }

    public void gotoDataScreen() {
        // INPUT PAGE
        System.out.println("Go to Page : ");
        // DISPLAY TABLE

        // AT SPECIFIC PAGE
    }

    public void setRowScreen() {
        // INPUT SET ROW (HOW MANY ROW TO DISPLAY)
        System.out.println("Please Enter Row for Display : ");
        // OUTPUT MESSAGE
    }
}

class OutputLoadingOnScreen implements Runnable {
    public void run() {
        String a = "Please Wait, Loading.......";
        for (int i=0; i< a.length(); i++) {
            char ch = a.charAt(i);
            String st = String.valueOf(ch);
            try {
                System.out.print(st);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
