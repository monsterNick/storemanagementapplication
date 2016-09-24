package mum.store.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.prism.impl.Disposer.Record;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import mum.store.model.Product;

public class SaleController implements Initializable {

    @FXML
    private TextField saleBillNumberTextField;

    @FXML
    private DatePicker saleBillDate;

    @FXML
    private TableView<Product> sale_TableView = new TableView<>();

    @FXML
    private TextField saleQuatityTextField;

    @FXML
    private TextField salePriceTExtField;

    @FXML
    private TextField sale_totalAmount;
    
	@FXML
	private ComboBox<Product> itemNameComboField;
	@FXML
	private Label itemIdHiddenLabel;
	@FXML
	private TableColumn<Product, String> itemName = new TableColumn<>();
	@FXML
	private TableColumn<Product, Integer> qty = new TableColumn<>();
	@FXML
	private TableColumn<Product, String> price = new TableColumn<>();
	@FXML
	private TableColumn<Product, String> amount = new TableColumn<>();
	@FXML
	private TableColumn<Product, String> itemId = new TableColumn<>();
	@FXML
	private TableColumn<Record, Boolean> deleteCol = new TableColumn<>("Delete");
    
	private ObservableList<Product> products;

	private ObservableList<Product> saleItems;
	
	public SaleController() {
	}

	public void initialize(URL url, ResourceBundle resources) {
		products = FXCollections.observableArrayList(new Product("test", "CC1", 90.0, Long.parseLong("1")),
				new Product("tast", "CC2", 40.0, Long.parseLong("2")));
		itemNameComboField.getItems().addAll(products);
		itemNameComboField.getSelectionModel().selectFirst();

		itemNameComboField.setCellFactory(new Callback<ListView<Product>, ListCell<Product>>() {
			@Override
			public ListCell<Product> call(ListView<Product> arg0) {
				final ListCell<Product> cell = new ListCell<Product>() {
					@Override
					protected void updateItem(Product t, boolean bln) {
						super.updateItem(t, bln);

						if (t != null) {
							setText(t.getItemName());
						} else {
							setText(null);
						}
					}
				};
				return cell;
			}
		});

		itemNameComboField.valueProperty().addListener(new ChangeListener<Product>() {
			@Override
			public void changed(ObservableValue<? extends Product> observable, Product oldValue, Product newValue) {
				salePriceTExtField.setText(newValue.getPrice().toString());
			}
		});

		saleItems = FXCollections.observableArrayList();

		itemName.setCellValueFactory(new PropertyValueFactory<Product, String>("itemName"));

		qty.setCellValueFactory(new PropertyValueFactory<Product, Integer>("itemQty"));

		price.setCellValueFactory(new PropertyValueFactory<Product, String>("price"));

		amount.setCellValueFactory(new PropertyValueFactory<Product, String>("itemAmount"));

		itemId.setCellValueFactory(new PropertyValueFactory<Product, String>("itemId"));

		deleteCol.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Record, Boolean>, ObservableValue<Boolean>>() {

					@Override
					public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
						return new SimpleBooleanProperty(p.getValue() != null);
					}
				});

		// Adding the Button to the cell
		deleteCol.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

			@Override
			public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
				return new ButtonCell();
			}

		});

		sale_TableView.setItems(saleItems);
	}
	
	// Define the button cell
		private class ButtonCell extends TableCell<Record, Boolean> {
			final Button cellButton = new Button("Delete");

			ButtonCell() {

				// Action when the button is pressed
				cellButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent t) {
						// get Selected Item
						Product currentProduct = (Product) ButtonCell.this.getTableView().getItems()
								.get(ButtonCell.this.getIndex());
						// remove selected item from the table list
						if (!sale_totalAmount.getText().isEmpty()) {
							Double newTotal = Double.parseDouble(sale_totalAmount.getText())
									- currentProduct.getItemAmount();
							saleItems.remove(currentProduct);
							sale_totalAmount.setText(newTotal.toString());
						}
					}
				});
			}

			// Display button if the row is not empty
			@Override
			protected void updateItem(Boolean t, boolean empty) {
				super.updateItem(t, empty);
				if (!empty) {
					setGraphic(cellButton);
				} else {
					setGraphic(null);
				}
			}
		}

	private Stage dialogStage;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public Stage getDialogStage() {
		return dialogStage;
	}
	
	@FXML
	private void handleSave() {
		System.out.println(saleQuatityTextField.getText());
		System.out.println("ok" + itemNameComboField.getSelectionModel().getSelectedItem().getItemName());
		Product product = itemNameComboField.getSelectionModel().getSelectedItem();
		product.setItemQty(Integer.parseInt(saleQuatityTextField.getText()));
		System.out.println(product.getItemQty());
		product.setItemAmount(product.getItemQty() * product.getPrice());

		Double total;
		if (sale_totalAmount.getText().isEmpty()) {
			total = product.getItemAmount();
		} else {
			total = product.getItemAmount() + Double.parseDouble(sale_totalAmount.getText());
		}

		sale_totalAmount.setText(total.toString());
		saleItems.add(product);
	}
}
