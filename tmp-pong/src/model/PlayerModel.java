package model;

import controller.Player;
import javafx.geometry.Point3D;
import utility.geometry.geometry3d.Dimension3D;

/**
 * @author Manuel Gallina
 *
 */
public class PlayerModel
{
	private static final Dimension3D SIZE = new Dimension3D(60, 60, 10);
	
	private Tag tag;
	
	private Point3D position;
	private Point3D target;
	private double speed;
	
	private double left;
	private double right;
		
	private double top;
	private double bottom;
		
	private enum Tag
	{
		P1(new Point3D(0,0,-370)), P2(new Point3D(0,0,370));
		
		private Point3D position;
		
		private Tag(Point3D position) {	this.position = position; }
		
		/** @return The position. */
		public Point3D getPosition() { return position; }
	}
	
	public PlayerModel(Player controller, String tag)
	{		
		left = -controller.getGame().getField().getSize().getWidth()/2 + controller.getGame().getField().getPosition().getX() + SIZE.getWidth()/2;
		right = controller.getGame().getField().getSize().getWidth()/2 + controller.getGame().getField().getPosition().getX() - SIZE.getWidth()/2;
		
		top = controller.getGame().getField().getSize().getHeight()/2 + controller.getGame().getField().getPosition().getY() - SIZE.getHeight()/2;
		bottom = -controller.getGame().getField().getSize().getHeight()/2 + controller.getGame().getField().getPosition().getY() + SIZE.getHeight()/2;
				
		switch(tag)
		{
		case "p1": position = Tag.P1.getPosition(); this.tag = Tag.P1; break;
		case "p2": position = Tag.P2.getPosition(); this.tag = Tag.P2; break;
		default: position = Tag.P1.getPosition();
		}

		target = new Point3D(-100,100,0);
		speed = 0.1;
	}
	
	public Dimension3D getSize() { return SIZE; }
	
	public Point3D getPosition() { return position; }
	
	public Point3D updatePosition()
	{	
		double l = target.getX() - position.getX();
		double m = target.getY() - position.getY();
		double k;
		
		if(m != 0 && l != 0)
		{
			k = speed/Math.sqrt(m*m + l*l);
			
			double x = l*k + position.getX();
			double y = m*k + position.getY();
						
			if(x > right) { x = right; }
			if(x < left) { x = left; }
			
			if(y > top) { y = top; }
			if(y < bottom) { y = bottom; }
			
			position = new Point3D(x, y, tag.getPosition().getZ());
		}
				
		return position;
	}
}
