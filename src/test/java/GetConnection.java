import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.u8.U8_Grids;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


 /*class use for testing and get connection from Database*/
public class GetConnection {

	private static final String url = "jdbc:mysql://127.0.0.1:3306/dbproduct";
	private static final String user = "root";
	private static final String password = "linuxconfig.org";

	public static Connection getConnection() {
		Connection connection;
		try {
			connection = DriverManager.getConnection(url, user, password);

		} catch (SQLException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		}
		return connection;
	}

	public static void main(String[] args) {
		Connection connection = GetConnection.getConnection();
		GetConnection getConnection = new GetConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from temp_table");
			if (resultSet.next()) {

				System.out.println("Do you want to recovery");
				//getConnection.saveToDB();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		System.out.println("backup");
		//getConnection.backupDataToFileProcess();
		System.out.println("restore");
		//getConnection.restoreDataToDatabaseProcess();
		// getConnection.reStore();
		//	getConnection.updateDescriptionAndAuthor(connection,13);
		//	getConnection.insertStudent(connection);
		//getConnection.writeExampleRecords();
		//	System.out.println(getConnection.getProduct(10));
		//	getConnection.saveToDB();
	}


	public boolean restoreDataToDatabaseProcess() {
		int numberOfFile = 1;
		String fileToBackup;

		List<String> result = null;

		try {
			System.out.println("==================== PLEASE CHOOSE A BACKUP FILE ====================");
			try (Stream<Path> walk = Files.walk(Paths.get(FileLocation.BACKUP_FILE_LOCATION))) {

				result = walk.filter(Files::isRegularFile)
						.map(x -> x.toString()).collect(Collectors.toList());

				for (String listOfFile : result) {
					System.out.println(numberOfFile + ")" + listOfFile);
					numberOfFile++;
				}
			} catch (IOException e) {
				e.printStackTrace();
				return false;

			}

			int indexOfFile = TextFieldConsole.readIntegerType("Choose File for Backup : ");

			if (indexOfFile<0||indexOfFile>result.size()) {return false;}


			fileToBackup = result.get(indexOfFile - 1);


			File infile = new File(fileToBackup);


			Statement reMoveTemp = GetConnection.getConnection().createStatement();
			reMoveTemp.execute("DELETE FROM tbproduct");
			Statement statement = GetConnection.getConnection().createStatement();
			try (BufferedReader buffer = new BufferedReader(new FileReader(infile))
			) {
 				String sqlInsert;
				while ((sqlInsert = buffer.readLine()) != null) {
					// process the sqlInsert.
					statement.execute(sqlInsert);
					System.out.println(sqlInsert);
				}

			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
 		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}






	private boolean backupDataToFileProcess() {

		FileOutputStream outputStream;

		String sql = "SELECT * FROM tbproduct";

		File backupCollectionFileWithLocation = new File(ConfigureSetting.getBackupFileName());
		try {
			outputStream = new FileOutputStream(backupCollectionFileWithLocation);
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(backupCollectionFileWithLocation));

			String script = "INSERT INTO tbproduct (proID,proName,proUnitPrice,proQty,importDate)";
			String script2 = "VALUES(";
			Statement statement = GetConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String value = resultSet.getInt(1) + "," + "'" + resultSet.getString(2) + "'" + "," + resultSet.getDouble(3) + "," + resultSet.getInt(4) + "," + "'" + resultSet.getString(5) + "'";

				bufferedWriter.write(script + script2 + value + ");");
				bufferedWriter.newLine();
				System.out.println(script + script2 + value + ");");
			}

			bufferedWriter.close();


			// Closing the input/output file streams

			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public boolean insertStudent(Connection connection) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = new Date();
		Product insertProduct = new Product();
		System.out.println("======== INSERT NEW PRODUCT =========");
		System.out.println("[NEW] Product ID         : " + getLastRecord());
		String productName = TextFieldConsole.readStringType("[NEW] Product Name       : ");
		int productQuantity = TextFieldConsole.readIntegerType("[NEW] Product Quantity   : ");
		double productUnitPrice = TextFieldConsole.readDoubleType("[NEW] Product Unit-Price : ");
		String importDate = dateFormat.format(date);

		insertProduct = new Product(getLastRecord(), productName, productUnitPrice, productQuantity, importDate);

		System.out.println();
		outputProductData(insertProduct);
		System.out.println();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO temp_table VALUES ( ?,?, ?, ?,?)");
			ps.setInt(1, insertProduct.getProductID());
			ps.setString(2, insertProduct.getProductName());
			ps.setDouble(3, insertProduct.getUnitPrice());
			ps.setInt(4, insertProduct.getQuantity());
			ps.setString(5, insertProduct.getImportDate());
			int i = ps.executeUpdate();

			if (i == 1) {
				System.out.println("Success");
				connection.close();
				return true;

			} else
				throw new SQLException();


		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("error");
		}


		return false;
	}


	public int getLastRecord() {
		Connection connection = GetConnection.getConnection();
		int last = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM  tbproduct ");
			if (resultSet != null) {
				while (resultSet.next()) {
					last = resultSet.getInt("proID") + 1;
				}

				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return last;
	}


	private Product extractUserFromResultSet(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setProductID(rs.getInt("proID"));
		product.setProductName(rs.getString("proName"));
		product.setUnitPrice(rs.getDouble("proUnitPrice"));
		product.setQuantity(rs.getInt("proQty"));
		product.setImportDate(rs.getString("importDate"));
		return product;
	}

	public Product getProduct(int proID) {

		Connection connection = GetConnection.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("SELECT * FROM temp_table WHERE proID=?");
			ps.setInt(1, proID);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return extractUserFromResultSet(rs);

			} else
				System.out.println("This ID doesnt have in Database");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Not Fount");
		}


		return null;
	}


	public void writeExampleRecords() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		try {
			Statement reMoveTemp = GetConnection.getConnection().createStatement();
			reMoveTemp.execute("DELETE FROM tbproduct");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 1; i <= 100; i++) {
			insertStudent((new Product(0, "fanta2", 10, 15, dateFormat.format(date))));
		}
	}

	public boolean insertStudent(Product product) {
		Connection connection = GetConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO tbproduct VALUES ( ?,?, ?, ?,?,1)");
			ps.setInt(1, product.getProductID());
			ps.setString(2, product.getProductName());
			ps.setDouble(3, product.getUnitPrice());
			ps.setInt(4, product.getQuantity());
			ps.setString(5, product.getImportDate());
			int i = ps.executeUpdate();

			if (i == 1) {
				System.out.println(product.getImportDate());
				System.out.println("Success");
				connection.close();
				return true;

			} else
				throw new SQLException();


		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("error");
		}


		return false;
	}

	public void saveToDB() {

		String sqlCopy = "INSERT tbproduct\n" +
				"SELECT * FROM temp_table;";
		String sqlDelete = "DELETE FROM tbproduct";
		try {
			Statement reMoveStatement = GetConnection.getConnection().createStatement();
			reMoveStatement.execute(sqlDelete);
			Statement copyStatement = GetConnection.getConnection().createStatement();
			copyStatement.execute(sqlCopy);
			Statement reMoveTemp = GetConnection.getConnection().createStatement();
			reMoveTemp.execute("DELETE FROM temp_table");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void outputProductData(Product product) {
		AsciiTable table = new AsciiTable();

		table.addRule();
		table.addRow("ID", " : " + +product.getProductID());

		table.addRow("Name", " : " + product.getProductName());

		table.addRow("Unit price", " : " + product.getUnitPrice());

		table.addRow("Qty", " : " + product.getQuantity());

		table.addRow("Imported Date", " : " + product.getImportDate());
		table.addRule();

		table.setPaddingRight(3);
		table.setPaddingLeft(1);
		CWC_LongestLine cwc = new CWC_LongestLine();
		table.getRenderer().setCWC(cwc);
		table.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
		table.getContext().setGrid(U8_Grids.borderDouble());
		System.out.println(table.render());
	}


}
