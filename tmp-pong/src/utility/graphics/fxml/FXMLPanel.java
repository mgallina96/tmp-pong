package utility.graphics;

import java.io.IOException;

import javafx.scene.layout.AnchorPane;

/**
 * Interface for the JavaFX FXML management.
 * 
 * @author Manuel Gallina
 */
public interface FXMLPanel 
{
	/**
	 * Imports the root element for the panel.
	 * 
	 * The path root folder is the root 'src' folder. 
	 * 
	 * @param path The path of the FXML file.
	 * @throws IOException
	 */
	public void importRoot(String path) throws IOException;
	
	/** @return The root element. */
	public AnchorPane getRoot();
}
