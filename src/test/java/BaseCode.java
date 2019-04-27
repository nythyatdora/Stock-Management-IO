import java.util.Scanner;

public class BaseCode implements GraphicalScreen, ProcessOperation {

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
    }

    public void outputLogoScreen() {
        // OUTPUT LOGO
    }

    public void outputLoadingScreen() {
        // OUTPUT LOADING SCREEN
    }

    public void outputMainScreen() {
        // OUTPUT MAIN TABLE
    }

    public void inputCommandScreen() {
        // GET USER INPUT
    }

    public void outputHelpScreen() {
        // OUTPUT SHORTCUT
        // PROGRAM DESCRIPTION
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
        System.out.println("Set Row for N Successfully!");
    }
}