package mum.store.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Product {
	
	private StringProperty itemName;
    private StringProperty itemCode;
    private DoubleProperty price;
    private LongProperty itemId;
    private IntegerProperty itemQty;
    private DoubleProperty itemAmount;
    
    public Product(String itemName, String itemCode, Double price, Long itemId) {
        this.itemName = new SimpleStringProperty(itemName);
        this.itemCode = new SimpleStringProperty(itemCode);
        this.price = new SimpleDoubleProperty(price);
        this.itemId = new SimpleLongProperty(itemId);
        this.itemQty = new SimpleIntegerProperty(0);
        this.itemAmount = new SimpleDoubleProperty(0);
    }
    
    public Product()
    { }
    
    @Override
    public String toString() {
        return getItemName();
    }
    
    public Integer getItemQty() {
        return itemQty.get();
    }

    public void setItemQty(Integer qty) {
        this.itemQty.set(qty);
    }

    public IntegerProperty itemQtyProperty() {
        return itemQty;
    }
    
    public Double getItemAmount() {
        return itemAmount.get();
    }

    public void setItemAmount(Double itemAmount) {
        this.itemAmount.set(itemAmount);
    }

    public DoubleProperty itemAmountProperty() {
        return itemAmount;
    }
    
    public String getItemName() {
        return itemName.get();
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public StringProperty itemNameProperty() {
        return itemName;
    }
    
    public String getItemCode() {
        return itemCode.get();
    }

    public void setItemCode(String itemCode) {
        this.itemCode.set(itemCode);
    }

    public StringProperty itemCodeProperty() {
        return itemCode;
    }
    
    public Double getPrice() {
        return price.get();
    }

    public void setPrice(Double price) {
        this.price.set(price);
    }

    public DoubleProperty priceProperty() {
        return price;
    }
    
    public Long getItemId() {
        return itemId.get();
    }

    public void setItemId(Long itemId) {
        this.itemId.set(itemId);
    }

    public LongProperty itemIdProperty() {
        return itemId;
    }
}
