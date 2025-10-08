package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeesDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/example?characterEncoding=UTF-8"; 
	private final String DB_USER = "root";
	private final String DB_PASS = "";
	
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		//JDBCドライバを読み込み
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER,DB_PASS)){
			//SELECT文を準備
			String sql = "SELECT ID,NAME,AGE FROM employees";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			//結果表に格納されたレコードの内容をEmployeeインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
}
