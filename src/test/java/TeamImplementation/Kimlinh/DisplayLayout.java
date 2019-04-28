package TeamImplementation.Kimlinh;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Scanner;

public class DisplayLayout implements KimlinhTask {
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
        msg.addRow("Class.Product was update");
        msg.addRule();
        msg.setTextAlignment(TextAlignment.CENTER);
        msg.getContext().setGridTheme(TA_GridThemes.TOPBOTTOM);
        msg.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        System.out.println(msg.render(50));
    }

    public void updataDataLayout() {

    }
}
