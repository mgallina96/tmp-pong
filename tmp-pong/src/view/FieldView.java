package view;

import java.net.URL;

import javafx.geometry.Point3D;
import javafx.scene.PointLight;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import utility.geometry.geometry3d.Dimension3D;
import utility.graphics.graphicobject.Object3D;

/**
 * The field view.
 * 
 * @author Manuel Gallina
 */
public class FieldView 
{	
	private Box shape;
	private Object3D parent;
	
	private PhongMaterial shapeMaterial;
	private PhongMaterial innerMaterial;
	
	private PointLight light;
	private AmbientLight ambient;
	
	private static final String MESH_PATH = "/obj-models/FieldWire.obj";
	private static final double SCALE_FACTOR = 6.5;
	
	/**
	 * Constructor.
	 * 
	 * @param size The dimensions of the field.
	 * @param root The root node of the scene.
	 */
	public FieldView(Dimension3D size, Point3D position, Group root)
	{
		shape = new Box(size.getWidth(), size.getHeight(), size.getDepth());
		parent = new Object3D();
	
		shapeMaterial = new PhongMaterial(Color.BLUEVIOLET);
		innerMaterial = new PhongMaterial(Color.CORAL);
		
		light = new PointLight();
		ambient = new AmbientLight();
		
		URL objFileUrl = this.getClass().getResource(MESH_PATH);
		MeshView innerShape = parent.importObjMesh(objFileUrl);
				
		innerShape.setScaleX(SCALE_FACTOR);
		innerShape.setScaleY(SCALE_FACTOR);
		innerShape.setScaleZ(SCALE_FACTOR);
		innerShape.setTranslateX(0);
		innerShape.setTranslateY(10);
		innerShape.setTranslateZ(-405);
		innerShape.setDrawMode(DrawMode.FILL);
		innerShape.setCullFace(CullFace.FRONT);
		innerShape.setMaterial(innerMaterial);
		
		shape.setDrawMode(DrawMode.FILL);
		shape.setCullFace(CullFace.FRONT);
		shape.setMaterial(shapeMaterial);
		shape.setVisible(true);
		
		parent.setTranslateX(position.getX());
		parent.setTranslateY(position.getY());
		parent.setTranslateZ(position.getZ());
		
		parent.getChildren().addAll(shape, innerShape, light, ambient);
		root.getChildren().add(parent);
	}
}
