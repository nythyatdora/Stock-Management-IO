class BaseCode implements DisplayLayout, CoreProcess {

    public BaseCode() {

    }

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

    public void outputWelcomeLayout() {
        // OUTPUT WELCOME
    }

    public void outputLogoLayout() {
        // OUTPUT LOGO
        // TEAM LOGO
    }

    public void outputLoadingLayout() {
        // OUTPUT LOADING SCREEN
    }

    public void outputMainLayout() {
        // OUTPUT MAIN TABLE
    }

    public void inputCommandLayout() {
        // GET USER INPUT
    }

    public void outputHelpLayout() {
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

    public void writeDataLayout() {
        // INPUT PRODUCT ID
        // INPUT PRODUCT NAME
        // INPUT PRODUCT PRICE
        // INPUT PRODUCT QUANTITY
        // INPUT IMPORT DATE (IMPLICITLY)

        // OUTPUT INPUTED PRODUCT INFORMATION

        // TO SAVE OR NOT

        // OUTPUT MESSAGE SUCCESSFULLY
    }

    public void readDataLayout() {
        // READ BY ID
        // SEARCH DATA BY ID
        // OUTPUT SCREEN AT ID
    }

    public void updataDataLayout() {
        // UPDATE BY ID
        // OUTPUT PRODUCT INFORMATION
        // OUTPUT OPTIONS
        // SELECT OPTIONS
        // INPUT OPTIONS
        // OUTPUT FINAL INFORMATION
        // TO SAVE OR NOT
        // OUTPUT MESSAGE
    }

    public void deleteDataLayout() {
        // DELETE BY ID
        // OUTPUT PRODUCT INFORMATION OR MESSAGE
        // TO DELETE OR NOT
        // OUTPUT MESSAGE
    }

    public void searchDataLayout() {
        // SEARCH BY NAME (REGEX EDITION)
        // OUTPUT SEARCH RESULT COUNT OR MESSAGE
        // DISPLAY TABLE
        // DISPLAY PAGE NUMBER
        // TOTAL RECORD
    }

    public void gotoDataScreen() {
        // INPUT PAGE
        // DISPLAY TABLE
        // AT SPECIFIC PAGE
    }

    public void setRowScreen() {
        // INPUT SET ROW (HOW MANY ROW TO DISPLAY)
        // OUTPUT MESSAGE
    }
}
