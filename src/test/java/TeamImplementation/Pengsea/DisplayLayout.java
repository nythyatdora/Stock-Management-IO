package TeamImplementation.Pengsea;

import de.vandermeer.asciitable.AsciiTable;

public class DisplayLayout implements PengseaTask {
    public void outputMainLayout() {
        AsciiTable ac = new AsciiTable();
        ac.addRule();
        ac.addRow("*)Display", "W)rite", "R)ead", "U)pdate", "D)elete", "F)irst", "P)revious", "N)ext");
        ac.addRule();
        ac.addRow("L)ast", "G)o to", "S)et row", "Sa)ve", "B)ack up", "Re)store", "H)elp", "E)xit");
        ac.addRule();
        System.out.println(ac.render());
    }

    public void inputCommandLayout() {
        System.out.println("Please Input Command : ");
    }

    public void outputHelpLayout() {
        String[] st = {
                "1.             Press\t*:Display all record of product.",
                "2.             Press\tW: Add new Class.Product",
                "               Press\tw ->#proname-unitprice-qty: shortcut for add new product",
                "3.             Press\tr: Read contents",
                "               Press\tr#proId: shortcut for read product by Id",
                "4.     Press\tu : Update Data",
                "5.     Press\td: Delete Data",
                "       Press\td#proId : Shortcut for delete product by Id",
                "6.     Press\tf : Display first page",
                "7.     Press\tp : Display Previous page",
                "8.     Press\tn: Display Next Page",
                "9.     Press\tl : Display Last Page",
                "10.    Press\ts : Search Class.Product by name",
                "11.    Press\tsa : To save record to file",
                "12.    Press\tba : Backup data",
                "13.    Press\tre : To restore data",
                "14.    Press\th : To Help",
        };

        AsciiTable ac = new AsciiTable();
        ac.addRule();
        for (String te : st) {
            ac.addRow("" + te).setPaddingLeft(3);
        }
        ac.addRule();
        System.out.println(ac.render());
    }

    public static void main(String[] args) {
        DisplayLayout displayLayout=new DisplayLayout();
        displayLayout.outputHelpLayout();

    }
}
