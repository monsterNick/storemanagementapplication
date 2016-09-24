package mum.store.controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mum.store.MainLoginApplication;

public class LogInController {

    @FXML
    private PasswordField fx_passWord;

    @FXML
    private TextField fx_userName;

    @FXML
    private void onLogInClick(ActionEvent event) {
    	try {	
    		
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainLoginApplication.class.getResource("view/RootLayout.fxml"));
			BorderPane page = (BorderPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("StoreManagementApplication");
			// Set the application icon.
			dialogStage.getIcons().add(new Image("file:resources/images/mum-store.png"));  
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(MainLoginApplication.getMain().getPrimaryStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			dialogStage.setFullScreen(true);

			MainAppController mainAppController = loader.getController();
			mainAppController.setDialogStage(dialogStage);
			// setProduct(tempProduct);
			MainLoginApplication.getMain().getPrimaryStage().hide();
			dialogStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
