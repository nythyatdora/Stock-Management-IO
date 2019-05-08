import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Recover {

	public static ArrayList<String> statementQueryer(String sqlStatementGetDataFromStatementTable) throws SQLException {

		ArrayList<String> arrayList = new ArrayList();

		Connection connection = GetConnection.getConnection();
		ResultSet resultSet = null;

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sqlStatementGetDataFromStatementTable);
		  resultSet = preparedStatement.executeQuery();

			//<<<<< add statement to be executed ;
			while (resultSet.next()) {

				arrayList.add(resultSet.getString(2));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}



		if (arrayList.size()>0){
			arrayList.forEach((statement)->{
				try {
					//str2 = statement;

				connection.createStatement().executeUpdate(statement);


				}catch (SQLException sql){
					System.out.println("problem with sql statement update");
					sql.printStackTrace();
				}
			});

			connection.createStatement().executeUpdate("delete from Sql_table");

			resultSet.close();
			preparedStatement.close();
			connection.close();
			return arrayList;
		}else {
			//if statement from table not found
			return null;
		}

	}//endoffunction
	public static void insertion(Product product, String table) {

		Connection connection = GetConnection.getConnection();
		String mySQLStatement =
				"INSERT INTO "+table+
						" (proID,proName, proUnitPrice, proQty, importDate, status) "+
						" VALUES ("+ product.getProductID()+","+"'"+product.getProductName()+"'"+","+product.getUnitPrice()+","
						+product.getQuantity()+","+ "'"+product.getImportDate()+"'"+","+"1"+")";
		//mySQLStatement = "Insert into "+table+" (name, unitprice, stockqty, importeddate, status) values ('hahaha',2,2,'24-424-2',1) ";
		try{
			Statement statement = connection.createStatement();

			statement.execute(mySQLStatement);

			System.out.println("OK added");
			connection.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}


	public static ArrayList findObjectByCharacterInName(String character, ArrayList<Product> products) {

		ArrayList arrayList = new ArrayList();

		products.forEach((product) -> {

			if (Recover.stringHasChar(character, product.getProductName())) {
				arrayList.add(product);
			}

		});


		return arrayList;
	}
	private static Boolean stringHasChar(String regex, String text) {
		return Pattern.matches(".*" + regex + ".*", text);
	}



	public static void savAndRecovery(){
		Connection connection =  GetConnection.getConnection();
		try {
			Statement statement =connection.createStatement();
			String queryData="INSERT INTO tbproduct (proName, proUnitPrice, proQty, importDate, status) SELECT proName, proUnitPrice, proQty, importDate, status FROM temp_table ORDER BY proID ASC";

		 		statement.executeUpdate(queryData);
		 		statement.executeUpdate("DELETE FROM temp_table");
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	public static void main(String[] args) throws SQLException {
		Recover.statementQueryer("SELECT * FROM Sql_table");
		Recover.insertion(new Product(0,"chan",12,19,"22/33/12"),"temp_table");
		Recover.savAndRecovery();
	}
}
