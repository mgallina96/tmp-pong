package application;

import controller.Game;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Main menu of the application.
 * Singleton class.
 * 
 * @author Manuel Gallina
 */
public class MainMenu 
{
	private static MainMenu instance;
	private Scene scene;
	
	private MainMenu(Stage window) 
	{
		AnchorPane root = new AnchorPane();
		
		scene = new Scene(root, Settings.RESOLUTION.getWidth(), Settings.RESOLUTION.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Button btn = new Button("Start");
		btn.setOnAction(e -> new Game(window));
			
		root.getChildren().add(btn);
		
		window.setScene(scene);
		window.show();
	}
	
	/** @return The instance of the main menu.*/
	public static MainMenu getInstance(Stage window)
	{
		if(instance == null)
			instance = new MainMenu(window);
		return instance;
	}
	
	/**
	 * Changes the scene to show the main menu.
	 * 
	 * @param window The window.
	 */
	public static void show(Stage window) {
		window.setScene(getInstance(window).scene);
	}
}
