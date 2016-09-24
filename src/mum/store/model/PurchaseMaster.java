package mum.store.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;

public class PurchaseMaster {
	private DoubleProperty price;
    private IntegerProperty qty;
    private DoubleProperty itemAmount;
    private IntegerProperty pmasterId;
    private IntegerProperty itemId;
    private IntegerProperty pDetailId;
    
    public PurchaseMaster(){}
    
    public Double getPrice() {
        return price.get();
    }

    public void setPrice(Double price) {
        this.price.set(price);
    }

    public DoubleProperty priceProperty() {
        return price;
    }
    
    public Integer getQty() {
        return qty.get();
    }

    public void setQty(Integer qty) {
        this.qty.set(qty);
    }

    public IntegerProperty qtyProperty() {
        return qty;
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
    
    public Integer getPmasterId() {
        return pmasterId.get();
    }

    public void setPmasterId(Integer pmasterId) {
        this.pmasterId.set(pmasterId);
    }

    public IntegerProperty pMasterIdProperty() {
        return pmasterId;
    }
    
    public Integer getItemId() {
        return itemId.get();
    }

    public void setItemId(Integer itemId) {
        this.itemId.set(itemId);
    }

    public IntegerProperty itemIdProperty() {
        return itemId;
    }
    
    public Integer getPdetailId() {
        return pDetailId.get();
    }

    public void setPdetailId(Integer pDetailId) {
        this.pDetailId.set(pDetailId);
    }

    public IntegerProperty pDetailIdProperty() {
        return pDetailId;
    }
}
