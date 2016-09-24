package mum.store.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mum.store.model.Employee;

public class EmployeeController implements Initializable {
	@FXML
	private TextField empNameTextField;
	@FXML
	private TextField empAddressTextField;
	@FXML
	private TextField empEmailTextField;
	@FXML
	private TextField empUserNameTextField;
	@FXML
	private PasswordField empPasswordTextField;
	@FXML
	private ComboBox<String> empRoleComboField;

	public EmployeeController() {
		
	}

	private Stage dialogStage;
	private Employee employee;
	private ObservableList<String> roleItems;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void handleClear() {
		empNameTextField.setText("");
		empAddressTextField.setText("");
		empEmailTextField.setText("");
		empUserNameTextField.setText("");
		empPasswordTextField.setText("");
		empRoleComboField.setValue(roleItems.get(0));
	}

	@FXML
	private void handleSave() {
		employee = new Employee();
		employee.setEmpName(empNameTextField.getText());
		employee.setEmpAddress(empAddressTextField.getText());
		employee.setEmpEmail(empEmailTextField.getText());
		employee.setUserName(empUserNameTextField.getText());
		employee.setPassword(empPasswordTextField.getText());
		employee.setRoleId(empRoleComboField.getSelectionModel().getSelectedIndex());
		dialogStage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		roleItems = FXCollections.observableArrayList("Cashier", "Store Manager");
		empRoleComboField.getItems().addAll(roleItems);
		empRoleComboField.setValue(roleItems.get(0));
	}
}
