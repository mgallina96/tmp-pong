package view;

import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import utility.geometry.geometry3d.Dimension3D;
import utility.graphics.graphicobject.Object3D;

/**
 * @author Manuel Gallina
 *
 */
public class PlayerView 
{
	private Object3D parent;
	
	public PlayerView(Dimension3D size, Point3D position, Group root)
	{
		PhongMaterial material = new PhongMaterial(Color.GREEN);
		
		Box shape = new Box(size.getWidth(), size.getHeight(), size.getDepth());
		parent = new Object3D();
				
		material.setSpecularColor(Color.GREEN);
		
		shape.setOpacity(0.1);
		shape.setMaterial(material);
		shape.setDrawMode(DrawMode.FILL);
		
		parent.setPosition(position);
		parent.getChildren().add(shape);
		root.getChildren().add(parent);
	}
	
	/**
	 * Moves the player to the new position.
	 * 
	 * @param position The new position.
	 */
	public void moveTo(Point3D position)
	{
		parent.setPosition(position);
	}
}
