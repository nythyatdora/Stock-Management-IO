import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Scanner;

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
		page.addRow("Page:1/3000000 ", " \t\t", " Total Record:300000");

		page.addRule();

		page.setTextAlignment(TextAlignment.CENTER);
		page.getContext().setGrid(U8_Grids.borderDoubleLight());

		page.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
		System.out.println(page.render());
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
		BaseCode bs = new BaseCode();
		bs.displayTableData();
		bs.writeDataScreen();
	}
}