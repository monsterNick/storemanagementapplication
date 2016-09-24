package mum.store.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mum.store.model.Product;

public class ProductController {
	@FXML
	private TextField itemNameTextField;
	@FXML
	private TextField itemCodeTextField;
	@FXML
	private TextField itemPriceTextField;
	@FXML
	private TextField itemIdTextField;

	private Stage dialogStage;
	private Product product;

	public ProductController() {

	}

	@FXML
	private void initialize() {

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	// use this in case of update
//	public void setProduct(Product product) {
//		if (product != null) {
//			this.product = product;
//			itemNameTextField.setText(product.getItemName());
//			itemCodeTextField.setText(product.getItemCode());
//			itemPriceTextField.setText(product.getPrice().toString());
//			itemIdTextField.setText(product.getItemId().toString());
//		}
//	}

//	public boolean isBtnClicked() {
//		return btnClicked;
//	}

	@FXML
	private void handleClear() {
		//dialogStage.close();
		itemNameTextField.setText("");
		itemCodeTextField.setText("");
		itemPriceTextField.setText("");
	}

	@FXML
	private void handleSave() {
		product = new Product(itemNameTextField.getText(),"bibek",30.0,Long.parseLong("66"));
		//product.setItemName(itemNameTextField.getText());
		//product.setItemCode(itemCodeTextField.getText());
//		product.setItemId((Long.parseLong(itemIdTextField.getText())));
//		product.setPrice(Double.parseDouble(itemPriceTextField.getText()));
//		//btnClicked = true;
		dialogStage.close();
	}

}
