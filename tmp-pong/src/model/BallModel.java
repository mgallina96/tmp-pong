package model;

import controller.Ball;
import javafx.geometry.Point3D;

/**
 * The ball model.
 * 
 * @author Manuel Gallina
 */
public class BallModel 
{	
	private static final double RADIUS = 30.0;

	private Point3D position;
	private Point3D direction;
	private double speed;
	
	private double left;
	private double right;
		
	private double top;
	private double bottom;
	
	private double front;
	private double back;
	
	/**
	 * Constructor.
	 */
	public BallModel(Ball controller)
	{
		position = new Point3D(0, 0, 0);
		direction = new Point3D(Math.random() * 100 - 50, Math.random() * 100 - 50, Math.random() * 100 - 50);
		speed = 10;
		
		left = -controller.getGame().getField().getSize().getWidth()/2 + controller.getGame().getField().getPosition().getX() + RADIUS/2;
		right = controller.getGame().getField().getSize().getWidth()/2 + controller.getGame().getField().getPosition().getX() - RADIUS/2;
		
		top = controller.getGame().getField().getSize().getHeight()/2 + controller.getGame().getField().getPosition().getY() - RADIUS/2;
		bottom = -controller.getGame().getField().getSize().getHeight()/2 + controller.getGame().getField().getPosition().getY() + RADIUS/2;
		
		front = controller.getGame().getField().getSize().getDepth()/2 + controller.getGame().getField().getPosition().getZ() - RADIUS/2;
		back = -controller.getGame().getField().getSize().getDepth()/2 + controller.getGame().getField().getPosition().getZ() + RADIUS/2;
	}
	
	/** @return The RADIUS. */
	public double getRadius() {	return RADIUS; }

	/** @return The position. */
	public Point3D getPosition() { return position;	}
	
	/**
	 * Calculates the position of the ball in the next frame.
	 * 
	 * @return The next position
	 */
	public Point3D updatePosition()
	{
		double l = direction.getX();
		double m = direction.getY();
		double n = direction.getZ();
		
		double k = speed/Math.sqrt(n*n + m*m + l*l);
		
		double x = l*k + position.getX();
		double y = m*k + position.getY();
		double z = n*k + position.getZ();
		
		if(x > right) { x = right; l = -l; direction = new Point3D(l, m, n); }
		if(x < left) { x = left; l = -l; direction = new Point3D(l, m, n); }
		
		if(y > top) { y = top; m = -m; direction = new Point3D(l, m, n); }
		if(y < bottom) { y = bottom; m = -m; direction = new Point3D(l, m, n); }
		
		if(z > front) { z = front; n = -n; direction = new Point3D(l, m, n); }
		if(z < back) { z = back; n = -n; direction = new Point3D(l, m, n); }
		
		position = new Point3D(x, y, z);
		
		return position;
	}
}
