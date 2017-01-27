package utility.graphics;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import utility.graphics.FXMLPanel;

/**
 * Generic panel imported from FXML file.
 * 
 * @author Manuel Gallina
 */
public class GenericFXPanel implements FXMLPanel 
{
	private AnchorPane root;
	
	/**
	 * Default constructor.
	 * 
	 * @param path The path of the FXML file.
	 * @throws IOException
	 */
	public GenericFXPanel(String path) throws IOException
	{
		this.importRoot(path);
	}
	
	/** @param root The root to set. */
	public void setRoot(AnchorPane root) { this.root = root; }
	
	@Override
	public void importRoot(String path) throws IOException
	{
		setRoot((AnchorPane)FXMLLoader.load(this.getClass().getResource(path)));
	}

	@Override
	public AnchorPane getRoot() { return this.root;	}
}
