package controller;

import javafx.geometry.Point3D;
import javafx.scene.Group;
import utility.geometry.geometry3d.Dimension3D;
import view.FieldView;

/**
 * The game field.
 * 
 * @author Manuel Gallina
 */
public class Field 
{
	private Dimension3D size = new Dimension3D(400, 400, 800);
	private Point3D position = new Point3D(0, 0, 0);
	
	/**
	 * Constructor.
	 * 
	 * @param root The root node of the scene.
	 */
	public Field(Dimension3D size, Point3D position, Group root)
	{
		new FieldView(size, position, root);
	}
	
	/** @return The field size. */
	public Dimension3D getSize() { return size; }
	
	/** @return The field position. */
	public Point3D getPosition() {return position; }
}
