package controller;

import javafx.scene.Group;
import model.PlayerModel;
import view.PlayerView;

/**
 * The player.
 *  
 * @author Manuel Gallina
 */
public class Player implements Runnable
{
	private PlayerModel model;
	private PlayerView view;
	private Game game;
	
	public Player(Game game, String tag, Group root)
	{
		this.game = game;
		
		model = new PlayerModel(this, tag);
		view = new PlayerView(model.getSize(), model.getPosition(), root);
	}
	
	@Override
	public void run() {
		view.moveTo(model.updatePosition());
	}	
	
	/** @return The current game. */
	public Game getGame() { return game; }
}
