import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.*;

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
			if (connection != null) {
				System.out.println("connected");

			}
		GetConnection getConnection = new GetConnection();
		getConnection.copyTable();
		getConnection.updateDescriptionAndAuthor(connection,10);

		//getConnection.writeExampleRecords();
		System.out.println(	getConnection.getProduct(10));
		getConnection.saveToDB();
	}
	private boolean  copyTable(){
		String sqlCheck ="CREATE TABLE IF NOT EXISTS temp_table LIKE tbproduct;";
		String sqlCopy ="INSERT temp_table\n" +
				"SELECT * FROM tbproduct;";
		String sqlDelete = "DELETE FROM temp_table";
		try {
			Statement checkStatement = GetConnection.getConnection().createStatement();
		boolean i =	checkStatement.execute(sqlCheck);
			System.out.println(i);
			if (i){
				System.out.println("creating table please wait");
			}else {
				Statement reMoveStatement = GetConnection.getConnection().createStatement();
				reMoveStatement.execute(sqlDelete);
				Statement copyStatement = GetConnection.getConnection().createStatement();
				copyStatement.execute(sqlCopy);
			}



		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}


		return true;
 	}
	public  void updateDescriptionAndAuthor(Connection conn,int id)

	{
		try
		{
			// create our java preparedstatement using a sql update query
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE temp_table SET proName = ?, proUnitPrice = ?,proQty=? WHERE proID = ? ");

			// set the preparedstatement parameters
			ps.setString(1,"colo2");
			ps.setDouble(2,12);
			ps.setInt(3,10);
			ps.setInt(4,id);

			// call executeUpdate to execute our sql update statement
			ps.executeUpdate();
			ps.close();
		}
		catch (SQLException se)
		{
			// log the exception

		}
	}

	public boolean insertStudent(Product product) {
		Connection connection = GetConnection.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO tbproduct VALUES ( ?,?, ?, ?,?)");
			ps.setInt(1, product.getProductID());
			ps.setString(2, product.getProductName());
			ps.setDouble(3, product.getUnitPrice());
			ps.setInt(4, product.getQuantity());
			ps.setString(5, product.getImportDate());
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

		for (int i = 1; i <= 100; i++) {
			insertStudent((new Product(0, "fanta", 10, 15, "22/09/2019")));

		}


	}


	public void saveToDB(){

		String sqlCopy ="INSERT tbproduct\n" +
				"SELECT * FROM temp_table;";
		String sqlDelete = "DELETE FROM tbproduct";
		try {
 				Statement reMoveStatement = GetConnection.getConnection().createStatement();
				reMoveStatement.execute(sqlDelete);
				Statement copyStatement = GetConnection.getConnection().createStatement();
				copyStatement.execute(sqlCopy);

 			} catch (SQLException e) {
			e.printStackTrace();


		}
	}


}
