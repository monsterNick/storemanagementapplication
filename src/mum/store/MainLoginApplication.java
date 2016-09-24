package mum.store;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainLoginApplication extends Application {

	private Stage primaryStage;
	private Pane rootLayout;
	private static MainLoginApplication instance;
	
	public static MainLoginApplication getMain()
	{
		return instance;
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("StoreManagementApplicationLogin");
		// Set the application icon.
	    this.primaryStage.getIcons().add(new Image("file:resources/images/mum-store.png"));   
		initRootLayout();
		instance = this;
	}
	
	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainLoginApplication.class.getResource("view/Login.fxml"));
			rootLayout = (Pane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			//primaryStage.setFullScreen(false);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    

	public static void main(String[] args) {
		launch(args);
	}
}
