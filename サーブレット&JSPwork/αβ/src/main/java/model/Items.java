package model;

import java.io.Serializable;

public class Items implements Serializable {
	private String itemsId;
	private String itemsName;
	private String itemsExplain;
	private int itemsPrice;
	private String itemsImage;
	private String itemsType;
	private int itemsStock;
	public Items(String itemsId, String itemsName, String itemsExplain, int itemsPrice, String itemsImage,
			String itemsType, int itemsStock) {
		this.itemsId = itemsId;
		this.itemsName = itemsName;
		this.itemsExplain = itemsExplain;
		this.itemsPrice = itemsPrice;
		this.itemsImage = itemsImage;
		this.itemsType = itemsType;
		this.itemsStock = itemsStock;
	}
	public Items(String itemsId, String itemsName, int itemsPrice, String itemsType) {
		super();
		this.itemsId = itemsId;
		this.itemsName = itemsName;
		this.itemsPrice = itemsPrice;
		this.itemsType = itemsType;
	}
	public Items() {
	}
	public String getItemsId() {
		return itemsId;
	}
	public void setItemsId(String itemsId) {
		this.itemsId = itemsId;
	}
	public String getItemsName() {
		return itemsName;
	}
	public void setItemsName(String itemsName) {
		this.itemsName = itemsName;
	}
	public String getItemsExplain() {
		return itemsExplain;
	}
	public void setItemsExplain(String itemsExplain) {
		this.itemsExplain = itemsExplain;
	}
	public int getItemsPrice() {
		return itemsPrice;
	}
	public void setItemsPrice(int itemsPrice) {
		this.itemsPrice = itemsPrice;
	}
	public String getItemsImage() {
		return itemsImage;
	}
	public void setItemsImage(String itemsImage) {
		this.itemsImage = itemsImage;
	}
	public String getItemsType() {
		return itemsType;
	}
	public void setItemsType(String itemsType) {
		this.itemsType = itemsType;
	}
	public int getItemsStock() {
		return itemsStock;
	}
	public void setItemsStock(int itemsStock) {
		this.itemsStock = itemsStock;
	}
}
