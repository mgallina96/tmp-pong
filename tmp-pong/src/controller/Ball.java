package controller;

import javafx.scene.Group;
import model.BallModel;
import view.BallView;

/**
 * The Ball.
 * 
 * @author Manuel Gallina
 */
public class Ball implements Runnable
{
	private BallModel model;
	private BallView view;
	private Game game;
	
	/**
	 * Constructor.
	 * 
	 * @param root The root node of the game scene.
	 */
	public Ball(Game game, Group root)
	{
		this.game = game;
		
		model = new BallModel(this);
		view = new BallView(model.getRadius(), root);
	}
	
	@Override
	public void run() {
		view.moveTo(model.updatePosition());
	}	
	
	/** @return The current game. */
	public Game getGame() { return game; }
}
