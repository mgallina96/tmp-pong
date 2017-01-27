package controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import application.Settings;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.geometry.geometry3d.Dimension3D;
import view.View;

/**
 * The game panel.
 * 
 * @author Manuel Gallina
 */
public class Game 
{
	private static final int CORE_THREAD_POOL = 1;
	private ScheduledExecutorService executor;
	
	private Field field;
	private Ball ball;
	private Player player1;
	private Player player2;
	
	/**
	 * Constructor.
	 * 
	 * @param window The window.
	 */
	public Game(Stage window)
	{
		Group root = new Group();
		Scene scene = new Scene(root, Settings.RESOLUTION.getWidth(), Settings.RESOLUTION.getHeight());
		
		field = new Field(new Dimension3D(400, 400, 800), new Point3D(0, 0, 0), root);
		ball = new Ball(this, root);
		player1 = new Player(this, "p1", root);
		
		executor = Executors.newScheduledThreadPool(CORE_THREAD_POOL);
		executor.scheduleAtFixedRate(ball, 0, 17, TimeUnit.MILLISECONDS);
		executor.scheduleAtFixedRate(player1, 17, 17, TimeUnit.MILLISECONDS);
		
		scene.setCamera(new View(root).getCamera());
		window.setOnHiding(e -> exit());
		window.setScene(scene);
	}

	/** @return The field. */
	public Field getField() { return field;	}
	
	/** @return The ball. */
	public Ball getBall() { return ball; }
	
	/** @return The player 1. */
	public Player getPlayer1() { return player1; }
	
	/** @return The player 2. */
	public Player getPlayer2() { return player2; }
	
	/** Shuts down the executor service and exits the program. */
	public void exit() { executor.shutdownNow(); }
}
