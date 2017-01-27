package utility.graphics.graphicobject;

import java.net.URL;

import javafx.scene.shape.MeshView;

/**
 * This interface provides a method to import a mesh.
 * 
 * @author Manuel Gallina
 */
@FunctionalInterface
public interface ObjImporter 
{	
	/**
	 * Imports the mesh from an .obj file.
	 * 
	 * @param path The file path.
	 * @return The mesh.
	 */
	public MeshView importObjMesh(URL path);
}
