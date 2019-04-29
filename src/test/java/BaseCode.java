import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BaseCode extends AbstractBaseCode {
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

    public void outputInvalidInputLayout() {
        // OUTPUT INVALID LAYOUT
    }

    public void outputMainLayout() {
        // OUTPUT MAIN TABLE
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

    public void readDataLayout() {
        // READ BY ID
        // SEARCH DATA BY ID
        // OUTPUT SCREEN AT ID
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

    public void gotoDataLayout() {
        // INPUT PAGE
        // DISPLAY TABLE
        // AT SPECIFIC PAGE
    }

    public void setRowLayout() {
        // INPUT SET ROW (HOW MANY ROW TO DISPLAY)
        // OUTPUT MESSAGE
    }

    public boolean findProductByName() {
        // FIND PRODUCT BY ID
        // RETURN TRUE IF FOUND
        return false;
    }

    public int displayProductByName() {
        // FIND PRODUCT BY ID
        // RETURN TRUE IF FOUND
        return 0;
    }

    public boolean findProductByID(int productID) {
        return false;
    }

    public int displayProductByID(int productID) {
        return 0;
    }

    public boolean deleteProductByID(int productID) {
        return false;
    }

    

}
