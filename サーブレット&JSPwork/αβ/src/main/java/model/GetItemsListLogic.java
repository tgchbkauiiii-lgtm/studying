package model;

import java.util.List;

import dao.ItemsDAO;

public class GetItemsListLogic {
	public List<Items> execute() {
		ItemsDAO dao = new ItemsDAO();
		List<Items> itemsList = dao.findAll();
		return itemsList;
	}
}
