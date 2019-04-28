package TeamImplementation.Pengsea;

import de.vandermeer.asciitable.AsciiTable;

public class DisplayLayout implements PengseaTask {
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
        System.out.println("Please Input Command : ");
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
}
