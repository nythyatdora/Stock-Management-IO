interface GraphicalScreen {
    void outputWelcomeScreen();
    void outputLogoScreen();
    void outputLoadingScreen();
    void outputMainScreen();
    void inputCommandScreen();
    void outputHelpScreen();
    
    void displayTableData();
    void writeDataScreen();
    void readDataScreen();
    void updataDataScreen();
    void deleteDataScreen();
    void searchDataScreen();
    void gotoDataScreen();
    void setRowScreen();
}

interface ProcessOperation {
    void saveDataToFile();
    void backUpDataToFile();
    void restoreDataToFile();

    void moveToFirstPage();
    void moveToLastPage();
    void moveToPreviousRow();
    void moveToNextRow();

    void shortcutCommand();

    void exitProgram();
}

class BaseCode implements GraphicalScreen, ProcessOperation {
    public void saveDataToFile() {
        // OUTPUT "DATA IS ADDING..."
        // SAVE DATA INTO FILE
        // OUTPUT MESSAGE
    }

    public void backUpDataToFile() {
        // CREATE BACKUP FILE
        // TO BACKUP OR NOT
        // OUPUT MESSAGE
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

    }

    public void inputCommandScreen() {

    }

    public void outputHelpScreen() {
        // OUTPUT SHORTCUT
        // PROGRAM DESCRIPTION
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
        // DELETE BY ID
        // OUTPUT PRODUCT INFORMATION OR MESSAGE
        // TO DELETE OR NOT
        // OUTPUT MESSAGE
    }

    public void searchDataScreen() {
        // SEARCH BY NAME (REGEX EDITION)
        // OUTPUT SEARCH RESULT COUNT OR MESSAGE
        // DISPLAY TABLE
        // DISPLAY SEARCH RESULT
        // DISPLAY PAGE NUMBER
        // TOTOAL RECORD
    }

    public void gotoDataScreen() {
        // DISPLAY TABLE
        // AT SPECIFIC PAGE
    }

    public void setRowScreen() {
        // INPUT SET ROW (HOW MANY ROW TO DISPLAY)
        // OUTPUT MESSAGE
    }
}

class Tester {

}

class ProtoGUI {
    public static void main(String[] args) {

    }
}