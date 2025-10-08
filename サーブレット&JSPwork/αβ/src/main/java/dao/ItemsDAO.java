package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Items;

public class ItemsDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/abdb?characterEncoding=UTF-8"; 
	private final String DB_USER = "root";
	private final String DB_PASS = "";
	
	public List<Items> findAll() {
		List<Items> itemsList = new ArrayList<>();
		//JDBCドライバを読み込み
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER,DB_PASS)){
			//SELECT文を準備
			String sql = "SELECT itemsId,itemsName,itemsExplain,itemsPrice,itemsImage,itemsType,itemsStock FROM Items";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			//結果表に格納されたレコードの内容をEmployeeインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				String itemsId = rs.getString("itemsId");
				String itemsName = rs.getString("itemsName");
				String itemsExplain = rs.getString("itemsExplain");
				int itemsPrice = rs.getInt("itemsPrice");
				String itemsImage = rs.getString("itemsImage");
				String itemsType = rs.getString("itemsType");
				int itemsStock = rs.getInt("itemsStock");
				Items item = new Items(itemsId,itemsName,itemsExplain,itemsPrice,itemsImage,itemsType,itemsStock);
				itemsList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return itemsList;
	}
	public boolean create (Items item) {
		//JDBCドライバを読み込み
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER,DB_PASS)){
			//INSERT文を準備
			String sql = "INSERT INTO Items(itemsId,itemsName,itemsExplain,itemsPrice,itemsImage,itemsType,itemsStock) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//INSERT文の中の「?」に使用する値を設定してＳＱＬ文を完成
			pStmt.setString(1,item.getItemsId());
			pStmt.setString(2, item.getItemsName());
			pStmt.setString(3, item.getItemsExplain());
			pStmt.setInt(4, item.getItemsPrice());
			pStmt.setString(5, item.getItemsImage());
			pStmt.setString(6, item.getItemsType());
			pStmt.setInt(7, item.getItemsStock());
			
			//INSERT文を実行
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
