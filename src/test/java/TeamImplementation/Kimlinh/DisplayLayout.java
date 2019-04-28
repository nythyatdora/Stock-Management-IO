package TeamImplementation.Kimlinh;

import Class.Product;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.HashMap;
import java.util.Map;
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
		AsciiTable msg = new AsciiTable();
		at.addRule();
		at.addRow("ID", ":" + "10000000");
		at.addRule();
		at.addRow("Name", ":" + "Coca Cola");
		at.addRule();
		at.addRow("Unit price", ":" + "2.0");
		at.addRule();
		at.addRow("Qty", ":" + 90);
		at.addRule();
		at.addRow("Imported Date", ":" + "24-04-2019");
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

	public void updataDataLayout(int i, HashMap hashMap) {

		if (hashMap.get(i) == null) {
			System.out.println("Cannot not found");
			return;
		} else {


			hashMap.put(i, insertByIndex(i, hashMap));
		}
	}

	public static void showDataTable(Product product) {
		Scanner sc = new Scanner(System.in);
		AsciiTable at = new AsciiTable();
		AsciiTable msg = new AsciiTable();
		at.addRule();
		at.addRow("ID", ":" + product.getProductID());
		at.addRule();
		at.addRow("Name", ":" + product.getProductName());
		at.addRule();
		at.addRow("Unit price", ":" + product.getUnitPrice());
		at.addRule();
		at.addRow("Qty", ":" + product.getQuantity());
		at.addRule();
		at.addRow("Imported Date", ":" + product.getImportDate());
		at.addRule();
		at.setPaddingRight(1);
		at.setPaddingLeft(1);
		at.setTextAlignment(TextAlignment.LEFT);
		at.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
		at.getContext().setGrid(U8_Grids.borderDoubleLight());

		System.out.println(at.render(50));
	}

	public static void showMessage(String msg) {
		AsciiTable at = new AsciiTable();
		at.addRule();
		at.addRow(msg);
		at.addRule();
		at.setTextAlignment(TextAlignment.CENTER);
		at.getContext().setGridTheme(TA_GridThemes.TOPBOTTOM);
		at.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
		System.out.println(at.render(50));
	}


	private static Product insertByIndex(int i, HashMap<Integer, Product> map) {
		Product product = map.get(i);
		;

		AsciiTable menu = new AsciiTable();
		Scanner sc = new Scanner(System.in);
		int check;
		boolean b = true, b1 = true;
		String pName;
		int qty;
		double unitPrice;

		//Output Table
		showDataTable(product);

		//Output menu
		menu.addRule();
		menu.addRow("1.All", "2.Name", "3.Quantity", "4.Unit Price", "5.Back");
		menu.addRule();
		menu.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
		menu.setTextAlignment(TextAlignment.CENTER);
		System.out.println(menu.render());

		do {

			try {

				System.out.print("Option(1-5):");
				check = sc.nextInt();
				switch (check) {

					case 1:

						System.out.print("Product Name:");
						pName = sc.next();

						System.out.print("Product Quantity:");
						qty = sc.nextInt();

						System.out.print("Product Unit Price:");
						unitPrice = sc.nextDouble();


						System.out.println("Are you sure want to update this record? [Y/y] or [N/n]");
						while (b1) {
							char ch = sc.next().charAt(0);
							if (ch == 'y' || ch == 'Y') {
								product.setProductName(pName);
								product.setQuantity(qty);
								product.setUnitPrice(unitPrice);
								showMessage("Product was update");
								break;
							}
							if (ch == 'n' || ch == 'N') {
								showMessage("Has been cancel");
								return product;
							} else
								System.out.println("Please input [Y/y] or [N/n]");
						}
						break;
					case 2:
						System.out.print("Product Name:");
						pName = sc.next();
						showDataTable(new Product(product.getProductID(), pName, product.getUnitPrice(), product.getQuantity(), product.getImportDate()));
						System.out.println("Are you sure want to update this record? [Y/y] or [N/n]");
						while (b1) {
							char ch = sc.next().charAt(0);
							if (ch == 'y' || ch == 'Y') {
								product.setProductName(pName);
								showMessage("Product was update");
								break;
							}
							if (ch == 'n' || ch == 'N') {
								showMessage("Has been cancel");
								return product;
							} else
								System.out.println("Please input [Y/y] or [N/n]");
						}
						break;
					case 3:
						System.out.print("Product Quantity:");
						qty = sc.nextInt();
						showDataTable(new Product(product.getProductID(), product.getProductName(), product.getUnitPrice(), qty, product.getImportDate()));
						System.out.println("Are you sure want to update this record? [Y/y] or [N/n]");
						while (b1) {
							char ch = sc.next().charAt(0);
							if (ch == 'y' || ch == 'Y') {

								product.setQuantity(qty);
								showMessage("Product was update");
								break;
							}
							if (ch == 'n' || ch == 'N') {
								showMessage("Has been cancel");
								return product;
							} else
								System.out.println("Please input [Y/y] or [N/n]");
						}
						break;
					case 4:
						System.out.print("Product Unit Price:");
						unitPrice = sc.nextDouble();
						showDataTable(new Product(product.getProductID(), product.getProductName(), unitPrice, product.getQuantity(), product.getImportDate()));
						System.out.println("Are you sure want to update this record? [Y/y] or [N/n]");
						while (b1) {
							char ch = sc.next().charAt(0);
							if (ch == 'y' || ch == 'Y') {

								product.setUnitPrice(unitPrice);
								showMessage("Product was update");
								break;
							}
							if (ch == 'n' || ch == 'N') {
								showMessage("Has been cancel");
								return product;
							} else
								System.out.println("Please input [Y/y] or [N/n]");
						}
						break;
					case 5:
						b = false;
						break;
					default:
						System.out.println("Error... Please Input again");
						break;


				}
			} catch (Exception ex) {
				System.out.println("Please Input again....");
				sc.next();
				continue;

			}
		} while (b);

		return product;
	}

	public static void main(String[] args) {
		DisplayLayout displayLayout = new DisplayLayout();

		HashMap<Integer, Product> hashMap = new HashMap<Integer, Product>();
		for (int i = 1; i <= 2000; i++) {
			hashMap.put(i, new Product(i, "Angkor", 20.0, 30, "20/30/12"));
		}


		displayLayout.updataDataLayout(2000, hashMap);
		for (Map.Entry em : hashMap.entrySet())
			System.out.println(em.getValue());
	}
}
