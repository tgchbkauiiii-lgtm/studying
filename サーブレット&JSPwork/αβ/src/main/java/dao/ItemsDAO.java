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
	public List<Items> findByWomenType(String womenItemsType) {
        List<Items> womenTypeList = new ArrayList<>();
      //JDBCドライバを読み込み
  		try {
  			Class.forName("com.mysql.jdbc.Driver");
  		} catch (ClassNotFoundException e) {
  			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
  		}
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM items WHERE itemsType = ? AND itemsId LIKE 'W%'";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, womenItemsType);

            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                Items item = new Items();
                item.setItemsId(rs.getString("itemsId"));
                item.setItemsName(rs.getString("itemsName"));
                item.setItemsExplain(rs.getString("itemsExplain"));
                item.setItemsPrice(rs.getInt("itemsPrice"));
                item.setItemsImage(rs.getString("itemsImage"));
                item.setItemsType(rs.getString("itemsType"));
                item.setItemsStock(rs.getInt("itemsStock"));
                womenTypeList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return womenTypeList;
    }
	public List<Items> findByMenType(String menItemsType) {
        List<Items> menTypeList = new ArrayList<>();
      //JDBCドライバを読み込み
  		try {
  			Class.forName("com.mysql.jdbc.Driver");
  		} catch (ClassNotFoundException e) {
  			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
  		}
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM items WHERE itemsType = ? AND itemsId LIKE 'M%';";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, menItemsType);

            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                Items item = new Items();
                item.setItemsId(rs.getString("itemsId"));
                item.setItemsName(rs.getString("itemsName"));
                item.setItemsExplain(rs.getString("itemsExplain"));
                item.setItemsPrice(rs.getInt("itemsPrice"));
                item.setItemsImage(rs.getString("itemsImage"));
                item.setItemsType(rs.getString("itemsType"));
                item.setItemsStock(rs.getInt("itemsStock"));
                menTypeList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menTypeList;
    }
	public List<Items> findByKeyword(String keyword) {
	    List<Items> keywordList = new ArrayList<>();
	    //JDBCドライバを読み込み
  		try {
  			Class.forName("com.mysql.jdbc.Driver");
  		} catch (ClassNotFoundException e) {
  			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
  		}
	    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        String sql = "SELECT * FROM items WHERE itemsName LIKE ?";
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, "%" + keyword + "%");

	        ResultSet rs = pStmt.executeQuery();
	        while (rs.next()) {
	            Items item = new Items();
	            item.setItemsId(rs.getString("itemsId"));
                item.setItemsName(rs.getString("itemsName"));
                item.setItemsExplain(rs.getString("itemsExplain"));
                item.setItemsPrice(rs.getInt("itemsPrice"));
                item.setItemsImage(rs.getString("itemsImage"));
                item.setItemsType(rs.getString("itemsType"));
                item.setItemsStock(rs.getInt("itemsStock"));
	            keywordList.add(item);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return keywordList;
	}
	public List<Items> findByGender(String gender) {
	    List<Items> genderList = new ArrayList<>();
	    // ★修正1: genderがnullの場合は処理をスキップし、空のリストを返す
	    if (gender == null) {
	        return genderList;
	    }
	    //JDBCドライバを読み込み
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
	    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        String sql = null;
	        String prefix = null;
	        // ★修正2: 文字列比較に equals() を使用
	    	if ("women".equals(gender)) {
	            prefix = "W%";
	        } else if ("men".equals(gender)){
	            prefix = "M%";
	        } 
	        if (prefix != null) {
	            // ★修正3: LIKE句もパラメータ化（?）を使用し、安全性を確保
	            sql = "SELECT * FROM items WHERE itemsId LIKE ?";
	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            
	            // パラメータを設定
	            pStmt.setString(1, prefix);

	            ResultSet rs = pStmt.executeQuery();
	            while (rs.next()) {
	                // ... (中略：結果セットの取得処理はそのまま)
	                Items item = new Items();
		            item.setItemsId(rs.getString("itemsId"));
	                item.setItemsName(rs.getString("itemsName"));
	                item.setItemsExplain(rs.getString("itemsExplain"));
	                item.setItemsPrice(rs.getInt("itemsPrice"));
	                item.setItemsImage(rs.getString("itemsImage"));
	                item.setItemsType(rs.getString("itemsType"));
	                item.setItemsStock(rs.getInt("itemsStock"));
		            genderList.add(item);
	            }
	        } else {
	        	// genderに想定外の値が来た場合は処理しない
	        	System.out.println("ItemsDAOのfindByGender()メソッドに予期せぬ値が渡されました。");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return genderList;
	}
	public boolean delete (Items item) {
		//JDBCドライバを読み込み
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER,DB_PASS)){
			//INSERT文を準備
			String sql = "DELETE WHERE itemsId = ?";
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
	public List<Items> findByRanking () {
		 List<Items> rankingList = new ArrayList<>();
		    //JDBCドライバを読み込み
	  		try {
	  			Class.forName("com.mysql.jdbc.Driver");
	  		} catch (ClassNotFoundException e) {
	  			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	  		}
		    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		        String sql = "SELECT * FROM items JOIN ranking ON items.itemsId = ranking.itemsId ORDER BY ranking.sales DESC LIMIT 3";
		        PreparedStatement pStmt = conn.prepareStatement(sql);

		        ResultSet rs = pStmt.executeQuery();
		        while (rs.next()) {
		            Items item = new Items();
		            item.setItemsId(rs.getString("itemsId"));
	                item.setItemsName(rs.getString("itemsName"));
	                item.setItemsExplain(rs.getString("itemsExplain"));
	                item.setItemsPrice(rs.getInt("itemsPrice"));
	                item.setItemsImage(rs.getString("itemsImage"));
	                item.setItemsType(rs.getString("itemsType"));
	                item.setItemsStock(rs.getInt("itemsStock"));
		            rankingList.add(item);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return rankingList;
	}
	public List<Items> findByRecommend () {
		 List<Items> recommendList = new ArrayList<>();
		    //JDBCドライバを読み込み
	  		try {
	  			Class.forName("com.mysql.jdbc.Driver");
	  		} catch (ClassNotFoundException e) {
	  			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	  		}
		    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		        String sql = "SELECT * FROM items AS i JOIN recommend AS r ON i.itemsId = r.itemsId GROUP BY r.itemsId";
		        PreparedStatement pStmt = conn.prepareStatement(sql);

		        ResultSet rs = pStmt.executeQuery();
		        while (rs.next()) {
		            Items item = new Items();
		            item.setItemsId(rs.getString("itemsId"));
	                item.setItemsName(rs.getString("itemsName"));
	                item.setItemsExplain(rs.getString("itemsExplain"));
	                item.setItemsPrice(rs.getInt("itemsPrice"));
	                item.setItemsImage(rs.getString("itemsImage"));
	                item.setItemsType(rs.getString("itemsType"));
	                item.setItemsStock(rs.getInt("itemsStock"));
		            recommendList.add(item);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return recommendList;
	}
	public List<String> findAllTypes () {
		 List<String> allTypesList = new ArrayList<>();
		    //JDBCドライバを読み込み
	  		try {
	  			Class.forName("com.mysql.jdbc.Driver");
	  		} catch (ClassNotFoundException e) {
	  			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	  		}
		    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		        String sql = "SELECT DISTINCT itemsType FROM items";
		        PreparedStatement pStmt = conn.prepareStatement(sql);

		        ResultSet rs = pStmt.executeQuery();
		        while (rs.next()) {
		        	String itemsType = rs.getString("itemsType");
		            allTypesList.add(itemsType);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return allTypesList;
	}
}

